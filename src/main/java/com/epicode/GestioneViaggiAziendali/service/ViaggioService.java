package com.epicode.GestioneViaggiAziendali.service;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.entity.StatoViaggio;
import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import com.epicode.GestioneViaggiAziendali.mapper.ViaggioMapper;
import com.epicode.GestioneViaggiAziendali.payload.DipendenteDTO;
import com.epicode.GestioneViaggiAziendali.payload.ViaggioDTO;
import com.epicode.GestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private ViaggioMapper viaggioMapper;

    public Viaggio saveViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public ViaggioDTO createViaggio(ViaggioDTO viaggioDTO){
        Viaggio viaggio = viaggioMapper.ToEntity(viaggioDTO);
        viaggioRepository.save(viaggio);
        return viaggioDTO;
    }

    public Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id).orElse(null);
    }

    public void deleteViaggio(Long id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio updateStatoViaggio(Long id, StatoViaggio stato) {
        Viaggio viaggio = viaggioRepository.findById(id).orElse(null);
        if (viaggio != null) {
            viaggio.setStato(stato);
            return viaggioRepository.save(viaggio);
        }
        return null;
    }
}
