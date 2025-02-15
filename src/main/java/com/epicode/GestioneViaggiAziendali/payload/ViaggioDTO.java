package com.epicode.GestioneViaggiAziendali.payload;


import com.epicode.GestioneViaggiAziendali.entity.StatoViaggio;
import lombok.*;

import java.time.LocalDate;


@Data
public class ViaggioDTO {
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;
}