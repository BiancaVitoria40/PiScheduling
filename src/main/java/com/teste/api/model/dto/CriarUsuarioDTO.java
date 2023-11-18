package com.teste.api.model.dto;

import com.teste.api.model.entidades.UserRole;

public record CriarUsuarioDTO(String email, String senha, UserRole role) {

}
