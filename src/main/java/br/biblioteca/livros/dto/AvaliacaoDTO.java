package br.biblioteca.livros.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class AvaliacaoDTO {

	@NotEmpty(message = "Comentário é obrigatório")
	private String comentario;

	@Min(1)
	@Max(10)
	private int nota;
	private String livro;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

}
