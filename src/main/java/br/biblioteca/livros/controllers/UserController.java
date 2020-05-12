package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.User;

@Controller
@RequestMapping("usuario")
public class UserController {

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("usuario/login", "user", new User());
	}

	@GetMapping(value = "/registration")
	public ModelAndView registration() {
		return new ModelAndView("usuario/registration", "user", new User());
	}

}
