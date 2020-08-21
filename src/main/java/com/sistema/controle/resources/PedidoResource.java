package com.sistema.controle.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.controle.entidades.Pedido;
import com.sistema.controle.servicos.PedidoServico;


@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoServico pedidoServico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscaTodos(){
		List<Pedido> listaPedidos = pedidoServico.buscaTodos();
		return ResponseEntity.ok().body(listaPedidos);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> buscaPorId(@PathVariable Long id){
		Pedido pedido = pedidoServico.buscaPorId(id);
		return ResponseEntity.ok().body(pedido);
	}
}
