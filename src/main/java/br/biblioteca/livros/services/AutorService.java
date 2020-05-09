package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.exception.AutorNotFoundException;
import br.biblioteca.livros.models.Autor;
import br.biblioteca.livros.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepository;

	public List<Autor> listaAutores() {
		return autorRepository.findAll();
	}

	public void salvarAutor(Autor autor) {
		autorRepository.save(autor);
	}

	public Autor buscarAutor(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new AutorNotFoundException());
	}

	public void excluirAutor(Long id) {
		autorRepository.deleteById(id);
	}
}
