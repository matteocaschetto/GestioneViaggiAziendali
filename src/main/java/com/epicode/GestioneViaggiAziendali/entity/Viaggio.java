package com.epicode.GestioneViaggiAziendali.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_viaggio;

    @Column(nullable = false)
    private String destinazione;
    private LocalDate dataViaggio;


    private String stato;
}
