package br.biblioteca.livros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//Sem anotation @Table ele cria tabela com nome da classe direto
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "COMENTARIO", nullable = false)
	private String comentario;

	@Column(name = "NOTA", nullable = false)
	private int nota;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIVRO_ID")
	private Livro livro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
