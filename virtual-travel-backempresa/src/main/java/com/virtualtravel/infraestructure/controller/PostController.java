package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v0/reservas")
public class PostController {

    @Autowired
    ReservaServiceImpl reservaService;

    @PostMapping
    public void addReserva(@RequestBody ReservaInputDto reservaInputDto) {
        reservaService.addReserva(reservaInputDto);
    }

}
