package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	public List<Livro> listaTodosLivros() {
		// return livroRepository.findAll();
		return livroRepository.listaLivros();
	}

	public void salvarLivro(Livro livro) {
		livroRepository.save(livro);
	}

	public Livro buscarLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public void excluirLivro(Long id) {
		livroRepository.deleteById(id);
	}
}
