package com.virtualtravel.application;

import com.virtualtravel.infraestructure.controller.dto.EmailOutputDto;

import java.util.List;

public interface EmailService {

   void sendEmail(String toEmail, String subject, String body);

   List<EmailOutputDto> consultarCorreos();
   EmailOutputDto reenviarEmaill(int id);
}
