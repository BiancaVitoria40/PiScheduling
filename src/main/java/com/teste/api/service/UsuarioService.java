package com.teste.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.teste.api.model.entidades.Cliente;
import com.teste.api.model.entidades.Usuario;
//import com.teste.api.model.repositorie.ClienteRepository;
import com.teste.api.model.repositorie.UsuarioRepository;

@Service
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;
	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Usuario adicionarUsuario(Usuario novoUsuario) {

		
		String econder = this.passwordEncoder.encode(novoUsuario.getSenha());
		
		novoUsuario.setSenha(econder);
		return usuarioRepository.save(novoUsuario);
	}
	
	public List<Usuario> listClient(){
		List<Usuario> list = usuarioRepository.findAll();
		return list;
		
	}

	public Usuario updateClient(Usuario client) {
		String encoder = this.passwordEncoder.encode(client.getSenha());
		client.setSenha(encoder);
		Usuario upClient = usuarioRepository.save(client);
		return upClient;
	}

	public Boolean deleteClient(Integer id) {
		usuarioRepository.deleteById(id);
		return true;

	}

//	public Boolean validarSenha(Usuario client) {
//
//		
//		Optional<Usuario> optionalCliente = usuarioRepository.findByEmail(client.getEmail());
//		
//		if (optionalCliente.isPresent()) {
//	        String senhaArmazenada = optionalCliente.get().getSenha();
//
//	        return passwordEncoder.matches(client.getSenha(), senhaArmazenada);
//	    } else {
//	        return false;
//	    }
//	
//	}

	public Usuario obterUsuarioPorId(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}

//		String senha = this.clienteRepository.getById(client.getId()).getSenha();
//Boolean valid = passwordEncoder.matches(client.getSenha(), senha);
//return valid;
