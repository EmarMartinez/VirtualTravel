package com.virtualtravel.infraestructure.controller.dto;

public record EmailOutputDto(
        int id_email,
        String subject,
        String body,
        String mailTo
    ) {
}
