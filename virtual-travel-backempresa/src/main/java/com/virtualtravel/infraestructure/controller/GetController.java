package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api/v0/reservas")
public class GetController {
    @Autowired
    ReservaServiceImpl reservaService;

    @GetMapping
    public int numeroPlazasOcupadas(@RequestBody ReservaInputDto reservaInputDto) {
        return reservaService.plazasOcupadas(reservaInputDto);
    }

//    @GetMapping("mes/{mes}/dia{dia}/ciudad/{ciudad}/horasalida/{horasalida}")
    @GetMapping("buscarReservas")
    public List<ReservaOutputDto> buscarReservas(@RequestParam String ciudad, @RequestParam Date fecha, @RequestParam int hora_salida ) {
        return reservaService.listaReservas(ciudad, fecha, hora_salida);
    }
}
