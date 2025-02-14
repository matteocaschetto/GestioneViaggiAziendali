package com.epicode.GestioneViaggiAziendali.service;


import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.entity.Prenotazione;
import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import com.epicode.GestioneViaggiAziendali.exception.PrenotazioneException;
import com.epicode.GestioneViaggiAziendali.repository.DipendenteRepository;
import com.epicode.GestioneViaggiAziendali.repository.PrenotazioneRepository;
import com.epicode.GestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        List<Prenotazione> existingPrenotazioni = prenotazioneRepository.findByDipendenteAndDataRichiesta(prenotazione.getDipendente(), prenotazione.getDataRichiesta());
        if (!existingPrenotazioni.isEmpty()) {
            throw new PrenotazioneException("Esiste già una prenotazione per questo dipendente in questa data.");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id).orElse(null);
    }

    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    public Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id).orElse(null);
    }

    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id).orElse(null);
    }
}
