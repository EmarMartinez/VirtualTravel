package com.virtualtravelappback.kafka;


import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, ReservaOutputDto> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, ReservaOutputDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ReservaOutputDto reservaOutputDto) throws JsonProcessingException {

        LOGGER.info(String.format("Reserva enviada -> %s" , reservaOutputDto.toString()));

        Message<ReservaOutputDto> message = MessageBuilder
                .withPayload(reservaOutputDto)
                .setHeader(KafkaHeaders.TOPIC, "reservas")
                .build();

        kafkaTemplate.send(message);
        System.out.println("Enviado desde sendMessage");
    }

}
