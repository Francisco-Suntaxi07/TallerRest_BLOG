package com.api.blog.model.entity.usuario;

import com.api.blog.model.entity.rol.RolEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RolEntity.class)
    @JoinTable(name = "USUARIO_ROL", joinColumns = @JoinColumn(name = "IDUSUARIO"), inverseJoinColumns = @JoinColumn(name = "IDROL"))
    private Set<RolEntity> roles;
}
