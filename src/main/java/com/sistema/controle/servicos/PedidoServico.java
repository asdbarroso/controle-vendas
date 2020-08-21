package com.sistema.controle.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.controle.entidades.Pedido;
import com.sistema.controle.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	public List<Pedido> buscaTodos(){
		return pedidoRepositorio.findAll();
	}
	
	public Pedido buscaPorId(Long id) {
		Optional<Pedido> usuario = pedidoRepositorio.findById(id);
		return usuario.get();
		
	}
	
	
}
