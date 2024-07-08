package com.api.blog.model.entity.comentario;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "COMENTARIO")
public class ComentarioEntity {

    @Id
    @Column(name = "IDCOMENTARIO")
    private String idComentario;

    @Column(name = "IDPOST")
    private String idPost;

    @Column(name = "IDUSUARIO")
    private String idUsuario;

    @Column(name = "MENSAJECOMENTARIO")
    private String mensajeComentario;

    @Column(name = "FECHACOMENTARIO")
    private LocalDate fechaComentario;

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensajeComentario() {
        return mensajeComentario;
    }

    public void setMensajeComentario(String mensajeComentario) {
        this.mensajeComentario = mensajeComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
// Getters and setters
}
