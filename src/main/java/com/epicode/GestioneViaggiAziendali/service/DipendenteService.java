package com.epicode.GestioneViaggiAziendali.service;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.mapper.DipendenteMapper;
import com.epicode.GestioneViaggiAziendali.payload.DipendenteDTO;
import com.epicode.GestioneViaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.epicode.GestioneViaggiAziendali.mapper.DipendenteMapper.toEntity;


@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DipendenteMapper dipendenteMapper;

    public Long nuovoDipendente(DipendenteDTO nuovoDipendenteDto){
        Dipendente dipendenteInserito =  toEntity(nuovoDipendenteDto);
        return dipendenteRepository.save(dipendenteInserito).getDipendenteId();
    }

    public Optional<Dipendente> ricercaDipendenteId(Long id){
        Optional<Dipendente> dipendenteRecuperato =dipendenteRepository.findById(id);
        return dipendenteRecuperato;
    }

    public DipendenteDTO createDipendente(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = dipendenteMapper.toEntity(dipendenteDTO);
        dipendenteRepository.save(dipendente);
        return dipendenteDTO;
    }


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
