package com.virtualtravel.infraestructure.repository;

import com.virtualtravel.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query("SELECT COUNT(*) FROM Reserva r WHERE r.ciudad = ?1 and r.fecha = ?2 and r.hora_salida = ?3")
    int numeroDeReservas(String ciudad, Date date, int horaSalida);

    @Query("SELECT r FROM Reserva r WHERE r.ciudad = ?1 and r.fecha = ?2 and r.hora_salida = ?3")
    List<Reserva> listaReservas(String ciudad, Date fecha, int horaSalida);
}
