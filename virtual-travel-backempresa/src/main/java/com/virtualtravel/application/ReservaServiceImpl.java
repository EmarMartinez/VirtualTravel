package com.virtualtravel.application;

import com.virtualtravel.domain.Reserva;
import com.virtualtravel.domain.ReservaNoAceptada;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaProcesadaOutputDto;
import com.virtualtravel.infraestructure.repository.ReservaNoAceptadaRepository;
import com.virtualtravel.infraestructure.repository.ReservaRepository;
import com.virtualtravel.kafka.KafkaJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReservaServiceImpl implements ReservaService{

    private static final int NUM_MAX_PLAZAS = 5;

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ReservaNoAceptadaRepository reservaNoAceptadaRepository;

    @Autowired
    KafkaJsonProducer kafkaProducer;


    @Override
    public Object addReserva(ReservaInputDto reservaInputDto) {

        System.out.println(NUM_MAX_PLAZAS);
        int plazasLibres = NUM_MAX_PLAZAS - this.plazasOcupadas(reservaInputDto);

        if(plazasLibres>0) {
            System.out.println("Reserva aceptada");
            Reserva returnObject = reservaRepository.save(new Reserva(reservaInputDto));
            ReservaProcesadaOutputDto reservaProcesadaOutputDto = new ReservaProcesadaOutputDto(
                    returnObject.getId(),
                    reservaInputDto.id_reserva(),
                    reservaInputDto.ciudad(),
                    reservaInputDto.nombre(),
                    reservaInputDto.apellido(),
                    reservaInputDto.telefono(),
                    reservaInputDto.email(),
                    reservaInputDto.fecha(),
                    reservaInputDto.hora_salida(),
                    true,
                    null
            );

            //mandar mail por hacer
            kafkaProducer.sendMessage(reservaProcesadaOutputDto);
            return returnObject;


        }
        else{
            System.out.println("Reserva rechazada por falta de plazas");
            ReservaNoAceptada reserva = new ReservaNoAceptada(reservaInputDto);
            reserva.setMotivo("Falta de plazas");
            ReservaNoAceptada returnObject = reservaNoAceptadaRepository.save(reserva);
            ReservaProcesadaOutputDto reservaProcesadaOutputDto = new ReservaProcesadaOutputDto(
                    returnObject.getId(),
                    reservaInputDto.id_reserva(),
                    reservaInputDto.ciudad(),
                    reservaInputDto.nombre(),
                    reservaInputDto.apellido(),
                    reservaInputDto.telefono(),
                    reservaInputDto.email(),
                    reservaInputDto.fecha(),
                    reservaInputDto.hora_salida(),
                    false,
                    returnObject.getMotivo()
            );
            kafkaProducer.sendMessage(reservaProcesadaOutputDto);
            return returnObject;

        }

    }

    @Override
    public int plazasOcupadas(ReservaInputDto reservaInputDto) {
        return reservaRepository.numeroDeReservas(reservaInputDto.ciudad(),reservaInputDto.fecha(),reservaInputDto.hora_salida());
    }
}
