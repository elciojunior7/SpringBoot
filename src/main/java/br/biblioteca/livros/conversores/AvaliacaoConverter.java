package br.biblioteca.livros.conversores;

import java.util.List;
import java.util.stream.Collectors;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.models.Livro;

public class AvaliacaoConverter {

	public static AvaliacaoDTO toDTO(Avaliacao avaliacao) {
		AvaliacaoDTO dto = new AvaliacaoDTO();
		dto.setComentario(avaliacao.getComentario());
		dto.setNota(avaliacao.getNota());
		dto.setLivro(avaliacao.getLivro() != null ? avaliacao.getLivro().getNome() : null);
		return dto;
	}

	public static List<AvaliacaoDTO> toDTO(List<Avaliacao> avaliacoes) {
		return avaliacoes.stream().map(a -> toDTO(a)).collect(Collectors.toList());
	}

	public static Avaliacao toModel(Livro livro, AvaliacaoDTO dto) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComentario(dto.getComentario());
		avaliacao.setNota(dto.getNota());
		avaliacao.setLivro(livro);
		return avaliacao;
	}

	public static Avaliacao toModel(AvaliacaoDTO dto) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComentario(dto.getComentario());
		avaliacao.setNota(dto.getNota());
		return avaliacao;
	}

}
