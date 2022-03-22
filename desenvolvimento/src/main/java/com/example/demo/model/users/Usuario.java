package com.example.demo.model.users;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public abstract class Usuario {

	@Id
	private String email;
	private String senha;
	private String nome;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "endereco")
	private Endereco endereco;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEnd() {
		return this.endereco;
	}

	public void setEnd(Endereco end) {
		this.endereco = end;
	}

	

}
