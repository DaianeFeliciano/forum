package br.alura.com.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.alura.com.controller.dto.TopicoDto;
import br.alura.com.controller.form.TopicoForm;
import br.alura.com.forum.modelo.Topico;
import br.alura.com.repository.CursoRepository;
import br.alura.com.repository.TopicoRepository;

@RestController // se coloca n precisa do response body ja assume por padrao
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired // injençao dependencia
	private TopicoRepository topicoRepository;
	
	@Autowired // injençao dependencia
	private CursoRepository cursoRepository;
	
	@GetMapping
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
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
	    Topico topico = form.converter(cursoRepository);
	        topicoRepository.save(topico);
	        
	        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
	        return ResponseEntity.created(uri).body(new TopicoDto(topico));
	        
	        
	
	}
	
}



