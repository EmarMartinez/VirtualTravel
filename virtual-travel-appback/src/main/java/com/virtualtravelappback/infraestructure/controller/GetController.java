package com.virtualtravelappback.infraestructure.controller;

import com.virtualtravelappback.application.reserva.ReservaServiceImpl;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/reserva")
public class GetController {

    @Autowired
    ReservaServiceImpl reservaServiceImpl;

    @GetMapping("/{mes}/{dia}/{hora}")
    public List<ReservaOutputDto> listaReservasMesDiaHora(@PathVariable int mes, @PathVariable int dia, @PathVariable int hora) {
        return reservaServiceImpl.reservasMesDiaHora(mes, dia, hora);
    }
}
