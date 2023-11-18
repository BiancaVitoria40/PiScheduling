package com.teste.api.model.entidades;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Ingresso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setores setor;

	//@JsonIgnore
	@ManyToMany(mappedBy = "ingressos")
	private Set<ItemCarrinho> itemCarrinho = new HashSet<ItemCarrinho>();

	private String nome;

	private double valor;

	private String tipoIngresso;

	private String status;

	public Ingresso() {

	}

	public Ingresso(Evento evento, Setores setor, Set<ItemCarrinho> reservas, String nome, double valor, String tipoIngresso,
			String status) {
		super();
		this.evento = evento;
		this.setor = setor;
		this.itemCarrinho = reservas;
		this.nome = nome;
		this.valor = valor;
		this.tipoIngresso = tipoIngresso;
		this.status = status;
	}

	public Set<ItemCarrinho> getReservas() {
		return itemCarrinho;
	}

	public void setReservas(Set<ItemCarrinho> reservas) {
		this.itemCarrinho = reservas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Setores getSetor() {
		return setor;
	}

	public void setSetor(Setores setor) {
		this.setor = setor;
	}

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

	public int getId() {
		return id;
	}

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	



	
	
}
