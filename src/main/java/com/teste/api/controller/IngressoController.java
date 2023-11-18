package com.teste.api.controller;

import java.util.List;
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
import com.teste.api.model.dto.IngressoDTO;
import com.teste.api.model.entidades.Ingresso;
import com.teste.api.service.IngressoService;

@RestController
@RequestMapping("/api/ingresso")
public class IngressoController {

	@Autowired
	private IngressoService ingressoService;

	@PostMapping
	public ResponseEntity<Ingresso> setIngresso(@RequestBody Ingresso novoIngresso) {
		Ingresso ingressoAdicionado = ingressoService.criaIngresso(novoIngresso);

		if (ingressoAdicionado.equals(null)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ingressoAdicionado);
	}

	@GetMapping
	public ResponseEntity<List<IngressoDTO>> getIngresso() {

		List<IngressoDTO> ingresso = ingressoService.listarIngressos();

		return new ResponseEntity<List<IngressoDTO>>(ingresso, HttpStatus.OK);
	}

	@GetMapping("/buscaPorID/{id}")
	public ResponseEntity<IngressoDTO> getProdutoPorID(@PathVariable int id) {
		IngressoDTO ingressoDTO = ingressoService.obterIngressoPorIdDTO(id);

		return new ResponseEntity<IngressoDTO>(ingressoDTO, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Ingresso> getAtualizaIngresso(@RequestBody Ingresso ingresso) {

		ingressoService.atualizaIngresso(ingresso);

		return new ResponseEntity<Ingresso>(ingresso, HttpStatus.OK);

	}

}
