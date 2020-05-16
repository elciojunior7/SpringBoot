package br.biblioteca.livros.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.User;
import br.biblioteca.livros.services.SecurityService;
import br.biblioteca.livros.services.UsuarioService;
import br.biblioteca.livros.validator.LoginValidator;
import br.biblioteca.livros.validator.UserValidator;

@Controller
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private UsuarioService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LoginValidator loginValidator;

	@Autowired
	private SecurityService securityService;

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("usuario/login", "usuarioForm", new User());
	}

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("usuario/list");
		List<User> listaUsuarios = userService.listaUsuarios();
		return modelAndView.addObject("usuarios", listaUsuarios);
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		userService.excluirUsuario(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/usuario/list");
		return modelAndView;
	}

	@GetMapping(value = "/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView("usuario/registration");
		modelAndView.addObject("usuarioForm", new User());
		modelAndView.addObject("whoIsThis", "Usuário");
		modelAndView.addObject("target", "Administrador");
		modelAndView.addObject("link", "/usuario/adminRegistration");
		return modelAndView.addObject("action", "/usuario/registration");
	}

	@GetMapping(value = "/adminRegistration")
	public ModelAndView adminRegistration() {
		ModelAndView modelAndView = new ModelAndView("usuario/registration");
		modelAndView.addObject("usuarioForm", new User());
		modelAndView.addObject("whoIsThis", "Administrador");
		modelAndView.addObject("target", "Usuário");
		modelAndView.addObject("link", "/usuario/registration");
		return modelAndView.addObject("action", "/usuario/adminRegistration");
	}

	@PostMapping("/autentication")
	public ModelAndView autentication(@ModelAttribute("usuarioForm") User usuarioForm, BindingResult bindingResult,	Model model) {

		loginValidator.validate(usuarioForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("usuario/login");
		}

		securityService.login(usuarioForm.getUsuario(), usuarioForm.getSenha());
		return new ModelAndView("redirect:/livro/list");
	}

	@PostMapping(value = "/registration")
	public ModelAndView registrationform(@ModelAttribute("usuarioForm") User usuarioForm, BindingResult bindingResult,
			Model model) {

		userValidator.validate(usuarioForm, bindingResult);

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("usuario/registration");
			modelAndView.addObject("whoIsThis", "Usuário");
			modelAndView.addObject("target", "Administrador");
			modelAndView.addObject("link", "/usuario/adminRegistration");
			return modelAndView.addObject("action", "/usuario/registration");
		}

		userService.salvarUsuario(usuarioForm);

		try {
			// este método gera exceção
			// o erro acontece em uma verificação de senhas que nao batem
			securityService.login(usuarioForm.getUsuario(), usuarioForm.getSenha());
			return new ModelAndView("redirect:/list/livro");

		} catch (Exception e) {
			System.out.println(e.toString() + e.getMessage());
			return new ModelAndView("redirect:/usuario/login");
		}
	}

	@PostMapping(value = "/adminRegistration")
	public ModelAndView adminRegistrationform(@ModelAttribute("usuarioForm") User usuarioForm, BindingResult bindingResult, Model model) {

		userValidator.validate(usuarioForm, bindingResult);

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("usuario/registration");
			modelAndView.addObject("whoIsThis", "Administrador");
			modelAndView.addObject("target", "Usuário");
			modelAndView.addObject("link", "/usuario/registration");
			return modelAndView.addObject("action", "/usuario/adminRegistration");
		}

		userService.salvarAdmin(usuarioForm);

		try {
			// este método gera exceção
			// o erro acontece em uma verificação de senhas que nao batem
			securityService.login(usuarioForm.getUsuario(), usuarioForm.getSenha());
			return new ModelAndView("redirect:/list/livro");

		} catch (Exception e) {
			System.out.println(e.toString() + e.getMessage());
			return new ModelAndView("redirect:/usuario/login");
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		if (session != null) {
			session.invalidate();
		}

		return "redirect:/usuario/login";
	}

}
