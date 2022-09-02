package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/reservas")
public class GetController {
    @Autowired
    ReservaServiceImpl reservaService;

    @GetMapping
    public int numeroPlazasOcupadas(@RequestBody ReservaInputDto reservaInputDto) {
        return reservaService.plazasOcupadas(reservaInputDto);
    }
}
