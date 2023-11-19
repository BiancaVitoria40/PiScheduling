package com.teste.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.api.model.entidades.Reserva;

public interface ReservaUpRepository extends JpaRepository<Reserva, Integer>{
	
}