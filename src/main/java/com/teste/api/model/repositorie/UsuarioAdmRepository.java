package com.teste.api.model.repositorie;

import org.springframework.data.repository.CrudRepository;

import com.teste.api.model.entidades.Administrador;

public interface UsuarioAdmRepository extends CrudRepository<Administrador, Integer> {

}
