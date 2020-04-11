package br.biblioteca.livros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "QTDEPAGINAS")
	private String qtdePaginas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTOR_ID")
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
