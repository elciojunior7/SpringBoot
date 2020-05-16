package br.biblioteca.livros.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	private long id;

	@Column(nullable = false, unique = true)
	private String role;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> usuario = new ArrayList<User>();

	public Role(int id, String role) {
		this.id = id;
		this.role = role;
	}

	public Role() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<User> usuario) {
		this.usuario = usuario;
	}

}
