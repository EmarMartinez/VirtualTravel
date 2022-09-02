package com.virtualtravel.application;

import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;

public interface ReservaService {
    Object addReserva(ReservaInputDto reservaInputDto);

    int plazasOcupadas(ReservaInputDto reservaInputDto);
}
