package com.teste.api.model.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(mappedBy = "local")
	private Evento evento;
	private String nome;
	private String cep;
	private String logradouro;
	private String numeroLocal;
	private String bairro;

	public Local() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Local(Evento evento, String cep, String logradouro, String numeroLocal, String bairro) {
		super();
		this.evento = evento;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numeroLocal = numeroLocal;
		this.bairro = bairro;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getNumeroLocal() {
		return numeroLocal;
	}

	public void setNumeroLocal(String numeroLocal) {
		this.numeroLocal = numeroLocal;
	}

}
