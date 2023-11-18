package com.teste.api.model.dto;

import java.sql.Date;

public class EventoFinalDTO {
  
	// classe retorna a pagina de um evento
	
	private String nome;
	private Date data;
	private String descricao;
	private LocalDTO local;
	private byte[] imagem;

	public EventoFinalDTO() {
		super();
		
	}

	public void setLocal(LocalDTO local) {
		this.local = local;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDTO getLocal() {
		return local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	
	
	

}
