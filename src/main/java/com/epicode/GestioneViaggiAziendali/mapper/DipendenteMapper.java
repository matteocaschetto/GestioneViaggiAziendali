package com.epicode.GestioneViaggiAziendali.mapper;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.payload.DipendenteDTO;
import org.springframework.stereotype.Component;

@Component
public class DipendenteMapper {


    public static DipendenteDTO mapToDo(Dipendente dipendente) {
        if (dipendente == null) {
            return null;
        }

        DipendenteDTO dto = new DipendenteDTO();
        dto.setUsername(dipendente.getUsername());
        dto.setNome(dipendente.getNome());
        dto.setCognome(dipendente.getCognome());
        dto.setEmail(dipendente.getEmail());
        dto.setImmagineProfilo(dipendente.getImmagineProfilo());

        return dto;
    }


    public static Dipendente toEntity(DipendenteDTO dipendenteDTO){

        Dipendente dipendente = new Dipendente();

        dipendente.setUsername(dipendenteDTO.getUsername());
        dipendente.setDipendenteId(dipendenteDTO.getDipendenteId());
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente.setEmail(dipendenteDTO.getEmail());
        dipendente.setImmagineProfilo(dipendenteDTO.getImmagineProfilo());

        return dipendente;
    }

    public static DipendenteDTO toDTO(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendenteDTO.getCognome());
        dipendenteDTO.setEmail(dipendenteDTO.getEmail());
        dipendenteDTO.setUsername(dipendenteDTO.getUsername());
        return dipendenteDTO;
    }

}

