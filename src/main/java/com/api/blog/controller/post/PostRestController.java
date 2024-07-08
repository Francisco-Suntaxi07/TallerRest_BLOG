package com.api.blog.controller.post;

import com.api.blog.model.entity.post.PostEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.service.post.IPostService;
import com.api.blog.service.usuario.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    private IPostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<PostEntity>> findAllPost() {
        return ResponseEntity.ok().body(postService.findAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostEntity>> findPostById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findPostById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePost(@RequestBody PostEntity post) {
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findUserById(post.getIdUsuario());
        if (optionalUsuario.isPresent()) {
            UsuarioEntity usuario = optionalUsuario.get();
            if (!usuario.getRole().equalsIgnoreCase("AUTOR")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tienes permiso para agregar nuevos posts.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + post.getIdUsuario());
        }
        PostEntity newPost;
        try {
            newPost = postService.savePost(post);
            logger.info("Se creó el post");
        } catch (Exception e) {
            logger.error("Error al registrar: " + e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Error al registrar: " + e.getMessage());
        }

        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{postId}/{userId}")
    public ResponseEntity<?> deletePostById(@PathVariable String postId, @PathVariable String userId) {
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findUserById(userId);
        if (optionalUsuario.isPresent()) {
            UsuarioEntity usuario = optionalUsuario.get();

            if (!usuario.getRole().equalsIgnoreCase("ADMIN")) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tienes permiso para eliminar posts.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + userId);
        }
        try {
            postService.deletePostById(postId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el post: " + e.getMessage());
        }
    }


}
