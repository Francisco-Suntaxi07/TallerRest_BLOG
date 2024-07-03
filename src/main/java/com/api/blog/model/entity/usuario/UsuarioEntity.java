package com.api.blog.model.entity.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @NotBlank
    @Size(max = 8)
    @Column(name = "IDUSUARIO", length = 8, nullable = false)
    private String id;

    @NotBlank
    @Size(max = 32)
    @Column(name = "NOMBREUSUARIO", length = 32)
    private String name;

    @NotBlank
    @Email
    @Size(max = 32)
    @Column(name = "EMAILUSUARIO", length = 32)
    private String email;

    @NotBlank
    @Size(max = 16)
    @Column(name = "ROLUSUARIO", length = 16)
    private String role;

}
