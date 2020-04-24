package br.biblioteca.livros.dto;

import java.util.ArrayList;
import java.util.List;

public class LivroDTO {

	private String titulo;
	private String qtdePaginas;
	private String autor;
	private List<AvaliacaoDTO> avaliacoes = new ArrayList<AvaliacaoDTO>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(String qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<AvaliacaoDTO> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
