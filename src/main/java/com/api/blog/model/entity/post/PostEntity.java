
package com.api.blog.model.entity.post;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "POST")
public class PostEntity {

    @Id
    @Column(name = "IDPOST", length = 8, nullable = false)
    @NotBlank
    private String idPost;

    @Column(name = "IDUSUARIO")
    @NotBlank
    private String idUsuario;

    @Column(name = "DESCRIPCIONPOST", length = 128)
    @NotBlank
    private String descripcionPost;

    @Column(name = "FECHACREACIONPOST")
    private LocalDate fechaCreacionPost;




}
