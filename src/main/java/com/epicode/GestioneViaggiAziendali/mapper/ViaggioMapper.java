package com.epicode.GestioneViaggiAziendali.mapper;

import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import com.epicode.GestioneViaggiAziendali.payload.ViaggioDTO;
import org.springframework.stereotype.Component;


@Component
public class ViaggioMapper {
    public static ViaggioDTO mapToDTO(Viaggio viaggio) {
        if (viaggio == null) {
            return null;
        }

        ViaggioDTO dto = new ViaggioDTO();
        dto.setDestinazione(viaggio.getDestinazione());
        dto.setData(viaggio.getData());
        dto.setStato(viaggio.getStato());

        return dto;
    }

    public static Viaggio ToEntity(ViaggioDTO dto) {
        if (dto == null) {
            return null;
        }

        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(dto.getDestinazione());
        viaggio.setData(dto.getData());
        viaggio.setStato(dto.getStato());

        return viaggio;
    }
}
