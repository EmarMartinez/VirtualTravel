package com.virtualtravelappback.infraestructure.controller.dto;

public record EstadoReservaInputDto(
        int id_reserva,
        boolean aceptada,
        String comentarios
) {
}
