package com.example.demo.model.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profissao {
	@Id
	private String nome;
	private String empregador;
	private double rendimentos;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpregador() {
		return this.empregador;
	}

	public void setEmpregador(String empregador) {
		this.empregador = empregador;
	}

	public double getRendimentos() {
		return this.rendimentos;
	}

	public void setRendimentos(double rendimentos) {
		this.rendimentos = rendimentos;
	}

}
