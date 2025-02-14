package com.epicode.GestioneViaggiAziendali.service;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;


    public Dipendente saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id).orElse(null);
    }

    public Dipendente getDipendenteByUsername(String username) {
        return dipendenteRepository.findByUsername(username);
    }

    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }

}
