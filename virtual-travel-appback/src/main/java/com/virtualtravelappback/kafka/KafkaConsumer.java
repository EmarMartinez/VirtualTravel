package com.virtualtravelappback.kafka;

import com.virtualtravelappback.domain.Reserva;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="estadoreservas2", groupId="grupoestadoreservas2")
    public void consume(Reserva message) {

        LOGGER.info(String.format("Message received -> %s" , message));
    }
}