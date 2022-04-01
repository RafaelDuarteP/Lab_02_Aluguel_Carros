package com.example.demo.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Cliente;
import com.example.demo.model.users.Endereco;
import com.example.demo.model.users.Profissao;
import com.example.demo.model.users.Usuario;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	UsuarioDao usuarioDao;

	@PostMapping("/new")
	public String novoCliente(HttpSession session ,Cliente c, Profissao p, Endereco e) {
		c.addProfissao(p);
		c.setEndereco(e);

		usuarioDao.save(c);
		session.setAttribute("user", c);

		return "redirect:/cliente";
	}

	@GetMapping("")
	public ModelAndView show(HttpSession session) {
		Usuario user = (Usuario) session.getAttribute("user");
		ModelAndView mv;

		if (user != null) {
			mv = new ModelAndView("cliente/show");
			try {
				Cliente c = (Cliente) user;
				mv.addObject("c", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/agente");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario/login");
		}
		return mv;

	}
	
	@GetMapping("/edit")
	public ModelAndView edit(HttpSession session) {
		Usuario user = (Usuario) session.getAttribute("user");
		ModelAndView mv;

		if (user != null) {
			mv = new ModelAndView("cliente/edit");
			try {
				Cliente c = (Cliente) user;
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
	public ModelAndView update(HttpSession session, Cliente cliente, Endereco end, Profissao p) {
		Usuario user = (Usuario) session.getAttribute("user");
		ModelAndView mv;

		if (user != null) {
			mv = new ModelAndView("redirect:/cliente/");
			try {
				Cliente c = (Cliente) user;
				c.update(cliente);
				c.getEndereco().update(end);
				c.primeiraProfissao().update(p);
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
