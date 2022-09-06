package com.virtualtravelappback.infraestructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virtualtravelappback.application.reserva.ReservaServiceImpl;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.Arrays;
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

    @GetMapping("listaReservas")
    public List<ReservaOutputDto> listaReservas(@RequestParam  String ciudad, @RequestParam Date fecha, @RequestParam int hora_salida) {
        String path = "ciudad="+ciudad+"&fecha="+fecha+"&hora_salida="+hora_salida;
        ResponseEntity<Object[]> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8090/api/v0/reservas/buscarReservas?"+path, Object[].class);

        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(objects)
                .map(object->mapper.convertValue(object, ReservaOutputDto.class))
                .toList();

    }
}
