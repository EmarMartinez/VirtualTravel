package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.application.CredencialesServiceImpl;
import com.virtualtravel.application.CustomUserDetailsService;
import com.virtualtravel.application.EmailServiceImpl;
import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.domain.Credenciales;
import com.virtualtravel.infraestructure.controller.dto.EmailOutputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.infraestructure.controller.dto.ReservaOutputDto;
import com.virtualtravel.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("api/v0")
public class GetController {
    @Autowired
    ReservaServiceImpl reservaService;

    @Autowired
    CredencialesServiceImpl credencialesService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("reservas")
    public int numeroPlazasOcupadas(@RequestBody ReservaInputDto reservaInputDto) {
        return reservaService.plazasOcupadas(reservaInputDto);
    }

    @GetMapping("reservas/buscarReservas")
    public List<ReservaOutputDto> buscarReservas(@RequestParam String ciudad, @RequestParam Date fecha, @RequestParam int hora_salida ) {
        return reservaService.listaReservas(ciudad, fecha, hora_salida);
    }

    @GetMapping("welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("credenciales")
    public List<Credenciales> verCredenciales() {
        return credencialesService.verCredenciales();
    }

    @GetMapping("checktoken/{token}")
    public Boolean isTokenValid(@PathVariable String token) {
        try {
            String username = jwtUtil.extractUsername(token);
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
            jwtUtil.validateToken(token, userDetails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("correos")
    public List<EmailOutputDto> verCorreos() {
        return emailService.consultarCorreos();
    }

}
