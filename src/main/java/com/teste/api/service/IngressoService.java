package com.teste.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.model.dto.IngressoDTO;
import com.teste.api.model.entidades.Ingresso;
import com.teste.api.model.entidades.Setores;
import com.teste.api.model.repositorie.IngressoRepository;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository ingressoRepository;

	@Autowired
	private SetorService setorService;

	@Autowired
	private ModelMapper modelMApper;

	@SuppressWarnings("unused")
	private ServiceUtils serviceUtils;

	public Ingresso criaIngresso(Ingresso ingresso) {

		Optional<Setores> setor = setorService.obetemSetorPorId(ingresso.getSetor().getId());

		if (ingresso.getNome().equalsIgnoreCase(setor.get().getNome())) { // erro esta chegando aqui testado na hora do															// almoço
			return ingressoRepository.save(ingresso);
		
		} else {
			return null;
		}
	}

	public IngressoDTO obterIngressoPorIdDTO(int id) {

		Ingresso ingresso = ingressoRepository.findById(id).get();

		return modelMApper.map(ingresso, IngressoDTO.class);
	}

	public List<IngressoDTO> listarIngressos() {

		List<Ingresso> ingressos = this.ingressoRepository.findAll();

		return ingressos.stream().map(ingresso -> modelMApper.map(ingresso, IngressoDTO.class))
				.collect(Collectors.toList());

	}

	public Optional<Ingresso> obterIngressoPorId(int id) {
		return ingressoRepository.findById(id);
	}

	public Optional<Ingresso> atualizaIngresso(Ingresso atualizaIngresso) {

		return ServiceUtils.atualizarEntidade(atualizaIngresso.getId(), atualizaIngresso, ingressoRepository);

//		return obterIngressoPorId(atualizaIngresso.getId()).map(ingresso -> {
//			BeanUtils.copyProperties(atualizaIngresso, ingresso, "id");
//			return Optional.of(ingressoRepository.save(ingresso));
//
//		}).orElse(Optional.empty());
//
	}

}
