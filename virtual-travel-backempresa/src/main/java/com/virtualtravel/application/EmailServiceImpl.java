package com.virtualtravel.application;

import com.virtualtravel.domain.Email;
import com.virtualtravel.infraestructure.controller.dto.EmailOutputDto;
import com.virtualtravel.infraestructure.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    EmailRepository emailRepository;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("emarcuentapruebas@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Correo enviado");
    }

    @Override
    public List<EmailOutputDto> consultarCorreos() {
        return emailRepository.findAll().stream().map(n->n.EmailToEmailOutputDto(n)).toList();
    }

    @Override
    public EmailOutputDto reenviarEmaill(int id) {
        Email email = emailRepository.findById(id).orElseThrow();
        this.sendEmail(email.getMailTo(), email.getSubject(), email.getBody());
        return email.EmailToEmailOutputDto(email);
    }
}
