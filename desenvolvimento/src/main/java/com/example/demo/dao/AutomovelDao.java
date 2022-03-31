package com.example.demo.dao;

import com.example.demo.model.legal.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelDao extends JpaRepository<Automovel, Long> {
    //List<Automovel> findAllByCliente(Cliente cliente);
}
