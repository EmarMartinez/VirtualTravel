package com.virtualtravelappback.kafka;

import com.virtualtravelappback.application.reservaprocesada.ReservaProcesadaServiceImpl;
import com.virtualtravelappback.domain.Reserva;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    ReservaProcesadaServiceImpl reservaProcesadaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="estadoreservas", groupId="grupoestadoreservas")
    public void consume(ReservaProcesadaInputDto reservaProcesadaInputDto) {
        reservaProcesadaService.addReserva(reservaProcesadaInputDto);
        System.out.println("recibida reserva desde empresa, actualizada en bbdd web");
//        LOGGER.info(String.format("Message received -> %s" , reservaProcesadaInputDto.toString()));
    }
}