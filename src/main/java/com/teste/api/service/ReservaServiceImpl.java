package com.teste.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.api.model.entidades.Evento;
import com.teste.api.model.entidades.Ingresso;
import com.teste.api.model.entidades.Reserva;
import com.teste.api.model.entidades.Usuario;
import com.teste.api.model.repository.ReservaUpRepository;

@Service	
public class ReservaServiceImpl implements ReservaService {
	   
	
	  private ReservaUpRepository agendamentoRepository;

	  public ReservaServiceImpl(ReservaUpRepository agendamentoRepository) {
	      this.agendamentoRepository = agendamentoRepository;
	  }

	  @Override
	  public Reserva criarAgendamento(Usuario usuario, Evento evento, Ingresso ingresso) {
	     List<Ingresso> ingressos = new ArrayList<>();
	     ingressos.add(ingresso);
	     
	     Reserva agendamento = new Reserva();
	     agendamento.setUsuario(usuario);
	     agendamento.setEvento(evento);
	     agendamento.setIngressos(ingressos);
	     return agendamentoRepository.save(agendamento);
	  }

	  @Override
	  public Reserva atualizarAgendamento(int id, Usuario usuario, Evento evento, Ingresso ingresso) {
		  List<Ingresso> ingressos = new ArrayList<>();
		  ingressos.add(ingresso);
		  
	      Reserva agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
	      agendamento.setUsuario(usuario);
	      agendamento.setEvento(evento);
	      agendamento.setIngressos(ingressos);
	      return agendamentoRepository.save(agendamento);
	  }

	  @Override
	  public void excluirAgendamento(int id) {
		  
	      Reserva agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
	      agendamentoRepository.delete(agendamento);
	  }
	  
		@Override
		public List<Reserva> listarAgendamentos() {
			return agendamentoRepository.findAll();
		}

		@Override
		public Reserva recuperarAgendamento(int id) {
			return agendamentoRepository.findById(id).orElse(null);
	}
		
	 public void enviarMensagemConfirmacao(Usuario usuario, Reserva agendamento) {
		  String.format(
			       "Olá, %s! Seu agendamento para o ingresso foi confirmado. Seu código de agendamento é: %s. Por favor, guarde-o para uso futuro.",
			       usuario.getNome(),
			       agendamento.getCodigo()
			   );}
	}
