package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Usuario;
import com.sistema.controle.repositorios.UsuarioRepositorio;
import com.sistema.controle.servicos.excecoes.DatabaseException;
import com.sistema.controle.servicos.excecoes.ResourceNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public List<Usuario> buscaTodos(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario buscaPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public void apagar(Long id) {
		try {
		usuarioRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		try {
		Usuario entidade = usuarioRepositorio.getOne(id);
		atualizaUsuario(entidade, usuario);
		return usuarioRepositorio.save(entidade);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualizaUsuario(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setTelefone(usuario.getTelefone());
		entidade.setEmail(usuario.getEmail());
	}
	
	
}
