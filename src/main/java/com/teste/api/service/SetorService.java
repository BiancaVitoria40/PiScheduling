package com.teste.api.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.model.dto.SetorDTO;
import com.teste.api.model.entidades.Setores;
import com.teste.api.model.repositorie.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@SuppressWarnings("unused")
	private ServiceUtils serviceUtils;

	public Setores adicionaSetor(Setores setor) {
		setorRepository.save(setor);
		return setor;
	}

	public Optional<Setores> obetemSetorPorId(int id) {
		return setorRepository.findById(id);
	}

	public SetorDTO obtemSetorPorIdDTO(int id) {
		Setores setor = setorRepository.findById(id).get();
		
		return modelMapper.map(setor, SetorDTO.class);
	}

	public Optional<Setores> atulizaSetor(Setores setores) {
	
		return ServiceUtils.atualizarEntidade(setores.getId(), setores, setorRepository);
		
//	return obetemSetorPorId(setores.getId())
//	.map(setor -> {
//		BeanUtils.copyProperties(setores, setor, "id");
//		return Optional.ofNullable(setorRepository.save(setor));
//	})
//	.orElse(Optional.empty());
//		
	}

	
	
	
}
