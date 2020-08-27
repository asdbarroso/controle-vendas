package com.sistema.controle.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.controle.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

	
	
}
