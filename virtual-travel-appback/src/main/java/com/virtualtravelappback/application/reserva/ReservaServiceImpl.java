package com.virtualtravelappback.application.reserva;

import com.virtualtravelappback.domain.Reserva;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravelappback.infraestructure.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{

    @Autowired
    ReservaRepository reservaRepository;

    @Override
    public ReservaOutputDto addReserva(ReservaInputDto reservaInputDto) {

        Reserva reserva = reservaRepository.save(new Reserva(reservaInputDto));
        return reserva.reservaToOutputDto(reserva);
    }

    @Override
    public List<ReservaOutputDto> reservasMesDiaHora(int mes, int dia, int hora) {
        return reservaRepository.listaReservasMesDia(mes, dia, hora).stream().map(n->n.reservaToOutputDto(n)).toList();
    }


}
