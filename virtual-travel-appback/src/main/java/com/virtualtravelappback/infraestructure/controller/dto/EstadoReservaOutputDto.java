package com.virtualtravelappback.infraestructure.controller.dto;

public record EstadoReservaOutputDto(
        int id_estado_reserva,
        int id_reserva,
        boolean aceptada,
        String comentarios) {
}
