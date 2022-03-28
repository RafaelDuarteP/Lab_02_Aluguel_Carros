package com.example.demo.model.legal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Automovel {
	private String matricula;
	private String modelo;
	private String marca;
	private int ano;
	private Contrato contrato;
	@Column(unique = true)
	private String placa;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Automovel [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", ano=" + ano
				+ ", placa=" + placa + "]";
	}
	public void update(Automovel automovel) {
		this.setAno(automovel.getAno());
		this.setMarca(automovel.getMarca());
		this.setMatricula(automovel.getMatricula());
		this.setModelo(automovel.getModelo());
		this.placa=automovel.placa;
	}

}
