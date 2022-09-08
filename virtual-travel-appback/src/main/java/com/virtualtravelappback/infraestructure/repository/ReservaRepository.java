package com.virtualtravelappback.infraestructure.repository;

import com.virtualtravelappback.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    @Query(value = "SELECT * FROM Reserva r WHERE Month(r.fecha) = ?1 and Day(r.fecha) = ?2 and r.hora_salida = ?3",
        nativeQuery = true)
    List<Reserva> listaReservasMesDia(int mes, int dia, int hora);

}
