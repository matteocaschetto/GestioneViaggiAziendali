package com.epicode.GestioneViaggiAziendali.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity(name = "viaggio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viaggioId;

    @Column(nullable = false)
    private String destinazione;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;
}
