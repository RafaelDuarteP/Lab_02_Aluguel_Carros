package com.example.demo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@GetMapping("/usuario")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("usuarios/index");
		List<Usuario> usuarios;
		usuarios = usuarioDao.findAll();
		
		mv.addObject("users", usuarios);
		
		return mv;
	}

	@GetMapping("/usuario/new")
	public String newUsuario() {
		return "usuarios/new";
	}
	
	@GetMapping("usuario/{id}/delete")
	public String delete(@PathVariable long id) {
		try {
			usuarioDao.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
		}
		
		return "redirect:/usuario";
	}
	
	
}
