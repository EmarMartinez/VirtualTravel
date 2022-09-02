package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.kafka.KafkaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@RequestMapping("api/v0/kafka")
public class JsonMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Object reservaOutputDto) {

        kafkaJsonProducer.sendMessage(reservaOutputDto);
        return ResponseEntity.ok("Respuesta a reserva Json enviada");
    }
}