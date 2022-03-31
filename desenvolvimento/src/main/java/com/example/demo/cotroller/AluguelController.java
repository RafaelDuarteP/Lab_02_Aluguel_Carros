package com.example.demo.cotroller;

import com.example.demo.dao.AluguelDao;
import com.example.demo.dao.AutomovelDao;
import com.example.demo.model.legal.Aluguel;
import com.example.demo.model.legal.Status;
import com.example.demo.model.users.Agente;
import com.example.demo.model.users.Cliente;
import com.example.demo.model.users.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AluguelController {

    @Autowired
    AluguelDao aluguelDao;

    @Autowired
    AutomovelDao automovelDao;

    @GetMapping("aluguel/show")
    public ModelAndView show(HttpSession session){
        Usuario user = (Usuario) session.getAttribute("user");
        ModelAndView mv = new ModelAndView("aluguel/show");

        if(user instanceof Cliente){
            mv.addObject("alugueis", aluguelDao.findAllByCliente((Cliente) user));
        }else if(user instanceof Agente){
            mv.addObject("alugueis", aluguelDao.findAll());
        }else{
            mv = new ModelAndView("redirect:/usuario/login");
            return mv;
        }

        mv.addObject("u", user);
        return mv;
    }

    @GetMapping("aluguel/new")
    public ModelAndView novoAluguel(HttpSession session){
        Usuario user = (Usuario) session.getAttribute("user");
        ModelAndView mv = new ModelAndView("aluguel/new");

        if (!(user instanceof Cliente)) {
            mv.setViewName((user instanceof Agente) ? "redirect:/agente" : "redirect:/usuario/login");
            return mv;
        }

        mv.addObject("automoveis", automovelDao.findAll());
        return mv;
    }

    @PostMapping("/aluguel/new")
    public String create(HttpSession session, Aluguel aluguel, Long automovelID){
        Usuario user = (Usuario) session.getAttribute("user");
        if(user == null && !(user instanceof Cliente)) return "redirect:/cliente";

        aluguel.setCliente((Cliente) user);
        aluguel.setStatus(Status.EM_ANALISE);
        System.out.println(automovelID);
        aluguel.setAutomovel(automovelDao.getById(automovelID));

        aluguelDao.save(aluguel);

        return "redirect:/cliente";
    }
}
