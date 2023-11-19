package com.teste.api.model.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Setores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@ManyToMany(mappedBy = "setores")
	private Set<Evento> eventos = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "setor")
	private List<Reserva> agendamento = new ArrayList<>();
	
	@NotBlank(message = "Por favor informar a quantidade!")
	private int quantidadePessoas;
	
	@NotBlank(message = "Por favor informar o nome do setor!")
	private String nome;
	
	@NotBlank(message = "Por favor informar o tipo do setor!")
	private String tipo;

	

	public Setores(int id, Set<Evento> eventos, List<Reserva> agendamento, int quantidadePessoas, String nome,
			String tipo) {
		
		super();
		this.id = id;
		this.eventos = eventos;
		this.agendamento = agendamento;
		this.quantidadePessoas = quantidadePessoas;
		this.nome = nome;
		this.tipo = tipo;
	}




}
