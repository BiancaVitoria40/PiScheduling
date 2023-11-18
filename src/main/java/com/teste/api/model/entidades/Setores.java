package com.teste.api.model.entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Setores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@ManyToMany(mappedBy = "setores")
	private Set<Evento> eventos = new HashSet<>();

//	@JsonIgnore
//	@OneToMany(mappedBy = "setor")
//	private List<ItemCarrinho> reservas = new ArrayList<>();

	private int quantidadePessoas;
	private String nome;
	private String tipo;

	

	public Setores(int id, Set<Evento> eventos, List<ItemCarrinho> reservas, int quantidadePessoas, String nome,
			String tipo) {
		super();
		this.id = id;
		this.eventos = eventos;
//		this.reservas = reservas;
		this.quantidadePessoas = quantidadePessoas;
		this.nome = nome;
		this.tipo = tipo;
	}

//	public List<ItemCarrinho> getReservas() {
//		return reservas;
//	}
//
//	public void setReservas(List<ItemCarrinho> reservas) {
//		this.reservas = reservas;
//	}

	public Setores() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

}
