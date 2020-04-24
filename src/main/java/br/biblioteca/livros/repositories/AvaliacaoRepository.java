package br.biblioteca.livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.biblioteca.livros.models.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	@Query(value = " from #{#entityName} a left join fetch a.livro l order by l.nome desc ")
	List<Avaliacao> listaAvaliacoes();

}
