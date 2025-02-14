package com.epicode.GestioneViaggiAziendali.mapper;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.payload.DipendenteDTO;

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

    public static Dipendente mapToEntity(DipendenteDTO dto) {
        if (dto == null) {
            return null;
        }

        Dipendente dipendente = new Dipendente();

        dipendente.setUsername(dto.getUsername());
        dipendente.setDipendenteId(dto.getDipendenteId());
        dipendente.setNome(dto.getNome());
        dipendente.setCognome(dto.getCognome());
        dipendente.setEmail(dto.getEmail());
        dipendente.setImmagineProfilo(dto.getImmagineProfilo());

        return dipendente;
    }
}
