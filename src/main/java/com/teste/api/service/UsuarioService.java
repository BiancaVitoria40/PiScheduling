package com.teste.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teste.api.exception.RepositoryNotInjectedException;
import com.teste.api.exception.UsuarioNotFoundException;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.model.repository.UsuarioRepository;

@Service
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;
	

	
	public List<Usuario> listClient() throws RepositoryNotInjectedException{
  	  if (usuarioRepository == null) {
	      throw new RepositoryNotInjectedException("UsuarioRepository não existe!");
	  }
		List<Usuario> list = this.usuarioRepository.findAll();
		return list;
		
	}
	
	public Usuario criaUsuario(Usuario novoUsuario) {
		  Usuario usuario = new Usuario();
		  usuario.setNome(novoUsuario.getNome());
		  usuario.setCpf(novoUsuario.getCpf());
		  usuario.setLogin(novoUsuario.getLogin());
		  usuario.setSenha(novoUsuario.getSenha());
		  usuario.setTelefone(novoUsuario.getTelefone());
		  return usuarioRepository.save(usuario);
		
	}
	
	public boolean loginUsuario(String login, String senha) {
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario == null) {
			throw new UsuarioNotFoundException("Usuário não existe!");
		}else {
			return usuario.getSenha().equals(senha);
		}
	}

	public Usuario obterUsuarioPorId(Integer id) throws RepositoryNotInjectedException  {
		 if (usuarioRepository == null) {
		 throw new RepositoryNotInjectedException("UsuarioRepository não foi injetado");
		 }
		 return usuarioRepository.findById(id).orElse(null);
		}
	
    public Optional<Usuario> atualizaUsuario(Usuario atualizaUsuario) throws RepositoryNotInjectedException {
   	 
    	if (atualizaUsuario == null) {
    	     throw new UsuarioNotFoundException("Usuário fornecido é não existe");
    	 }
    	 if (usuarioRepository == null) {
    	     throw new RepositoryNotInjectedException("UsuárioRepository não foi injetado");
    	 }
    	 return ServiceUtils.atualizarEntidade(atualizaUsuario.getId(), atualizaUsuario, usuarioRepository);
    	 
    	}


}

