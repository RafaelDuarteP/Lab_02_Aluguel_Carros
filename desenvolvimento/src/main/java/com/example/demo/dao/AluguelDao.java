package com.example.demo.dao;

import com.example.demo.model.legal.Aluguel;
import com.example.demo.model.users.Agente;
import com.example.demo.model.users.Cliente;
import com.example.demo.model.users.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AluguelDao extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findAllByCliente(Cliente cliente);
    //List<Usuario> findAllByAgente(Agente agente);
}
