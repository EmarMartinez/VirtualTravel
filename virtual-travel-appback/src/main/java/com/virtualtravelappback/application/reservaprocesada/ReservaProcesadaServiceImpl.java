package com.virtualtravelappback.application.reservaprocesada;


import com.virtualtravelappback.domain.ReservasProcesadas;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaInputDto;
import com.virtualtravelappback.infraestructure.repository.ReservasProcesadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaProcesadaServiceImpl implements ReservaProcesadaService{
    @Autowired
    ReservasProcesadasRepository reservasProcesadasRepository;
    @Override
    public void addReserva(ReservaProcesadaInputDto reservaProcesadaInputDto) {

        reservasProcesadasRepository.save(new ReservasProcesadas(reservaProcesadaInputDto));
    }
}
