package com.api.blog.controller.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.service.comentario.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioRestController {

    @Autowired
    private IComentarioService comentarioService;

    @GetMapping
    public List<ComentarioEntity> findAll() {
        return comentarioService.findAllComments();
    }

    @GetMapping("/{id}")
    public ComentarioEntity findById(@PathVariable String id) {
        return comentarioService.findCommentById(id).orElse(null);
    }

    @PostMapping
    public ComentarioEntity save(@RequestBody ComentarioEntity comentario) {
        return comentarioService.saveComment(comentario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        comentarioService.deleteCommentById(id);
    }
}
