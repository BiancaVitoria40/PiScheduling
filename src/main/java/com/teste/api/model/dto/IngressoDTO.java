package com.teste.api.model.dto;

import java.io.Serializable;

public class IngressoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String status;

	private EventoInicialDTO evento;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EventoInicialDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoInicialDTO evento) {
		this.evento = evento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
