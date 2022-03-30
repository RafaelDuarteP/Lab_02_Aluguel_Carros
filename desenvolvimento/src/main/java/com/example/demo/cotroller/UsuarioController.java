package com.example.demo.cotroller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Cliente;
import com.example.demo.model.users.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("/new")
	public String newUsuario() {
		return "usuarios/new";
	}

	@GetMapping("/delete")
	public String delete(HttpSession session) {
		Usuario user = (Usuario) session.getAttribute("user");
		if (user != null) {
			try {
				usuarioDao.deleteById(user.getId());
			} catch (EmptyResultDataAccessException e) {
			}
		}

		return "redirect:/usuario/logout";
	}

	@GetMapping("/login")
	public String login() {
		return "usuarios/login";
	}

	@PostMapping("/login")
	public String logar(String email, String senha, HttpSession session) {
		String redirectString = "/usuario/login";
		Optional<Usuario> userOptional = usuarioDao.findByEmail(email);

		if (userOptional.isPresent()) {
			Usuario user = userOptional.get();
			if (user.validarLogin(senha)) {
				String tipo = user.getClass().getSimpleName().toLowerCase();
				redirectString = "/" + tipo;
				if (tipo.equals("cliente")) {
					((Cliente)user).primeiraProfissao().getCargo(); //isso só para um erro que tava dando
				}
				session.setAttribute("user", user);
			}
		}
		return "redirect:" + redirectString;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
