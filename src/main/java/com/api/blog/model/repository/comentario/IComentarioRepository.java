package com.api.blog.model.repository.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<ComentarioEntity, String> {
    List<ComentarioEntity> findByIdUsuarioAndIdPostAndFechaComentarioBetween(String idUsuario, String idPost, LocalDate start, LocalDate end);
}

