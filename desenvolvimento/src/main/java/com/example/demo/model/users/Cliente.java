package com.example.demo.model.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario {
	@Column(unique = true)
	private String rg;
	@Column(unique = true)
	private String cpf;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "profissao_id")
	private List<Profissao> profissao;

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
		profissao = new ArrayList<>();
	}

	public void addProfissao(Profissao profissao) {
		if (this.profissao.size() <= 3) {
			this.profissao.add(profissao);
		}
	}

	public List<Profissao> getProfissao() {
		return this.profissao;
	}

	public void setProfissao(List<Profissao> profissao) {
		this.profissao = profissao;
	}

}
