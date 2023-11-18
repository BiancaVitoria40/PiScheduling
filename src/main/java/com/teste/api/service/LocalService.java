package com.teste.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.model.dto.LocalDTO;
import com.teste.api.model.entidades.Local;
import com.teste.api.model.repositorie.LocalRepository;

@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@SuppressWarnings("unused")
	private ServiceUtils serviceUtils;

	public Local adicionaLocal(Local local) {
		return localRepository.save(local);
	}
	
	public Optional<Local> atualizaLocal(Local atualizaLocal) {// estudar mais sobre função lambda
		
		return ServiceUtils.atualizarEntidade(atualizaLocal.getId(), atualizaLocal, localRepository);

		
//		 return buscaLocalPorID(atualizaLocal.getId())
//				 .map(local -> {    
//	                    BeanUtils.copyProperties(atualizaLocal, local, "id");
//	                    return Optional.ofNullable(localRepository.save(local));
//	                })
//	                .orElse(Optional.empty());
				
	}
	
	
	public LocalDTO buscarLocalPorIdDTO(int id) {
		
		Local local = localRepository.findById(id).get();
		
		return modelMapper.map(local, LocalDTO.class);
		
	}
	
	public Optional<Local> buscaLocalPorID(int id) {
		return localRepository.findById(id);
	
	}
	
	public List<LocalDTO> bucarLocal() {
		
		List<Local> locais =  this.localRepository.findAll();
		
		return locais.stream()
				.map(local -> modelMapper.map(local, LocalDTO.class))
				.collect(Collectors.toList());
	}

}
