package com.example.demo.cotroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Agente;
import com.example.demo.model.users.Endereco;
import com.example.demo.model.users.Usuario;

@Controller
public class AgenteController {
	@Autowired
	UsuarioDao usuarioDao;

	@PostMapping("/agente/new")
	public String novoAgente(Agente a, Endereco e) {
		a.setEndereco(e);
		usuarioDao.save(a);
		return "redirect:/usuario";
	}

	@GetMapping("/agente/{id}")
	public ModelAndView show(@PathVariable long id) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("agente/show");
			try {
				Agente c = (Agente) user.get();
				mv.addObject("a", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/usuario");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario");
		}
		return mv;

	}
	
	@GetMapping("/agente/{id}/edit")
	public ModelAndView edit(@PathVariable long id) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("agente/edit");
			try {
				Agente c = (Agente) user.get();
				mv.addObject("c", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/usuario");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario");
		}
		return mv;

	}
	
	@PostMapping("/agente/{id}")
	public ModelAndView update(@PathVariable long id, Agente agente, Endereco end) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("redirect:/agente/" + id);
			try {
				Agente c = (Agente) user.get();
				c.update(agente);
				c.getEndereco().update(end);
				usuarioDao.save(c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/usuario");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario");
		}
		return mv;
	}

}
