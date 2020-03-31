package com.deol.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deol.domain.Usuario;
import com.deol.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario save(Usuario usuario) {
		usuario.setDataCadastro(new Date());
		return repository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
		Usuario objUpdate = findById(usuario.getId());
		usuario.setDataCadastro(objUpdate.getDataCadastro());
		return repository.save(usuario);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
