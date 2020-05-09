package br.biblioteca.livros.dto;

import java.util.ArrayList;
import java.util.List;

public class AutorDTO {

	private String nome;
	private List<String> tituloLivros = new ArrayList<String>();


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getTituloLivros() {
		return tituloLivros;
	}

	public void setTituloLivros(List<String> tituloLivros) {
		this.tituloLivros = tituloLivros;
	}

}
