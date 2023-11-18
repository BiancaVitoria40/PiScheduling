package com.teste.api.model.dto;

import java.io.Serializable;
import java.util.List;

public class ReservaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int quantidadeReserva;
	private List<ItemCarrinhoDTO> ingressos;

	public int getQuantidadeReserva() {
		return quantidadeReserva;
	}

	public void setQuantidadeReserva(int quantidadeReserva) {
		this.quantidadeReserva = quantidadeReserva;
	}


	public List<ItemCarrinhoDTO> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<ItemCarrinhoDTO> ingressos) {
		this.ingressos = ingressos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
