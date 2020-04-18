package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Autor;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
	private final String PATH = "livro/";
	private final String REDIR_PATH = "redirect:livro/";

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView(PATH + "list");

		List<Livro> listaLivros = livroService.listaTodosLivros();

		return modelAndView.addObject("livros", listaLivros);
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView(PATH + "list");
		List<Autor> listaAutores = autorService.listaAutores();
		modelAndView.addObject("listaAutores", listaAutores);
		return modelAndView;
	}

	@PostMapping("/gravar")
	public ModelAndView gravar(Livro livro, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Autor> listaAutores = autorService.listaAutores();
			return new ModelAndView(PATH + "list", "listaAutores", listaAutores);
		}

		livroService.salvarLivro(livro);
		return new ModelAndView(REDIR_PATH + "list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = livroService.buscarLivro(id);

		List<Autor> listaAutores = autorService.listaAutores();

		ModelAndView modelAndView = new ModelAndView(REDIR_PATH + "list");
		modelAndView.addObject("listaAutores", listaAutores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		livroService.excluirLivro(id);
		ModelAndView modelAndView = new ModelAndView(REDIR_PATH + "list");
		return modelAndView;
	}

}