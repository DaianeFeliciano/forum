package br.alura.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alura.com.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository <Topico, Long>{
	

}
