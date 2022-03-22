package com.example.demo.model.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Usuario {
	private String rg;
	private String cpf;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinTable(name = "profissao")
//	private List<Profissao> profissao;

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cliente() {
		super();
//		profissao = new ArrayList<>();
	}

}
