package com.epicode.GestioneViaggiAziendali.repository;

import com.epicode.GestioneViaggiAziendali.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Dipendente findByUsername(String username);
}
