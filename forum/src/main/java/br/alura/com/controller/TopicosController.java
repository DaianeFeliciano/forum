package br.alura.com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alura.com.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController // se coloca n precisa do response body ja assume por padrao
public class TopicosController {
	
	@RequestMapping("/topicos") // endereço quando digita esse endereço, chama esse método
	public List<TopicoDto>lista() {
		
	// retornar a lista	
		Topico topico = new Topico("Dúvida", "Duvida com Spring", new Curso("Spring", "Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
		// criando objeto / converter de topico para topico dto
		
	}

}
