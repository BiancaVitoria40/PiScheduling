package com.teste.api.model.entidades;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
