package com.alura_cursos.Literalura1;

import com.alura_cursos.Literalura1.principal.Principal;
import com.alura_cursos.Literalura1.repository.AutoresR;
import com.alura_cursos.Literalura1.repository.LibrosR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;


@SpringBootApplication
public class Literalura1Application implements CommandLineRunner {
	@Autowired
	private LibrosR repository;
	@Autowired
	private AutoresR repositoryAutores;
	public static void main(String[] args) {
		SpringApplication.run(Literalura1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository,repositoryAutores);
		principal.seleccionMenu();

		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for (Thread t : threadSet) {
			System.out.println(t);
		}
	}
}