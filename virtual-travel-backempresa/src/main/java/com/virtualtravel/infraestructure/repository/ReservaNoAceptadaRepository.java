package com.virtualtravel.infraestructure.repository;

import com.virtualtravel.domain.ReservaNoAceptada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaNoAceptadaRepository extends JpaRepository<ReservaNoAceptada, Integer> {
}
