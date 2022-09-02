package com.virtualtravelappback.infraestructure.repository;

import com.virtualtravelappback.domain.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {
}
