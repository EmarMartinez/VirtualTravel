package com.virtualtravel.kafka;


import com.virtualtravel.infraestructure.controller.dto.ReservaProcesadaOutputDto;
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

    private KafkaTemplate<String, ReservaProcesadaOutputDto> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, ReservaProcesadaOutputDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ReservaProcesadaOutputDto reservaProcesadaOutputDto) {

        LOGGER.info(String.format("Reserva enviada -> %s" , reservaProcesadaOutputDto.toString()));

        Message<ReservaProcesadaOutputDto> message = MessageBuilder
                .withPayload(reservaProcesadaOutputDto)
                .setHeader(KafkaHeaders.TOPIC, "estadoreservas")
                .build();

        kafkaTemplate.send(message);
        System.out.println("reserva enviada desde empresa a topic reservas");
    }

}
