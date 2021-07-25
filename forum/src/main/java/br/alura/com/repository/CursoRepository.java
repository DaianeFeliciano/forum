package br.alura.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alura.com.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository <Curso, Long>{
	
	Curso findByNome(String nome);

}