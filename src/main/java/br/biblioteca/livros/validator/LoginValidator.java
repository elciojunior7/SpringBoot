package br.biblioteca.livros.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.biblioteca.livros.models.User;
import br.biblioteca.livros.services.UsuarioService;


@Component
public class LoginValidator implements Validator {
	
	@Autowired
	private UsuarioService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usuario", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "NotEmpty");
		
		if (userService.buscarUsuarioPorUsername(user.getUsuario()) == null) {
			errors.rejectValue("usuario", "NotExist.usuarioForm.usuario");
		}
		
	}
}