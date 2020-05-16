package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.exception.UsuarioNotFoundException;
import br.biblioteca.livros.models.Role;
import br.biblioteca.livros.models.User;
import br.biblioteca.livros.repositories.RoleRepository;
import br.biblioteca.livros.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final String ROLE_BASIC = "ROLE_BASIC";
	private final String ROLE_ADMIN = "ROLE_ADMIN";

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<User> listaUsuarios() {
		return userRepository.findAll();
	}

	public void salvarUsuario(User user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
		Role role = roleRepository.findByRoleName(ROLE_BASIC);
		user.getRoles().add(role);
		userRepository.save(user);
	}

	public void salvarAdmin(User user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
		Role role = roleRepository.findByRoleName(ROLE_ADMIN);
		Role roleBasic = roleRepository.findByRoleName(ROLE_BASIC);
		user.getRoles().add(role);
		user.getRoles().add(roleBasic);
		userRepository.save(user);
	}

	public User buscarUsuario(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException());
	}

	public User buscarUsuarioPorUsername(String usuario) {
		return userRepository.findByUsername(usuario);
	}

	public void excluirUsuario(Long id) {
		userRepository.deleteById(id);
	}
}
