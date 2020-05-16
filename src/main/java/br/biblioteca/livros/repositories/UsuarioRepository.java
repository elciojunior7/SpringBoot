package br.biblioteca.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.biblioteca.livros.models.User;

public interface UsuarioRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT u FROM User u WHERE u.usuario = :usuario")
	User findByUsername(@Param("usuario") String usuario);

}