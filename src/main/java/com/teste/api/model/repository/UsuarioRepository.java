package com.teste.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.api.model.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByLogin(String email);

//	@Query("SELECT c FROM Cliente c WHERE c.email = :email")
//    Optional<Usuario> findByEmail(@Param("email") String email);
	
}