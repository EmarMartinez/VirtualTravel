package com.virtualtravelappback.infraestructure.repository;

import com.virtualtravelappback.domain.ReservasProcesadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasProcesadasRepository extends JpaRepository<ReservasProcesadas, Integer> {
}
