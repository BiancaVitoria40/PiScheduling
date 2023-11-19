package com.teste.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

