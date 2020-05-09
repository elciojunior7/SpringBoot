package br.biblioteca.livros.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Autor;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("livro")
public class LivroController {
	private final String PATH = "livro/";
	private final String REDIR_PATH = "redirect:/livro/";

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livro/list");
		List<Autor> listaAutores = autorService.listaAutores();
		modelAndView.addObject("listaAutores", listaAutores);
		List<Livro> listaLivros = livroService.listaTodosLivros();

		return modelAndView.addObject("livros", listaLivros);
	}

	@GetMapping("/novo")
	public ModelAndView novo(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livro/list");
		List<Autor> listaAutores = autorService.listaAutores();
		modelAndView.addObject("listaAutores", listaAutores);
		List<Livro> listaLivros = livroService.listaTodosLivros();
		return modelAndView.addObject("livros", listaLivros);
	}

	@PostMapping("/gravar")
	public ModelAndView gravar(@Valid Livro livro, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Autor> listaAutores = autorService.listaAutores();
			return new ModelAndView("livro/list", "listaAutores", listaAutores);
		}

		livroService.salvarLivro(livro);
		return new ModelAndView("redirect:/livro/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = livroService.buscarLivro(id);
		List<Autor> listaAutores = autorService.listaAutores();
		List<Livro> listaLivros = livroService.listaTodosLivros();
		ModelAndView modelAndView = new ModelAndView("livro/list");
		modelAndView.addObject("listaAutores", listaAutores);
		modelAndView.addObject("livro", livro);
		modelAndView.addObject("livros", listaLivros);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		livroService.excluirLivro(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/livro/list");
		return modelAndView;
	}

}
