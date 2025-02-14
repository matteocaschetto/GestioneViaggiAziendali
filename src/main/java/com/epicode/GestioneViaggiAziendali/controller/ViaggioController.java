package com.epicode.GestioneViaggiAziendali.controller;

import com.epicode.GestioneViaggiAziendali.entity.StatoViaggio;
import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import com.epicode.GestioneViaggiAziendali.mapper.ViaggioMapper;
import com.epicode.GestioneViaggiAziendali.payload.ViaggioDTO;
import com.epicode.GestioneViaggiAziendali.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    public ResponseEntity<Viaggio> createViaggio(@RequestBody ViaggioDTO viaggioDTO) {
        Viaggio viaggio = ViaggioMapper.mapToEntity(viaggioDTO);
        Viaggio savedViaggio = viaggioService.saveViaggio(viaggio);
        return new ResponseEntity<>(savedViaggio, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        Viaggio viaggio = viaggioService.getViaggioById(id);
        if (viaggio != null) {
            return new ResponseEntity<>(viaggio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/stato")
    public ResponseEntity<Viaggio> updateStatoViaggio(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        Viaggio viaggio = viaggioService.updateStatoViaggio(id, stato);
        return new ResponseEntity<>(viaggio, HttpStatus.OK);
    }

}