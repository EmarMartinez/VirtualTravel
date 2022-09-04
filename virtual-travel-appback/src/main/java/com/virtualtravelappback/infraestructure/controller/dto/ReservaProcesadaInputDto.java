package com.virtualtravelappback.infraestructure.controller.dto;

import java.util.Date;

public record ReservaProcesadaInputDto(
        int id,
        int id_reserva,
        String ciudad,
        String nombre,
        String apellido,
        String telefono,
        String email,
        Date fecha,
        int hora_salida,
        boolean aceptada,
        String motivo
) {
}

