package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/livro")
public class LivrosController {
	private final String PATH = "/livro/";
	private final String REDIR_PATH = "redirect:/livro/";
	
	@GetMapping("/list")
	public ModelAndView list() {
		return new ModelAndView(PATH+"list");
	}
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		return new ModelAndView(PATH+"list");
	}
	
	@PostMapping("/gravar")
	public ModelAndView gravar(/*Livro livro*/) {
		return new ModelAndView(PATH+"list");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		System.out.println(id);
		
		ModelAndView modelAndView = new ModelAndView(REDIR_PATH+"list");
		modelAndView.addObject("meuID", id);
		return modelAndView;
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		System.out.println(id);
		
		ModelAndView modelAndView = new ModelAndView(REDIR_PATH+"list");
	    modelAndView.addObject("meuID", id);
		return modelAndView;
	}

}
