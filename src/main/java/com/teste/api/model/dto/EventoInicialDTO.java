package com.teste.api.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class EventoInicialDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private Date data;
	
	//private LocalDTO local;

	public EventoInicialDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public LocalDTO getLocal() {
//		return local;
//	}
//
//	public void setLocal(LocalDTO local) {
//		this.local = local;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
