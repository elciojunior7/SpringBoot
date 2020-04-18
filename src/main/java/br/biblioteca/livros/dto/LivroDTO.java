package br.biblioteca.livros.dto;

public class LivroDTO {

	private String titulo;
	private String qtdePaginas;
	private String autor;

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

}
