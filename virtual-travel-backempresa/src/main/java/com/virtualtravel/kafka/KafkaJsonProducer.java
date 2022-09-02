package com.virtualtravel.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

//@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object reservaOutputDto) {

        LOGGER.info(String.format("Reserva enviada -> %s" , reservaOutputDto.toString()));

        Message<Object> message = MessageBuilder
                .withPayload(reservaOutputDto)
                .setHeader(KafkaHeaders.TOPIC, "estadoreservas2")
                .build();

        kafkaTemplate.send(message);
    }

}
