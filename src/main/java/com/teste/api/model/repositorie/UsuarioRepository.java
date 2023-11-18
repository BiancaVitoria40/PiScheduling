package com.teste.api.model.repositorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.teste.api.model.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByLogin(String email);

//	@Query("SELECT c FROM Cliente c WHERE c.email = :email")
//    Optional<Usuario> findByEmail(@Param("email") String email);
	
}
