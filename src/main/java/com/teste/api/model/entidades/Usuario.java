package com.teste.api.model.entidades;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
@Entity
public class Usuario implements UserDetails{
	
	
	@OneToMany(mappedBy = "usuario")
    private List<ItemCarrinho> itemCarrinho = new ArrayList<ItemCarrinho>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;
	
	//@Email(message = "Insira um e-mail válido!")
	//@NotBlank(message = "Informe um e-mail!")
	private String login;
	
	//@NotBlank(message =  "A senha é obrigatória!")
	//@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;
		
	private String cpf;
	
	private String telefone;
	
	
	
	public Usuario() {
		super();
		
	}
	public Usuario(int id, String nome, String login, String senha, String cpf, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		
		 return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getUsername() {
	   return this.login;
	}

	@Override
	public String getPassword() {
	   return this.senha;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return false;
	}
	
	
	
	
	
}
