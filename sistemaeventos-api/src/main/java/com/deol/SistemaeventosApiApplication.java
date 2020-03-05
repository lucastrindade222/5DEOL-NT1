package com.deol;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deol.domain.Usuario;
import com.deol.repositories.UsuarioRepository;

@SpringBootApplication
public class SistemaeventosApiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaeventosApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Wolney");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Henrique");
		
		repositorio.saveAll(Arrays.asList(usuario, usuario2));
	}

}
