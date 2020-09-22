package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Usuario;
import com.sistema.controle.repositorios.UsuarioRepositorio;
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
		usuarioRepositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario entidade = usuarioRepositorio.getOne(id);
		atualizaUsuario(entidade, usuario);
		return usuarioRepositorio.save(entidade);
	}

	private void atualizaUsuario(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setTelefone(usuario.getTelefone());
		entidade.setEmail(usuario.getEmail());
	}
	
	
}
