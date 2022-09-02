package com.virtualtravelappback.application.reserva;

import com.virtualtravelappback.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;

import java.util.List;

public interface ReservaService {
    ReservaOutputDto addReserva(ReservaInputDto reservaInputDto);




    List<ReservaOutputDto> reservasMesDiaHora(int mes, int dia, int hora);
}
