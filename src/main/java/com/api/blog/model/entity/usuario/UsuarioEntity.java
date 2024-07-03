package com.api.blog.model.entity.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @Column(name = "IDUSUARIO", length = 8, nullable = false)
    private String idUsuario;

    @Column(name = "NOMBREUSUARIO", length = 32)
    private String nombreUsuario;

    @Column(name = "EMAILUSUARIO", length = 32)
    private String emailUsuario;

}
