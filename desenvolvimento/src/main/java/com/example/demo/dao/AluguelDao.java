package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.legal.Aluguel;
import com.example.demo.model.users.Cliente;

@Repository
public interface AluguelDao extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findAllByCliente(Cliente cliente);
    //List<Usuario> findAllByAgente(Agente agente);
}
