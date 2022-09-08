package com.virtualtravel.application;

import com.virtualtravel.domain.Credenciales;
import com.virtualtravel.infraestructure.repository.CredencialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CredencialesRepository credencialesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Credenciales credenciales = credencialesRepository.findByUsername(username);
       return new User(credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>());
    }
}
