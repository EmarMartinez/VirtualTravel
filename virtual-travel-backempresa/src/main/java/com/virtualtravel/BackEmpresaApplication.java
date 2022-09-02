package com.virtualtravel;

import com.virtualtravel.domain.Credenciales;
import com.virtualtravel.infraestructure.repository.CredencialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BackEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEmpresaApplication.class, args);
	}

	@Autowired
	CredencialesRepository credencialesRepository;

	@PostConstruct
	public void usuariosAutorizados(){
		credencialesRepository.save(new Credenciales("Emar", "secreto"));
		credencialesRepository.save(new Credenciales("Admin", "secreto"));

	}
}
