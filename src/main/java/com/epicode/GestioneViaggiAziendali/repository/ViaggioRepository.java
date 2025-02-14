package com.epicode.GestioneViaggiAziendali.repository;

import com.epicode.GestioneViaggiAziendali.entity.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}