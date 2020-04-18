package br.biblioteca.livros.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.repositories.AutorRepository;
import br.biblioteca.livros.repositories.LivroRepository;

@Service
public class LivroFacade {

	@Autowired
	LivroRepository livroRepositroy;

	@Autowired
	AutorRepository autorRepository;
}
