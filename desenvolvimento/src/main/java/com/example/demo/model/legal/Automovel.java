package com.example.demo.model.legal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Automovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String matricula;
	@Column(unique = true)
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Contrato contrato;
	

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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
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
