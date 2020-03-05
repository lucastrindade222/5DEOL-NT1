package com.deol.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deol.domain.Usuario;
import com.deol.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;

	public List<Usuario> listarUsuarios(){
		return repositorio.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElse(null);
	}
	
}
