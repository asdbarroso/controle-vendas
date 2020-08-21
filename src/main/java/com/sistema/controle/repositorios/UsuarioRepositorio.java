package com.sistema.controle.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.controle.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	
	
}
