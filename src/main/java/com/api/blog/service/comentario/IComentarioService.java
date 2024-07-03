package com.api.blog.service.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;

import java.util.List;
import java.util.Optional;

public interface IComentarioService {

    public List<ComentarioEntity> findAllComments();

    public Optional<ComentarioEntity> findCommentById(String id);

    public ComentarioEntity saveComment(ComentarioEntity comentario);

    public Boolean deleteCommentById(String id);

}
