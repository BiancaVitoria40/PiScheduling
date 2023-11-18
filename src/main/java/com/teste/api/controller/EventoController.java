package com.teste.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.teste.api.model.dto.EventoFinalDTO;
import com.teste.api.model.entidades.Evento;
import com.teste.api.service.EventoService;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;


	@GetMapping(value = "buscaEvento")
	public ResponseEntity<List<EventoFinalDTO>> getEvento() {

		List<EventoFinalDTO> eventoDto = eventoService.dadosEvento();

		return new ResponseEntity<List<EventoFinalDTO>>(eventoDto, HttpStatus.OK);
	}

	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<EventoFinalDTO> getEventoPorId(@PathVariable int id) {

		EventoFinalDTO eventoDto = eventoService.buscaPorId(id);

		return new ResponseEntity<EventoFinalDTO>(eventoDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Evento> setEvento(@RequestPart Evento novoEvento, @RequestPart MultipartFile imagem) {

		try {
			novoEvento.setImagem(imagem.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		Evento eventoAdicionado = eventoService.criarEvento(novoEvento);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoAdicionado);
	}

	@PutMapping("/setor")
	public ResponseEntity<Evento> setAtualizaEvento(@RequestPart Evento atualizaEvento) {

		eventoService.atualizaEvento(atualizaEvento);

		return ResponseEntity.status(HttpStatus.CREATED).body(atualizaEvento);

	}

}

//private EventoInicialDTO eventoTeste(Evento evento) {
//return modelMapper.map(evento, EventoInicialDTO.class);
//
//}
//
//
//@GetMapping
//public List<EventoInicialDTO> listarTodos(){
//return eventoRepository.findAll()
//		.stream()
//		.map(this:: eventoTeste)
//		.collect(Collectors.toList());
//}
