package com.epicode.GestioneViaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity(name = "prenotazione")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    private LocalDate dataRichiesta;
    private String note;

}
