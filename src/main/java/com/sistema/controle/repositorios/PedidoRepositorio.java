package com.sistema.controle.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.controle.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

	
	
}
