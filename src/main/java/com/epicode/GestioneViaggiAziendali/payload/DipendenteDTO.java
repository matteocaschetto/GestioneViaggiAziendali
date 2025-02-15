package com.epicode.GestioneViaggiAziendali.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.URL;


@Data
public class DipendenteDTO {
    @Column(nullable = true)
    private Long dipendenteId;
    private String username;
    @NotBlank(message = "'nome' non può essere dei caratteri vuoti")
    @NotNull(message = "'nome' non può essere vuota")
    private String nome;
    @NotBlank(message = "'cognome' non può essere dei caratteri vuoti")
    @NotNull(message = "'cognome' non può essere vuota")
    private String cognome;
    @NotBlank(message = "'email' non può essere dei caratteri vuoti")
    @NotNull(message = "'email' non può essere vuota")
    private String email;
    private String immagineProfilo;
}
