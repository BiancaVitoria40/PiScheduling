package com.teste.api.model.entidades;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "local_id")
	private Local local;

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
			String atracao, int totalPessoas) {
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

	public Set<Setores> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setores> setores) {
		this.setores = setores;
	}

	public int getTotalPessoas() {
		return totalPessoas;
	}

	public void setTotalPessoas(int totalPessoas) {
		this.totalPessoas = totalPessoas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAtracao() {
		return atracao;
	}

	public void setAtracao(String atracao) {
		this.atracao = atracao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}
