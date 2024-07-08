package com.api.blog.controller.comentario;

import com.api.blog.model.entity.comentario.ComentarioEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.service.comentario.IComentarioService;
import com.api.blog.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/comentarios")
public class ComentarioRestController {

    @Autowired
    private IComentarioService comentarioService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<ComentarioEntity> getAllComentarios() {
        return comentarioService.findAllComentarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioEntity> getComentarioById(@PathVariable String id) {
        Optional<ComentarioEntity> comentario = comentarioService.findComentarioById(id);
        return comentario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<?> createComentario(@RequestBody ComentarioEntity comentario) {
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findUserById(comentario.getIdUsuario());
        if (optionalUsuario.isEmpty()) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        UsuarioEntity usuario = optionalUsuario.get();
        if (!"LECTOR".equals(usuario.getRole())) {
            return ResponseEntity.status(403).body("Solo los usuarios con rol de lector pueden agregar comentarios");
        }
        LocalDate today = LocalDate.now();
        List<ComentarioEntity> comentariosHoy = comentarioService.findComentariosByUserAndPostAndDate(comentario.getIdUsuario(), comentario.getIdPost(), today);
        if (comentariosHoy.size() >= 2) {
            return ResponseEntity.status(429).body("Has alcanzado el límite diario de comentarios para este post");
        }
        comentario.setFechaComentario(today);
        ComentarioEntity savedComentario = comentarioService.saveComentario(comentario);
        return ResponseEntity.ok(savedComentario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComentario(@PathVariable String id) {
        comentarioService.deleteComentarioById(id);
        return ResponseEntity.noContent().build();
    }
}
