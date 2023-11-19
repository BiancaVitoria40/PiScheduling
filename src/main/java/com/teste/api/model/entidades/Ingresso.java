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
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
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
	
	@ManyToMany(mappedBy = "ingressos")
	private Set<ItemCarrinho> itemCarrinho = new HashSet<ItemCarrinho>();
    
	@NotBlank(message = "Por favor inserir o nome!")
	private String nome;
    
	@NotBlank(message = "Por favor inserir o valor do ingresso!")
	private double valor;
    
	@NotBlank(message = "Por favor o tipo do ingresso!")
	private String tipoIngresso;
    
	private String status;
    
	public Ingresso() {

	}

	public Ingresso(Evento evento, Setores setor, Set<ItemCarrinho> reserva, String nome, double valor, String tipoIngresso,
			String status) {
		super();
		this.evento = evento;
		this.setor = setor;
		this.itemCarrinho = reserva;
		this.nome = nome;
		this.valor = valor;
		this.tipoIngresso = tipoIngresso;
		this.status = status;
	}







	



	
	
}
