package com.virtualtravelappback.infraestructure.repository;

import com.virtualtravelappback.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
//    @Query("SELECT R FROM Reserva R WHERE SUBSTRING(CAST(R.fecha as text), 6, 7) = CAST(?1 as text) and SUBSTRING(CAST(R.fecha as text), 9, 10 = cast(?2 as text) and R.hora_salida = ?3)")
    @Query(value = "SELECT * FROM Reserva r WHERE Month(r.fecha) = ?1 and Day(r.fecha) = ?2 and r.hora_salida = ?3",
        nativeQuery = true)
    List<Reserva> listaReservasMesDia(int mes, int dia, int hora);

}
