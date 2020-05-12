package br.biblioteca.livros.models;

public class Role {
	
	String role;
	
	public Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [Role =" + role + "]";
	}


}
