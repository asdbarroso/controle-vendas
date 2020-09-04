package com.sistema.controle.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistema.controle.entidades.Usuario;
import com.sistema.controle.servicos.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioServico usuarioServico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> buscaTodos(){
		List<Usuario> listaUsuarios = usuarioServico.buscaTodos();
		return ResponseEntity.ok().body(listaUsuarios);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> buscaPorId(@PathVariable Long id){
		Usuario usuario = usuarioServico.buscaPorId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public  ResponseEntity<Usuario> inserir(@RequestBody Usuario obj){
		Usuario usr = usuarioServico.inserirUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
