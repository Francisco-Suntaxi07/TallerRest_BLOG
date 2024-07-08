package com.api.blog.service.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.model.repository.comentario.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Override
    public List<ComentarioEntity> findAllComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<ComentarioEntity> findComentarioById(String id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public ComentarioEntity saveComentario(ComentarioEntity comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteComentarioById(String id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<ComentarioEntity> findComentariosByUserAndPostAndDate(String idUsuario, String idPost, LocalDate date) {
        LocalDate startOfDay = date.atStartOfDay().toLocalDate();
        LocalDate endOfDay = date.plusDays(1).atStartOfDay().toLocalDate();
        return comentarioRepository.findByIdUsuarioAndIdPostAndFechaComentarioBetween(idUsuario, idPost, startOfDay, endOfDay);
    }
}
