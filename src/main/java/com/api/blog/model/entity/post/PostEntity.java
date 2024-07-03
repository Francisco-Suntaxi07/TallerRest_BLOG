package com.api.blog.model.entity.post;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String idPost;

    @Column(name = "DESCRIPCIONPOST", length = 128)
    private String descripcionPost;

    @Column(name = "FECHACREACIONPOST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionPost;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "post")
    private List<ComentarioEntity> comentarios;

}
