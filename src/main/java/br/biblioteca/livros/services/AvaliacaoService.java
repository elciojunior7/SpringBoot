package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	public List<Avaliacao> listaTodasAvaliacoes() {
		return avaliacaoRepository.findAll();
		// return avaliacaoRepository.listaAvaliacoes();
	}

	public Long salvarAvaliacao(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao).getId();
	}
}
