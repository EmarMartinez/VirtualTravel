package com.virtualtravelappback.infraestructure.controller;
import com.virtualtravelappback.application.reservaprocesada.ReservaProcesadaServiceImpl;
import com.virtualtravelappback.error.UnprocesableException;
import com.virtualtravelappback.infraestructure.controller.dto.ReservaProcesadaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v0/reserva")
public class GetController {

    @Autowired
    ReservaProcesadaServiceImpl reservaProcesadaService;

    @GetMapping("/{mes}/{dia}/{hora}/{ciudad}")
    public int listaReservasMesDiaHora(@PathVariable int mes, @PathVariable int dia, @PathVariable int hora, @PathVariable String ciudad) {
        return reservaProcesadaService.reservasDisponiblesMesDiaHora(mes, dia, hora, ciudad);
    }

    @GetMapping("listaReservas")
    public List<ReservaProcesadaOutputDto> listaReservas(@RequestParam String token) {

       ResponseEntity<Boolean> responseEntity = new RestTemplate()
                    .getForEntity("http://localhost:8090/api/v0/checktoken/"+token, Boolean.class);
       if(Boolean.TRUE.equals(responseEntity.getBody())) {
            return reservaProcesadaService.listaReservas();
       }
       else {
           throw new UnprocesableException("Token no valido");
       }
//        try {
//            String path = "ciudad="+ciudad+"&fecha="+fecha+"&hora_salida="+hora_salida;
//            ResponseEntity<Object[]> responseEntity = new RestTemplate()
//                    .getForEntity("http://localhost:8090/api/v0/reservas/buscarReservas?"+path, Object[].class);
//
//            Object[] objects = responseEntity.getBody();
//            ObjectMapper mapper = new ObjectMapper();
//            return Arrays.stream(objects)
//                    .map(object->mapper.convertValue(object, ReservaOutputDto.class))
//                    .toList();
//        } catch (RestClientException e) {
//            throw new UnprocesableException("Necesita token de acceso para hacer esta consulta");
//        }

    }
}
