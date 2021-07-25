package br.alura.com.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {
	// atributos campos do topicos que quero devolver
	
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	// toda vez que der new no topicodto passa como parametro um objeto do tipo tópico
	public TopicoDto(Topico topico) {
		// onde vai puxar os dados = construtor
		this.id = topico.getId(); // recebo o topido e preencho os atributos
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		
		
	}
	// gets só gerar os gets nessa classe
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public static List<TopicoDto> converter(List<Topico> topicos) {
	    return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	        } // esse metodo recebe o uma lista de topicos e precisa devolver uma lista de topicos dto
				// conversao mapear topico para topico dto // chamando construtor // collectors
				// transforma numa lista
	

}
