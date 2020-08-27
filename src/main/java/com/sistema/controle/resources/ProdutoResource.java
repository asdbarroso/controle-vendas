package com.sistema.controle.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.controle.entidades.Produto;
import com.sistema.controle.servicos.ProdutoServico;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoServico produtoServico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodos(){
		List<Produto> listaProdutos = produtoServico.buscaTodos();
		return ResponseEntity.ok().body(listaProdutos);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> buscaPorId(@PathVariable Long id){
		Produto produto = produtoServico.buscaPorId(id);
		return ResponseEntity.ok().body(produto);
	}
}
