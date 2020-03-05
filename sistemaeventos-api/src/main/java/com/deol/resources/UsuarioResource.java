package com.deol.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deol.domain.Usuario;
import com.deol.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		return service.listarUsuarios();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}

}
