package br.alura.com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController // se coloca n precisa do response body ja assume por padrao
public class TopicosController {
	
	@RequestMapping("/topicos") // endereço quando digita esse endereço, chama esse método
	public List<Topico>lista() {
		
	// retornar a lista	
		Topico topico = new Topico("Dúvida", "Duvida com Spring", new Curso("Spring", "Programação"));
		
		return Arrays.asList(topico, topico, topico);
		// criando objeto
		
	}

}
