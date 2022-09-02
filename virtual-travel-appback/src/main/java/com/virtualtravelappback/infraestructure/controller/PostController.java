package com.virtualtravelappback.infraestructure.controller;

import com.virtualtravelappback.application.estadoreserva.EstadoReservaServiceImpl;
import com.virtualtravelappback.application.reserva.ReservaServiceImpl;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.EstadoReservaOutputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravelappback.kafka.KafkaJsonProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0/reserva")
public class PostController {

    @Autowired
    ReservaServiceImpl reservaService;

    @Autowired
    EstadoReservaServiceImpl estadoReservaServiceImpl;

    @Autowired
    KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ReservaOutputDto addReserva(@RequestBody ReservaInputDto reservaInputDto) throws JsonProcessingException {

        ReservaOutputDto reservaOutputDto = reservaService.addReserva(reservaInputDto);
        kafkaJsonProducer.sendMessage(reservaOutputDto);
        System.out.println(reservaOutputDto);
        return reservaOutputDto;
    }

    @PostMapping("/{id}/estado")
    public EstadoReservaOutputDto addEstadoReserva(@RequestBody EstadoReservaInputDto estadoReservaInputDto, @PathVariable int id) {
        return estadoReservaServiceImpl.addEstadoReserva(estadoReservaInputDto, id);
    }


}
