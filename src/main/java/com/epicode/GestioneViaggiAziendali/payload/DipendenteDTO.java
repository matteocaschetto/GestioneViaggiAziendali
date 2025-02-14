package com.epicode.GestioneViaggiAziendali.payload;

import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DipendenteDTO {
    @Column(nullable = true)
    private Long dipendenteId;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfilo;
}
