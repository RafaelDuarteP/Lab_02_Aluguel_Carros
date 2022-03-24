package com.example.demo.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UsuarioDao;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("/usuario/new")
	public String newUsuario() {

		return "usuarios/new";
	}
}
