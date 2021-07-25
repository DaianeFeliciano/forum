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
	public List<TopicoDto>lista() {
		
	// retornar a lista	
		Topico topico = new Topico("Dúvida", "Duvida com Spring", new Curso("Spring", "Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		// criando objeto / converter de topico para topico dto
		
	}

}
