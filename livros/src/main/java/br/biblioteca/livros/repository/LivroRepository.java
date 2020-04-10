package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.biblioteca.livros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
