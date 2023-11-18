package com.teste.api.model.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.teste.api.model.entidades.Local;

public interface LocalRepository extends JpaRepository<Local, Integer> {

}
