package com.api.blog.service.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.model.repository.comentario.IComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IComentarioService{

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Override
    public List<ComentarioEntity> findAllComments() {
        return (ArrayList<ComentarioEntity>) comentarioRepository.findAll();
    }

    @Override
    public Optional<ComentarioEntity> findCommentById(String id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public ComentarioEntity saveComment(ComentarioEntity comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Boolean deleteCommentById(String id) {
        if (comentarioRepository.existsById(id)){
            comentarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
