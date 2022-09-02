package com.virtualtravelappback.infraestructure.controller.dto;

import java.util.Date;

public record ReservaInputDto(
        String ciudad,
        String nombre,
        String apellido,
        String telefono,
        String email,
        Date fecha,
        int hora_salida) {}
