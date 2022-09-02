package com.virtualtravelappback.application.estadoreserva;

import com.virtualtravelappback.domain.EstadoReserva;
import com.virtualtravelappback.domain.Reserva;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaOutputDto;
import com.virtualtravelappback.infraestructure.repository.EstadoReservaRepository;
import com.virtualtravelappback.infraestructure.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoReservaServiceImpl implements EstadoReservaService{

    @Autowired
    EstadoReservaRepository estadoReservaRepository;

    @Autowired
    ReservaRepository reservaRepository;
    @Override
    public EstadoReservaOutputDto addEstadoReserva(EstadoReservaInputDto estadoReservaInputDto, int id) {
        EstadoReserva estadoReserva = new EstadoReserva(estadoReservaInputDto);
        Reserva reserva = reservaRepository.findById(id).orElseThrow();
        estadoReserva.setReserva(reserva);
        reserva.setEstadoReserva(estadoReserva);
        return estadoReserva.EstadoReservaToOutputDto(estadoReservaRepository.save(estadoReserva));

    }
}
