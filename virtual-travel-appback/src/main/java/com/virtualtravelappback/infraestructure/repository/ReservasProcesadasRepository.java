package com.virtualtravelappback.infraestructure.repository;


import com.virtualtravelappback.domain.ReservasProcesadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ReservasProcesadasRepository extends JpaRepository<ReservasProcesadas, Integer> {
    @Query(value = "SELECT COUNT(*) FROM Reservas_Procesadas r WHERE Month(r.fecha) = ?1 and Day(r.fecha) = ?2 and r.hora_salida = ?3 and r.ciudad = ?4 and r.motivo is null",
            nativeQuery = true)
    int listaReservasMesDia(int mes, int dia, int hora, String ciudad);
}
