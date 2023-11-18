package com.teste.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.model.dto.EventoFinalDTO;
import com.teste.api.model.entidades.Evento;
import com.teste.api.model.entidades.Setores;
import com.teste.api.model.repositorie.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepository; // injeção de dependencia

	@Autowired
	private SetorService setorService;

	@Autowired
	private ModelMapper modelMapper;
	
	

	public Evento criarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	public Evento atualizaEvento(Evento atualizaEvento) {

		Evento evento = buscaEventoPorId(atualizaEvento.getId());

		Set<Setores> setor = new HashSet<Setores>();
		for (Setores setorRequest : atualizaEvento.getSetores()) {
			Optional<Setores> setores = setorService.obetemSetorPorId(setorRequest.getId());
			setor.add(setores.get());
		}

		evento.getSetores().addAll(setor);

		return criarEvento(evento);

	}

	public List<EventoFinalDTO> dadosEvento() {

		List<Evento> eventos = this.eventoRepository.findAll();

		return eventos.stream() // cria um fluxo de evento
				.map(evento -> modelMapper.map(evento, EventoFinalDTO.class)) // converte cada evento para um eventoDTO
				.collect(Collectors.toList()); // coleta tds os eventos em uma lista

	}

	public EventoFinalDTO buscaPorId(int id) {

		Evento eventos = this.eventoRepository.findById(id).get();
		return modelMapper.map(eventos, EventoFinalDTO.class);

	}

	public Evento buscaEventoPorId(int id) {
		return eventoRepository.findById(id).get();

	}

	public Optional<Evento> buscaEventtoPorId(int id) {
		return eventoRepository.findById(id);

	}

}
