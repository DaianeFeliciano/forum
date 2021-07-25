package br.alura.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.alura.com.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository <Topico, Long>{
//curso entidade de relacionamento e nome é o atributo de dentro dessa entidade
	List<Topico> findByCursoNome(String nomeCurso);
	

}
