package com.example.demo.cotroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.model.users.Cliente;
import com.example.demo.model.users.Endereco;
import com.example.demo.model.users.Profissao;
import com.example.demo.model.users.Usuario;

@Controller
public class ClienteController {
	@Autowired
	UsuarioDao usuarioDao;

	@PostMapping("/cliente/new")
	public String novoCliente(Cliente c, Profissao p, Endereco e) {
		c.addProfissao(p);
		c.setEndereco(e);

		usuarioDao.save(c);

		return "redirect:/usuario";
	}

	@GetMapping("/cliente/{id}")
	public ModelAndView show(@PathVariable long id) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("cliente/show");
			try {
				Cliente c = (Cliente) user.get();
				mv.addObject("c", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/usuario");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario");
		}
		return mv;

	}
	
	@GetMapping("/cliente/{id}/edit")
	public ModelAndView edit(@PathVariable long id) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("cliente/edit");
			try {
				Cliente c = (Cliente) user.get();
				mv.addObject("c", c);
			} catch (ClassCastException e) {
				mv = new ModelAndView("redirect:/usuario");
			}

		} else {
			mv = new ModelAndView("redirect:/usuario");
		}
		return mv;

	}
	
	@PostMapping("/cliente/{id}")
	public ModelAndView update(@PathVariable long id, Cliente cliente, Endereco end, Profissao p) {
		Optional<Usuario> user = usuarioDao.findById(id);
		ModelAndView mv;

		if (user.isPresent()) {
			mv = new ModelAndView("redirect:/cliente/" + id);
			try {
				cliente.setEndereco(end);
				cliente.addProfissao(p);
				Cliente c = (Cliente) user.get();
				c.update(cliente);
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
