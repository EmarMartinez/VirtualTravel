package com.virtualtravel.infraestructure.controller.dto;

import java.util.Date;

public record ReservaNoAceptadaOutputDto(
        int id,
        int id_reserva,
        String ciudad,
        String nombre,
        String apellido,
        String telefono,
        String email,
        Date fecha,
        int hora_salida,
        String motivo
) {
}
