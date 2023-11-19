package com.teste.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.api.model.entidades.Reserva;
import com.teste.api.model.entidades.Evento;
import com.teste.api.model.entidades.Ingresso;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.service.ReservaServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ReservaController {
	
	@Autowired
	private ReservaServiceImpl agendamentoService;
    
	@PostMapping("/criarAgendamentos")
	public ResponseEntity<String> criarAgendamento(@Valid @RequestBody Reserva agendamento) {
		
		Usuario usuario = agendamento.getUsuario();
		Evento evento = agendamento.getEvento();
		Ingresso ingresso = (Ingresso) agendamento.getIngressos();
		
		Reserva reservaCriada = agendamentoService.criarAgendamento(usuario, evento, ingresso);
		
		if (reservaCriada == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao realizar agendamento!");
		} else {
			return ResponseEntity.ok("Agendamento concluído com sucesso!");
		}
	   
	}
	
	@PutMapping("/agendamentos/{id}")
	public  ResponseEntity<String> atualizarAgendamento(@Valid @PathVariable int id, @RequestBody Reserva agendamento) {
		
		Usuario usuario = agendamento.getUsuario();
		Evento evento = agendamento.getEvento();
		Ingresso ingresso = (Ingresso) agendamento.getIngressos();
		
		Reserva atualizarAgendamento =  agendamentoService.atualizarAgendamento(id, usuario, evento, ingresso);
		
		if (atualizarAgendamento == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o agendamento!");
		} else {
			return ResponseEntity.ok("Atualização feita com sucesso!");
		}
	   
	}
	
	@GetMapping("/listAgendamentos")
	public List<Reserva> listarAgendamentos() {
		return agendamentoService.listarAgendamentos();
	  }

	@GetMapping("/buscaPorId/{id}")
	public ResponseEntity<String> buscarAgendamento(@PathVariable int id) {
		Reserva agendamento = agendamentoService.recuperarAgendamento(id);
		
		if (agendamento == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado!");
		} else {
			return ResponseEntity.ok("Agendamento encontrado.");
		}
	}
	
	@DeleteMapping("/cancelar{id}")
     public ResponseEntity<String> cancelarAgendamento(@PathVariable int id) {
	       try {
	           agendamentoService.excluirAgendamento(id);
	           return ResponseEntity.ok("Reserva cancelada!");
	       } catch (RuntimeException e) {
	           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	       }
	   }
	



}
