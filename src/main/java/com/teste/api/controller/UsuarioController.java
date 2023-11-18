package com.teste.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.api.model.dto.AuthenticationDTO;
import com.teste.api.model.dto.CriarUsuarioDTO;
import com.teste.api.model.dto.LoginResponseDTO;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.model.repositorie.UsuarioRepository;
import com.teste.api.service.ItemCarrinhoService;
import com.teste.api.service.TokenService;
import com.teste.api.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;
	
	@Autowired
	private final ItemCarrinhoService itemCarrinhoService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
            var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            
            // Autenticação do usuário
            Authentication auth = this.authenticationManager.authenticate(userNamePassword);

            // Se a autenticação for bem-sucedida, você pode realizar ações adicionais aqui
            
            var token = tokenService.gerarToken((Usuario)auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        
    }
    
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid CriarUsuarioDTO data) {
        // Verifica se o e-mail já está em uso
        if (usuarioRepository.findByLogin(data.email()) != null) {
            return ResponseEntity.badRequest().body("E-mail já está em uso.");
        }
        // Criptografa a senha antes de armazenar
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        // Cria um novo usuário
        Usuario novoUsuario = new Usuario(data.email(), encryptedPassword);

        // Salva o novo usuário
        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok("Usuário criado com sucesso.");
    }


}
