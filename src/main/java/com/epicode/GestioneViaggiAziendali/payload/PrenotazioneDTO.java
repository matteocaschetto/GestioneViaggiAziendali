package com.epicode.GestioneViaggiAziendali.payload;


import lombok.*;

import java.time.LocalDate;


@Data
public class PrenotazioneDTO {
    private Long viaggioId;
    private Long dipendenteId;
    private LocalDate dataRichiesta;
    private String note;
}