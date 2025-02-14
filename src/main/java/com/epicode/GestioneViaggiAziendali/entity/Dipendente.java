package com.epicode.GestioneViaggiAziendali.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dipendente;

    @Column(nullable = false, unique = true)
    private String username;
    private String nome;
    private String cognome;
    @Column(unique = true)
    private String email;
}
