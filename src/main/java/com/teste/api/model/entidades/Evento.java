package com.teste.api.model.entidades;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@OneToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	@NotBlank(message = "A inserção do nome do evento é obrigatória!")
	private String nomeDoEvento;
	
	@OneToMany(mappedBy = "evento")
	private List<Ingresso>ingressos;

	@ManyToMany
	@JoinTable(name = "evento_setor", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "setor_id"))
	private Set<Setores> setores = new HashSet<Setores>();

	@Lob
	private byte[] imagem;

	private String nome;
	private String descricao;
	private Date data;
	private String atracao;
	private int totalPessoas;

	public Evento() {

	}

	public Evento(Local local, Set<Setores> setores, byte[] imagem, String nome, String descricao, Date data,
			String atracao, int totalPessoas, String nomeDoEvento) {
		super();
		this.local = local;
		this.setores = setores;
		this.imagem = imagem;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.atracao = atracao;
		this.totalPessoas = totalPessoas;
	}




}
