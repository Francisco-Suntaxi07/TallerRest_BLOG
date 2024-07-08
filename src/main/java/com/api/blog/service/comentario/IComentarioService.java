package com.api.blog.service.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IComentarioService {
    List<ComentarioEntity> findAllComentarios();
    Optional<ComentarioEntity> findComentarioById(String id);
    ComentarioEntity saveComentario(ComentarioEntity comentario);
    void deleteComentarioById(String id);
    List<ComentarioEntity> findComentariosByUserAndPostAndDate(String idUsuario, String idPost, LocalDate date);
}
