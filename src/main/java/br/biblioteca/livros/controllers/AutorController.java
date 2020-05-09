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
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	LivroService livroService;

	@Autowired
	AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute Autor autor) {
		ModelAndView modelAndView = new ModelAndView("autor/list");
		List<Autor> listaAutores = autorService.listaAutores();

		return modelAndView.addObject("autores", listaAutores);
	}

	@GetMapping("/novo")
	public ModelAndView novo(@ModelAttribute Autor autor) {
		ModelAndView modelAndView = new ModelAndView("autor/list");
		List<Autor> listaAutores = autorService.listaAutores();

		return modelAndView.addObject("autores", listaAutores);
	}

	@PostMapping("/gravar")
	public ModelAndView gravar(@Valid Autor autor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("autor/list");
		}

		autorService.salvarAutor(autor);
		return new ModelAndView("redirect:/autor/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Autor autor = autorService.buscarAutor(id);
		List<Autor> listaAutores = autorService.listaAutores();
		ModelAndView modelAndView = new ModelAndView("autor/list");
		modelAndView.addObject("autores", listaAutores);
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {

		autorService.excluirAutor(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/autor/list");
		return modelAndView;
	}

}
