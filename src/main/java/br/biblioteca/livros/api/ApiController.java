package br.biblioteca.livros.api;

import static br.biblioteca.livros.conversores.LivroConverter.toDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.services.LivroService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	LivroService livroService;

	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> list() {
		List<Livro> listaLivros = livroService.listaTodosLivros();
		return ResponseEntity.ok(toDTO(listaLivros));
	}
}
