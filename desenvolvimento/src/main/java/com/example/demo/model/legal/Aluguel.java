package com.example.demo.model.legal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.demo.model.users.Cliente;

@Entity
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate data;
	private LocalDate periodo;
	private double valor;
	private boolean aprovado;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Status status;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getPeriodo() {
		return periodo;
	}

	public void setPeriodo(LocalDate periodo) {
		this.periodo = periodo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Aluguel [data=" + data + ", periodo=" + periodo + ", valor=" + valor + ", aprovado=" + aprovado
				+ ", cliente=" + cliente + ", status=" + status + "]";
	}

	public void update(Aluguel aluguel) {
		this.setCliente(aluguel.getCliente());
		this.setData(aluguel.getData());
		this.setPeriodo(aluguel.getPeriodo());
		this.setValor(aluguel.getValor());
		this.setCliente(aluguel.getCliente());

	}

	public void aprovar() {
		this.aprovado = true;
	}
}
