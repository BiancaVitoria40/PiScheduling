package com.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.exception.RepositoryNotInjectedException;
import com.teste.api.exception.ServiceNotInjectedException;
import com.teste.api.exception.UsuarioNotFoundException;
import com.teste.api.model.dto.AuthenticationDTO;
import com.teste.api.model.dto.CriarUsuarioDTO;
import com.teste.api.model.dto.LoginResponseDTO;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.model.repository.UsuarioRepository;
import com.teste.api.service.ItemCarrinhoService;
import com.teste.api.service.TokenService;
import com.teste.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuario")
public class UsuarioController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private final ItemCarrinhoService itemCarrinhoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TokenService tokenService;
	
	
	public UsuarioController(UsuarioService usuarioService, ItemCarrinhoService itemCarrinhoService) {
		super();
		this.usuarioService = usuarioService;
		this.itemCarrinhoService = itemCarrinhoService;
	}
	
    @PostMapping("/auth/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
       
            // Criação de token de autenticação
            var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
            
            // Autenticação do usuário
            Authentication auth = this.authenticationManager.authenticate(userNamePassword);

            // Se a autenticação for bem-sucedida, você pode realizar ações adicionais aqui
            
            var token = tokenService.gerarToken((Usuario)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        
    }
    
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid CriarUsuarioDTO data) {
        // Verifica se o e-mail já está em uso
        if (usuarioRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().body("E-mail já está em uso.");
        }
        // Criptografa a senha antes de armazenar
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        // Cria um novo usuário
        Usuario novoUsuario = new Usuario(data.login(), encryptedPassword);

        // Salva o novo usuário
        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok("Usuário criado com sucesso!");
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
