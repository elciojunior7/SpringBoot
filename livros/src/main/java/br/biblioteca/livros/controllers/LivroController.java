package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
	private final String PATH = "livro/";
	private final String REDIR_PATH = "redirect:livro/";

	@Autowired
	LivroService livroService;

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView(PATH + "list");

		List<Livro> listaLivros = livroService.listaTodosLivros();

		return modelAndView.addObject("livros", listaLivros);
	}

	@GetMapping("/novo")
	public ModelAndView novo() {
		return new ModelAndView(PATH + "list");
	}

	@PostMapping("/gravar")
	public ModelAndView gravar(Livro livro) {
		return new ModelAndView(PATH + "list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		System.out.println(id);

		ModelAndView modelAndView = new ModelAndView(REDIR_PATH + "list");
		modelAndView.addObject("meuID", id);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		System.out.println(id);

		ModelAndView modelAndView = new ModelAndView(REDIR_PATH + "list");
		modelAndView.addObject("meuID", id);
		return modelAndView;
	}

}
