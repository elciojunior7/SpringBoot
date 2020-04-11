package br.biblioteca.livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.biblioteca.livros.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
