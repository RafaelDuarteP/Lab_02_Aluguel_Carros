package com.example.demo.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profissao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cargo;
	private String empregador;
	private double rendimentos;

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String nome) {
		this.cargo = nome;
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

	@Override
	public String toString() {
		return "Profissao [id=" + this.id + ", cargo=" + this.cargo + ", empregador=" + this.empregador
				+ ", rendimentos=" + this.rendimentos + "]";
	}
	
	public void update(Profissao profissao) {
		this.cargo = profissao.getCargo();
		this.empregador = profissao.getEmpregador();
		this.rendimentos = profissao.getRendimentos();
	}

}
