package com.api.blog.model.entity.comentario;

import com.api.blog.model.entity.post.PostEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMENTARIO")
public class ComentarioEntity {

    @Id
    @Column(name = "IDCOMENTARIO", length = 8, nullable = false)
    private String idComentario;

    @Column(name = "MENSAJECOMENTARIO", length = 255)
    private String mensajeComentario;

    @Column(name = "FECHACOMENTARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComentario;

    @ManyToOne
    @JoinColumn(name = "IDPOST")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private UsuarioEntity usuario;

}
