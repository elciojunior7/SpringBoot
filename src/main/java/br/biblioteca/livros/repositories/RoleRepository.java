package br.biblioteca.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.biblioteca.livros.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT r FROM Role r WHERE r.role = :role")
	Role findByRoleName(@Param("role") String role);

}