package com.virtualtravelappback.kafka;
import com.virtualtravelappback.application.reservaprocesada.ReservaProcesadaServiceImpl;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {
    @Autowired
    ReservaProcesadaServiceImpl reservaProcesadaService;

    @KafkaListener(topics="estadoreservas", groupId = "${eureka.instance.instance-id}")
    public void consume(ReservaProcesadaInputDto reservaProcesadaInputDto) {
        reservaProcesadaService.addReserva(reservaProcesadaInputDto);
        System.out.println("recibida reserva desde empresa, actualizada en bbdd web");
    }
}