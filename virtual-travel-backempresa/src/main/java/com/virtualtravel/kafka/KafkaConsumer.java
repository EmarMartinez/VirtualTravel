package com.virtualtravel.kafka;
import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaOutputDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    ReservaServiceImpl reservaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="reservas", groupId="grupoestadoreservas2")
    public void consume(ReservaInputDto reservaInput) {

        reservaService.addReserva(reservaInput);
        LOGGER.info(String.format("Message received -> %s" , reservaInput));
        System.out.println(reservaInput);


    }
}