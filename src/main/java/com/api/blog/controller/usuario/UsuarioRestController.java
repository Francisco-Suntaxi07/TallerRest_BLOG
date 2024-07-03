package com.api.blog.controller.usuario;

import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> findAllUsers(){
        return ResponseEntity.ok().body(usuarioService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioEntity>> findUserById(@PathVariable String id){
        return ResponseEntity.ok().body(usuarioService.findUserById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UsuarioEntity user){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable String id){
        boolean isDeleted = usuarioService.deleteUserById(id);
        if(isDeleted){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
