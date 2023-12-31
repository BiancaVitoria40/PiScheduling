package com.teste.api.model.entidades;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	@JoinTable(name = "reserva_ingresso", joinColumns = @JoinColumn(name = "reserva_id"), inverseJoinColumns = @JoinColumn(name = "ingresso_id"))
	private Set<Ingresso> ingressos = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private int quantidadeIngresso;

	private LocalDateTime dataCriacao;

	public ItemCarrinho() {

	}

	public ItemCarrinho(Set<Ingresso> ingressos, Pedido pedido, Usuario usuario, Setores setor,
			int quantidadeReserva, LocalDateTime dataCriacao) {
		super();
		this.ingressos = ingressos;
		this.quantidadeIngresso = quantidadeReserva;
		this.dataCriacao = dataCriacao;
	}

	public boolean contemIngresso(Ingresso ingresso) {
		return this.ingressos.contains(ingresso);
	}

	public ItemCarrinho(Usuario usuario) {
		this.usuario = usuario;
	}

	
	

	

}


