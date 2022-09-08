package com.virtualtravel.application;

import com.virtualtravel.domain.Credenciales;

import java.util.List;

public interface CredencialesService {
    void addCredenciales(Credenciales credenciales);
    List<Credenciales> verCredenciales();
}
