package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Usuario;
import com.sistema.controle.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<Usuario> buscaTodos(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario buscaPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.get();
		
	}
	
	
}
