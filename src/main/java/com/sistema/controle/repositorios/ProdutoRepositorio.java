package com.sistema.controle.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.controle.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

	
	
}
