package com.virtualtravel.application;

import com.virtualtravel.domain.Reserva;
import com.virtualtravel.domain.ReservaNoAceptada;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaProcesadaOutputDto;
import com.virtualtravel.infraestructure.repository.ReservaNoAceptadaRepository;
import com.virtualtravel.infraestructure.repository.ReservaRepository;
import com.virtualtravel.kafka.KafkaJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class ReservaServiceImpl implements ReservaService{

//    private static final int NUM_MAX_PLAZAS = 5;

    @Value("${num_plazas_autobus}")
    int NUM_PLAZAS_AUTOBUS;
    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ReservaNoAceptadaRepository reservaNoAceptadaRepository;

    @Autowired
    KafkaJsonProducer kafkaProducer;


    @Override
    public Object addReserva(ReservaInputDto reservaInputDto) {

        System.out.println(NUM_PLAZAS_AUTOBUS);
        int plazasLibres = NUM_PLAZAS_AUTOBUS - this.plazasOcupadas(reservaInputDto);

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

    @Override
    public List<ReservaOutputDto> listaReservas(String ciudad, Date fecha, int horasalida) {
        List<Reserva> listaReservas =reservaRepository.listaReservas(ciudad, fecha, horasalida);
        return listaReservas.stream().map(Reserva::reservaToOutputDto).toList();
        //resttemplate back-->empresa
    }
}
