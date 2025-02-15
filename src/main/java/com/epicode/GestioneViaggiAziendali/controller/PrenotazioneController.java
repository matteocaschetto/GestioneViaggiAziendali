package com.epicode.GestioneViaggiAziendali.controller;

import com.epicode.GestioneViaggiAziendali.entity.Prenotazione;
import com.epicode.GestioneViaggiAziendali.mapper.PrenotazioneMapper;
import com.epicode.GestioneViaggiAziendali.payload.PrenotazioneDTO;
import com.epicode.GestioneViaggiAziendali.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/prenotazione")
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody PrenotazioneDTO prenotazioneDTO) {
        Prenotazione prenotazione = PrenotazioneMapper.mapToEntity(prenotazioneDTO);
        Prenotazione savedPrenotazione = prenotazioneService.savePrenotazione(prenotazione);
        return new ResponseEntity<>(savedPrenotazione, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Prenotazione prenotazione = prenotazioneService.getPrenotazioneById(id);
        if (prenotazione != null) {
            return new ResponseEntity<>(prenotazione, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deletePrenotazione(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}