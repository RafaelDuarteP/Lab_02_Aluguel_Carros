package com.example.demo.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/usuario/new")
	public String newUsuario() {
		return "usuarios/new";
	}
}
