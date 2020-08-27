package com.sistema.controle.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.controle.entidades.Categoria;
import com.sistema.controle.servicos.CategoriaServico;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> buscaTodos(){
		List<Categoria> listaCategorias = categoriaServico.buscaTodos();
		return ResponseEntity.ok().body(listaCategorias);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> buscaPorId(@PathVariable Long id){
		Categoria categoria = categoriaServico.buscaPorId(id);
		return ResponseEntity.ok().body(categoria);
	}
}
