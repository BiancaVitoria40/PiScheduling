package com.teste.api.model.dto;

import java.io.Serializable;


public class ItemCarrinhoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private double valor;

	private double total;

//	private EventoInicialDTO evento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

//	public String getEvento() {
//		return evento.getNome();
//	}
//
//	public void setEvento(EventoInicialDTO evento) {
//		this.evento = evento;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
