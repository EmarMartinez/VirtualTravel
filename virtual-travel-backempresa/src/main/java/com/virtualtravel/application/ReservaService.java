package com.virtualtravel.application;

import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaOutputDto;

import java.sql.Date;
import java.util.List;

public interface ReservaService {
    Object addReserva(ReservaInputDto reservaInputDto);

    int plazasOcupadas(ReservaInputDto reservaInputDto);

    List<ReservaOutputDto> listaReservas(String ciudad, Date fecha, int horasalida);
}
