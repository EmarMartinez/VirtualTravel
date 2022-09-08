package com.virtualtravelappback.application.reservaprocesada;


import com.virtualtravelappback.domain.ReservasProcesadas;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaOutputDto;
import com.virtualtravelappback.infraestructure.repository.ReservasProcesadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaProcesadaServiceImpl implements ReservaProcesadaService{
    @Autowired
    ReservasProcesadasRepository reservasProcesadasRepository;

    @Value("${num_plazas_autobus}")
    int num_plazas_autobus;
    @Override
    public void addReserva(ReservaProcesadaInputDto reservaProcesadaInputDto) {

        reservasProcesadasRepository.save(new ReservasProcesadas(reservaProcesadaInputDto));
    }
    // Devuelve numero de reservas disponibles para un autobus pasando mes, dia, hora como parametro


    @Override
    public int reservasDisponiblesMesDiaHora(int mes, int dia, int hora, String ciudad) {
        return num_plazas_autobus - reservasProcesadasRepository.listaReservasMesDia(mes, dia, hora, ciudad);
    }

    @Override
    public List<ReservaProcesadaOutputDto> listaReservas() {
        return reservasProcesadasRepository.findAll().stream().map(n->n.reservaProcesadaToOutputDto(n)).toList();
    }
}
