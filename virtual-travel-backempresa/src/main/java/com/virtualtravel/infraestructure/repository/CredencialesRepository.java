package com.virtualtravel.infraestructure.repository;

import com.virtualtravel.domain.Credenciales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialesRepository extends JpaRepository<Credenciales, Integer> {
}
