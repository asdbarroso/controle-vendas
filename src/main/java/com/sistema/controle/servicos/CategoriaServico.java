package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Categoria;
import com.sistema.controle.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	public List<Categoria> buscaTodos(){
		return categoriaRepositorio.findAll();
	}
	
	public Categoria buscaPorId(Long id) {
		Optional<Categoria> usuario = categoriaRepositorio.findById(id);
		return usuario.get();
		
	}
	
	
}
