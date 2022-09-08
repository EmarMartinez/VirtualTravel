package com.virtualtravel.infraestructure.controller;

import com.virtualtravel.application.CustomUserDetailsService;
import com.virtualtravel.application.ReservaServiceImpl;
import com.virtualtravel.infraestructure.controller.dto.ReservaInputDto;
import com.virtualtravel.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v0")
public class PostController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    ReservaServiceImpl reservaService;



    @PostMapping("reservas")
    public void addReserva(@RequestBody ReservaInputDto reservaInputDto) {
        reservaService.addReserva(reservaInputDto);
    }

    @PostMapping("token")
    public String getToken(@RequestParam String username, @RequestParam String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            throw new RuntimeException("Nombre/Password no valido");
        }
    return jwtUtil.generateToken(username);
    }


}
