package br.biblioteca.livros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro {

	@Id
	@GeneratedValue
	@Column(name = "ID_LIVRO")
	private long id;

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "QTDEPAGINAS")
	private String qtdePaginas;

	@ManyToOne
	@JoinColumn(name = "ID_AUTOR")
	private Autor autor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQtdePaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(String qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
