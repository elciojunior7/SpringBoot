package br.biblioteca.livros.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.conversores.AvaliacaoConverter;
import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.services.AvaliacaoService;
import br.biblioteca.livros.services.LivroService;

@Service
public class ApiFacade {

	@Autowired
	LivroService livroService;

	@Autowired
	AvaliacaoService avaliacaoService;

	public List<Livro> listaTodosLivros() {
		List<Livro> livros = livroService.listaTodosLivros();
		return livroService.listaTodosLivros();
	}

	public Long salvarAvaliacao(Long idLivro, AvaliacaoDTO avaliacaoDTO) {
		Livro livro = livroService.buscarLivro(idLivro);
		Avaliacao avaliacao = AvaliacaoConverter.toModel(livro, avaliacaoDTO);

		return avaliacaoService.salvarAvaliacao(avaliacao);
	}

}
