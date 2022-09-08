package com.virtualtravelappback.application.reservaprocesada;

import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaOutputDto;

import java.util.List;

public interface ReservaProcesadaService {

    void addReserva(ReservaProcesadaInputDto reservaProcesadaInputDto);

    int reservasDisponiblesMesDiaHora(int mes, int dia, int hora, String ciudad);

    List<ReservaProcesadaOutputDto> listaReservas();
}
