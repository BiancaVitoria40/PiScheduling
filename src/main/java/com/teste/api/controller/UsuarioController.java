package com.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.api.exception.InvalidCredentialsException;
import com.teste.api.exception.NomeIngressoSetorInvalidoException;
import com.teste.api.exception.RepositoryNotInjectedException;
import com.teste.api.exception.ServiceNotInjectedException;
import com.teste.api.exception.SetorNotFoundException;
import com.teste.api.exception.UsuarioNotFoundException;
import com.teste.api.model.dto.AuthenticationDTO;
import com.teste.api.model.dto.CriarUsuarioDTO;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.model.repository.UsuarioRepository;
import com.teste.api.service.ItemCarrinhoService;
import com.teste.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {


	@Autowired
	private final ItemCarrinhoService itemCarrinhoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public UsuarioController(UsuarioService usuarioService, ItemCarrinhoService itemCarrinhoService) {
		super();
		this.usuarioService = usuarioService;
		this.itemCarrinhoService = itemCarrinhoService;
	}
	
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
      
            boolean loginUsuario = usuarioService.loginUsuario(data.login(), data.senha());
            if(!loginUsuario) {
            	throw new InvalidCredentialsException("Usuário não encontrado: " + loginUsuario);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Login realizado!");
            }
    }
    
    @PostMapping("/criarUsuario")
	public ResponseEntity<String> criaUsuario(@RequestBody @Valid CriarUsuarioDTO data) throws NomeIngressoSetorInvalidoException {
		  if (usuarioRepository.findByLogin(data.getLogin()) != null) {
	            return ResponseEntity.badRequest().body("E-mail já está em uso.");
	        }
		 
		  String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
		  Usuario novoUsuario = new Usuario(0, data.getLogin(), encryptedPassword, data.getNome(), data.getCpf(), data.getTelefone());
		  usuarioRepository.save(novoUsuario);
		  
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	}
    
	@GetMapping("/buscaPorID/{id}")
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable int id) throws ServiceNotInjectedException, RepositoryNotInjectedException {
	 Usuario usuarioId = usuarioService.obterUsuarioPorId(id);
	 
	 if (usuarioId == null) {
		 throw new UsuarioNotFoundException("Usuario não existe!");
	 } else {
	    return ResponseEntity.ok(usuarioId);
	 }
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getListUsuario() throws RepositoryNotInjectedException {
	 List<Usuario> usuarios = usuarioService.listClient();
	 return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	
	}
	
	@PutMapping
	public ResponseEntity<Usuario> getAtualizaUsuario(@RequestBody Usuario usuario) throws  RepositoryNotInjectedException {
		usuarioService.atualizaUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

}
