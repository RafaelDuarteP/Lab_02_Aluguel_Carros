package com.example.demo.model.legal;

import java.time.LocalDate;

import javax.persistence.*;

import com.example.demo.model.users.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.MERGE)
	private Automovel automovel;
	private String data;
	private String periodo;
	private double valor;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Status status;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
		return "Aluguel [data=" + data + ", periodo=" + periodo + ", valor=" + valor + ", cliente=" + cliente + ", status=" + status + "]";
	}

	public void update(Aluguel aluguel) {
		this.setCliente(aluguel.getCliente());
		this.setData(aluguel.getData());
		this.setPeriodo(aluguel.getPeriodo());
		this.setValor(aluguel.getValor());
		this.setCliente(aluguel.getCliente());

	}

	public void aprovar() {
		setStatus(Status.APROVADO);
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
}
