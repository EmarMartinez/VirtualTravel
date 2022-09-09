package com.virtualtravel.domain;


import com.virtualtravel.infraestructure.controller.dto.EmailOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    @GeneratedValue
    int id_email;

    String subject;
    String body;
    String mailTo;

    public EmailOutputDto EmailToEmailOutputDto(Email email) {
        return new EmailOutputDto(email.getId_email(), email.getSubject(), email.getBody(), email.getMailTo() );
    }
}
