package com.virtualtravel.application;

import com.virtualtravel.domain.Credenciales;
import com.virtualtravel.infraestructure.repository.CredencialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialesServiceImpl implements CredencialesService{
    @Autowired
    CredencialesRepository credencialesRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void addCredenciales(Credenciales credenciales) {
        Credenciales credenciales1 = new Credenciales();
        credenciales1.setUsername(credenciales.getUsername());
        credenciales1.setPassword(passwordEncoder.encode(credenciales.getPassword()));
        credenciales1.setRole(credenciales.getRole());
        credencialesRepository.save(credenciales1);
    }

    @Override
    public List<Credenciales> verCredenciales() {
        return credencialesRepository.findAll();
    }
}
