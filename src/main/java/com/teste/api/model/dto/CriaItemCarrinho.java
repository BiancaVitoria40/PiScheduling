package com.teste.api.model.dto;

import com.teste.api.model.entidades.Reserva;
import com.teste.api.model.entidades.Ingresso;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CriaItemCarrinho {

	private Reserva agendamento;
    private Ingresso ingresso;

    	
	
}
