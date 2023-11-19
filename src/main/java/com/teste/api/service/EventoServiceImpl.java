package com.teste.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.exception.EventoNotFoundException;
import com.teste.api.exception.RepositoryNotInjectedException;
import com.teste.api.model.dto.EventoFinalDTO;
import com.teste.api.model.entidades.Evento;
import com.teste.api.model.entidades.Setores;
import com.teste.api.model.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository; // injeção de dependencia

	@Autowired
	private SetorService setorService;

	@Autowired
	private ModelMapper modelMapper;
	

	public Evento criarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	@Override
	public Evento recuperarEvento(int id) {
		Optional<Evento> optionalEvento = eventoRepository.findById(id);
		
		if (optionalEvento.isPresent()) {
			return optionalEvento.get();
		} else {
			throw new EventoNotFoundException("Evento com id " + id + " não encontrado");
		}
	}
	


	public Evento atualizaEvento(Evento atualizaEvento) throws RepositoryNotInjectedException {

		Evento evento = recuperarEvento(atualizaEvento.getId());
		
		if (evento == null) {
		    throw new EventoNotFoundException("Evento com id " + atualizaEvento.getId() + " não encontrado");
	     }

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

		   if (eventos.isEmpty()) {
		       throw new EventoNotFoundException("Nenhum evento encontrado");
		   }
		   return eventos.stream() // cria um fluxo de evento
		           .map(evento -> modelMapper.map(evento, EventoFinalDTO.class)) // converte cada evento para um eventoDTO
		           .collect(Collectors.toList()); // coleta tds os eventos em uma lista
		}


}
