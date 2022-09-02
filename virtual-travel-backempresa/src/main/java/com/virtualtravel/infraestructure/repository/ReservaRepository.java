package com.virtualtravel.infraestructure.repository;

import com.virtualtravel.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query("SELECT COUNT(*) FROM Reserva r WHERE r.ciudad = ?1 and r.fecha = ?2 and r.hora_salida = ?3")
    int numeroDeReservas(String ciudad, Date date, int horaSalida);
}
