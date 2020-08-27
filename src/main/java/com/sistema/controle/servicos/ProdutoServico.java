package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Produto;
import com.sistema.controle.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	public List<Produto> buscaTodos(){
		return produtoRepositorio.findAll();
	}
	
	public Produto buscaPorId(Long id) {
		Optional<Produto> usuario = produtoRepositorio.findById(id);
		return usuario.get();
		
	}
	
	
}
