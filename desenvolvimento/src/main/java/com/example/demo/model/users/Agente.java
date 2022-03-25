package com.example.demo.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Agente extends Usuario {
	@Column(unique = true)
	private String cnpj;
	@Enumerated(EnumType.STRING)
	private TipoAgente tipoAgente;

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoAgente getTipoAgente() {
		return this.tipoAgente;
	}

	public void setTipoAgente(TipoAgente tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	public void update(Agente agente) {

		this.cnpj = agente.cnpj;
		this.setNome(agente.getNome());
		this.setEmail(agente.getEmail());
		this.setSenha(agente.getSenha());
	}

}
