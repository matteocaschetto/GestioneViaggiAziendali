package com.epicode.GestioneViaggiAziendali.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.mapper.DipendenteMapper;
import com.epicode.GestioneViaggiAziendali.payload.DipendenteDTO;
import com.epicode.GestioneViaggiAziendali.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private Cloudinary cloudinary;


    @PostMapping("/nuovoDipendenteConAvatar")
    public ResponseEntity<Dipendente> nuovoDipendenteConAvatar(@RequestPart("avatarDipendente") MultipartFile avatarDipendente, @RequestBody @Validated DipendenteDTO dipendenteDTO, BindingResult validazione){

        if(validazione.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Map mappa = cloudinary.uploader().upload(avatarDipendente.getBytes(), ObjectUtils.emptyMap());
            String urlImage = (String) mappa.get("secure_url");
            dipendenteDTO.setImmagineProfilo(urlImage);

            Dipendente dipendente = DipendenteMapper.mapToEntity(dipendenteDTO);
            Dipendente savedDipendente = dipendenteService.saveDipendente(dipendente);

            return new ResponseEntity<>(savedDipendente, HttpStatus.CREATED);

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        Dipendente dipendente = dipendenteService.getDipendenteById(id);
        if (dipendente != null) {
            return new ResponseEntity<>(dipendente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteDipendente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
