package com.teste.api.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teste.api.model.dto.CarrinhoDTO;
import com.teste.api.model.dto.ItemCarrinhoDTO;
//import com.teste.api.model.entidades.Carrinho;
//import com.teste.api.model.repositorie.CarrinhoRepository;

//@Service
//public class CarrinhoService {
//
//	@Autowired
//	private CarrinhoRepository carrinhoRepository;
//
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	
//	public Carrinho adicionaCarrinhho(Carrinho carrinho) {
//
//		return carrinhoRepository.save(carrinho);
//	}
//
//	public Carrinho obterCarrinhoPorId(int long1) {
//		return carrinhoRepository.findById(long1).orElse(null);
//
//	}
//
//	public List<CarrinhoDTO> obterCarrinho() {
//
//		List<Carrinho> carrinhos = this.carrinhoRepository.findAll();
//
//		return carrinhos.stream() // cria um fluxo de carrinho
//				.map(carrinho -> modelMapper.map(carrinho, CarrinhoDTO.class)) // converte cada carrinho para um carrinhoDTO
//				.collect(Collectors.toList()); // coleta tds os carrinho em uma lista
//
//	}
//	
//	
//	public CarrinhoDTO obterCarrinhoPorId2(int id) {
//	Carrinho carrinho = this.carrinhoRepository.findById(id).orElse(null);
//	
//	return modelMapper.map(carrinho, CarrinhoDTO.class);
//		
//	}
//
//}
