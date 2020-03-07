package br.biblioteca.livros.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor {
	
	@Id
   @GeneratedValue
   @Column(name = "ID_AUTOR")
   private long id;

   @Column(name = "NOME", nullable = false, unique = true)
   private String nome;
   
   @OneToMany(mappedBy = "livro")
   private List<Livro> livros = new ArrayList<>();

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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
   
}
