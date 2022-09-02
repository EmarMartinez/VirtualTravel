package com.virtualtravelappback.application.estadoreserva;

import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaOutputDto;

public interface EstadoReservaService {
    EstadoReservaOutputDto addEstadoReserva(EstadoReservaInputDto estadoReservaInputDto, int id);
}
