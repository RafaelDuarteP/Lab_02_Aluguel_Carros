package com.example.demo.model.legal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.model.users.Usuario;

@Entity
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tipo;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Usuario usuario;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Contrato [tipo=" + tipo +  ", usuario=" + usuario + "]";
	}

	public void update(Contrato contrato) {
		this.setTipo(contrato.getTipo());
		this.setUsuario(contrato.getUsuario());
	}

}
