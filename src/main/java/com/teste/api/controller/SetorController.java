package com.teste.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.model.dto.SetorDTO;
import com.teste.api.model.entidades.Setores;
import com.teste.api.service.SetorService;

@RestController
@RequestMapping("/api/setor")
public class SetorController {

	
	@Autowired
	private SetorService setorService;
	
	@PostMapping
	public ResponseEntity<Setores> adicionarEvento(@RequestBody Setores novoSetor) {
		Setores setorAdicionado = setorService.adicionaSetor(novoSetor);
		return ResponseEntity.status(HttpStatus.CREATED).body(setorAdicionado);

	}
	
	@GetMapping("buscaPorId/{id}")
	public ResponseEntity<SetorDTO> getSetorPorId(@PathVariable int id){
		SetorDTO setorDTO = setorService.obtemSetorPorIdDTO(id);
		
		return new ResponseEntity<SetorDTO>(setorDTO, HttpStatus.OK);	
	}
	
	@PutMapping
	public ResponseEntity<Setores> setAtualizaSetor(@RequestBody Setores setor) {
		
		setorService.atulizaSetor(setor);
		
		return new ResponseEntity<Setores>(setor, HttpStatus.OK);
	}
	
	
}
