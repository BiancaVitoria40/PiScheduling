package com.teste.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.api.model.entidades.Reserva;
import com.teste.api.model.entidades.Evento;
import com.teste.api.model.entidades.Ingresso;
import com.teste.api.model.entidades.Usuario;

@Service
public interface ReservaService {
	
	   Reserva criarAgendamento(Usuario usuario, Evento evento, Ingresso ingresso);
	   Reserva atualizarAgendamento(int id, Usuario usuario, Evento evento, Ingresso ingresso);
	   void excluirAgendamento(int id);
	   
	   List<Reserva> listarAgendamentos();
	   Reserva recuperarAgendamento(int id);

}
