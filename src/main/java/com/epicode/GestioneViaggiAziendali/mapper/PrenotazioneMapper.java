package com.epicode.GestioneViaggiAziendali.mapper;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import com.epicode.GestioneViaggiAziendali.entity.Prenotazione;
import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import com.epicode.GestioneViaggiAziendali.payload.PrenotazioneDTO;


public class PrenotazioneMapper {
    public static PrenotazioneDTO mapToDTO(Prenotazione prenotazione) {
        if (prenotazione == null) {
            return null;
        }

        PrenotazioneDTO dto = new PrenotazioneDTO();
        dto.setDataRichiesta(prenotazione.getDataRichiesta());
        dto.setNote(prenotazione.getNote());

        if (prenotazione.getViaggio() != null) {
            dto.setViaggioId(prenotazione.getViaggio().getViaggioId()); // Mappa ID viaggio
        }

        if (prenotazione.getDipendente() != null) {
            dto.setDipendenteId(prenotazione.getDipendente().getDipendenteId()); // Mappa ID dipendente
        }

        return dto;
    }

    public static Prenotazione mapToEntity(PrenotazioneDTO dto) {
        if (dto == null) {
            return null;
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataRichiesta(dto.getDataRichiesta());
        prenotazione.setNote(dto.getNote());

        Viaggio viaggio = new Viaggio();
        viaggio.setViaggioId(dto.getViaggioId());
        prenotazione.setViaggio(viaggio);

        Dipendente dipendente = new Dipendente();
        dipendente.setDipendenteId(dto.getDipendenteId());
        prenotazione.setDipendente(dipendente);
        return prenotazione;
    }

}
