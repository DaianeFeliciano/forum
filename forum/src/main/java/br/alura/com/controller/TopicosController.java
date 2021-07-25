package br.alura.com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alura.com.controller.dto.TopicoDto;
import br.alura.com.forum.modelo.Curso;
import br.alura.com.forum.modelo.Topico;
import br.alura.com.repository.TopicoRepository;

@RestController // se coloca n precisa do response body ja assume por padrao
public class TopicosController {
	
	@Autowired // injençao dependencia
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos") // endereço quando digita esse endereço, chama esse método
	public List<TopicoDto>lista(String nomeCurso) {
		//System.out.println(nomeCurso);
		
		if(nomeCurso == null) {
			
			List<Topico> topicos = topicoRepository.findAll();  // consulta que carrega todos os registro do bd
			return TopicoDto.converter(topicos);
		} else {
			
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);  // consulta que carrega todos os registro do bd
			return TopicoDto.converter(topicos);
			
		}
		  
		
		
		
	}

}
