package com.api.blog.model.entity.usuario;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuarioDto {

    private String idUsuario;

    private String nombreUsuario;

    private String emailUsuario;

    private Set<String> roles;

}
