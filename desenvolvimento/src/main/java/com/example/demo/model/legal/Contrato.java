package com.example.demo.model.legal;

import javax.persistence.Entity;

import com.example.demo.model.users.Usuario;

@Entity
public class Contrato {
   private String tipo;
   private Automovel automovel;
   private Usuario usuario;
   

public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public Automovel getAutomovel() {
	return automovel;
}
public void setAutomovel(Automovel automovel) {
	this.automovel = automovel;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
@Override
public String toString() {
	return "Contrato [tipo=" + tipo + ", automovel=" + automovel + ", usuario=" + usuario + "]";
}
public void update(Contrato contrato) {
	this.setAutomovel(contrato.getAutomovel());
	this.setTipo(contrato.getTipo());
	this.setUsuario(contrato.getUsuario());
}
   
}
