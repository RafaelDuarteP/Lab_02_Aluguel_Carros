package com.example.demo.model.users;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Agente extends Usuario {
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

}
