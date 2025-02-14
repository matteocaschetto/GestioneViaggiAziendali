package com.epicode.GestioneViaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dipendenteId;

    @Column(nullable = false, unique = true)
    private String username;
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String email;

    private String immagineProfilo;

    @OneToMany(mappedBy = "dipendente")
    private List<Prenotazione> prenotazioni;
}
