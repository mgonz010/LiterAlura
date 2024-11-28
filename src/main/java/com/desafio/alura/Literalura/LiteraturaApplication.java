package com.desafio.alura.Literalura;

import com.desafio.alura.Literalura.Repository.AutorRepository;
import com.desafio.alura.Literalura.Repository.LibroRepository;
import com.desafio.alura.Literalura.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepositorio;
	@Autowired
	private AutorRepository autorRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal client = new Principal(libroRepositorio, autorRepositorio);
		client.menu();
	}

}
