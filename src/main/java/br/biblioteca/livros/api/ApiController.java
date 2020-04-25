package br.biblioteca.livros.api;

import static br.biblioteca.livros.conversores.LivroConverter.toDTO;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.exception.LivroNotFoundException;
import br.biblioteca.livros.facade.ApiFacade;
import br.biblioteca.livros.models.Livro;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	ApiFacade apiController;

	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> list() {
		List<Livro> listaLivros = apiController.listaTodosLivros();
		return ResponseEntity.ok(toDTO(listaLivros));
	}

	@PostMapping("/livros/avaliacao/{id}")
	public ResponseEntity<Long> comentar(@PathVariable("id") Long id, @Valid @RequestBody AvaliacaoDTO avaliacaoDTO) {

		try {
			return ResponseEntity.ok(apiController.salvarAvaliacao(id, avaliacaoDTO));
		} catch (LivroNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
