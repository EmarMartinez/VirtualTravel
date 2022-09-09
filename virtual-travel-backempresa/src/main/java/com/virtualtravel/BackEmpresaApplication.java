package com.virtualtravel;

import com.virtualtravel.application.CredencialesServiceImpl;
import com.virtualtravel.application.EmailServiceImpl;
import com.virtualtravel.domain.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


import javax.annotation.PostConstruct;



@SpringBootApplication
public class BackEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEmpresaApplication.class, args);
	}

	@Autowired
	CredencialesServiceImpl credencialesService;

	@Autowired
	private EmailServiceImpl emailService;

	@PostConstruct
	public void usuariosAutorizados(){
		credencialesService.addCredenciales(new Credenciales("Emar", "secreto", "admin"));
		credencialesService.addCredenciales(new Credenciales("Usuario1", "secreto", "user"));

	}

}
