package com.example.demo.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Agente;
import com.example.demo.model.users.Endereco;
import com.example.demo.model.users.Usuario;

@Controller
@RequestMapping("/agente")
public class AgenteController {
	@Autowired
	UsuarioDao usuarioDao;

	@PostMapping("/new")
	public String novoAgente(HttpSession session,Agente a, Endereco e) {
		a.setEndereco(e);
		usuarioDao.save(a);
		session.setAttribute("user", a);
		return "redirect:/agente";
	}

	@GetMapping("")
	public ModelAndView show(HttpSession  session) {
		ModelAndView mv;
		Usuario user =(Usuario) session.getAttribute("user");
		
		if (user != null){
			mv = new ModelAndView("agente/show");
			try {
				Agente c = (Agente) user;
				mv.addObject("a", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/cliente");
			}
		}
		else {
			mv = new ModelAndView("redirect:/usuario/login");
		}
		return mv;

	}
	
	@GetMapping("/edit")
	public ModelAndView edit(HttpSession session) {
		ModelAndView mv;
		Usuario user = (Usuario) session.getAttribute("user");

		if (user != null) {
			mv = new ModelAndView("agente/edit");
			try {
				Agente c = (Agente) user;
				mv.addObject("c", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/cliente");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario/login");
		}
		return mv;

	}
	
	@PostMapping("")
	public ModelAndView update(HttpSession session, Agente agente, Endereco end) {
		Usuario user = (Usuario) session.getAttribute("user");
		ModelAndView mv;

		
		if (user != null) {
			mv = new ModelAndView("redirect:/agente/");
			try {
				Agente c = (Agente) user;
				c.update(agente);
				c.getEndereco().update(end);
				usuarioDao.save(c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/agente");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario/login");
		}
		return mv;
	}
	

}
