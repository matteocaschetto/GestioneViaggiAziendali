package com.epicode.GestioneViaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity(name = "dipendente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
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
