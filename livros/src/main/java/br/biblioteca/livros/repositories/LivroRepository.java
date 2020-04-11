package br.biblioteca.livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.biblioteca.livros.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = " from #{#entityName} l left join fetch l.autor a order by l.nome desc ")
	List<Livro> listaLivros();
}
