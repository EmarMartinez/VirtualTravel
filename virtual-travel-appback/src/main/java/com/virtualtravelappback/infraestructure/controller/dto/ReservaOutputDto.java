package com.virtualtravelappback.infraestructure.controller.dto;

import java.util.Date;

public record ReservaOutputDto(
        int id_reserva,
        String ciudad,
        String nombre,
        String apellido,
        String telefono,
        String email,
        Date fecha,
        int hora_salida) {
}
