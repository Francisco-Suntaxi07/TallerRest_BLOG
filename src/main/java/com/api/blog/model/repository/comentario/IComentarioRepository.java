package com.api.blog.model.repository.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends CrudRepository<ComentarioEntity, String> {
}
