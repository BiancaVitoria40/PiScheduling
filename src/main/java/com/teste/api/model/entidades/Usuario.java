package com.teste.api.model.entidades;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
@Entity
public class Usuario implements UserDetails{
	
	
	@OneToMany(mappedBy = "usuario")
    private List<Reserva> itemCarrinho = new ArrayList<Reserva>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "A inserção do nome é obrigatória!")
	private String nome;
	
	@Email(message = "Insira um e-mail válido!")
	@NotBlank(message = "A inserção do e-mail é obrigatória!")
	private String login;
	
	@NotBlank(message =  "A inserção da senha é obrigatória!")
	private String senha;
    
	@CPF(message = "Insira um cpf válido!")
	@NotBlank(message =  "A inserção do CPF é obrigatória!")
	private String cpf;
	
	@NotBlank(message =  "A inserção do telefone é obrigatória!")
	@Pattern(regexp = "^\\([0-9]{2}\\) [0-9]{4}-[0-9]{4}$", message = "Número de telefone inválido")
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
