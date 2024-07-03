package com.api.blog.controller.usuario;

import com.api.blog.model.entity.rol.RolEntity;
import com.api.blog.model.entity.usuario.CreateUsuarioDto;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.service.rol.IRolService;
import com.api.blog.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolService rolService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> findAllUsers(){
        return ResponseEntity.ok().body(usuarioService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioEntity>> findUserById(@PathVariable String id){
        return ResponseEntity.ok().body(usuarioService.findUserById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody CreateUsuarioDto usuarioDto){
        Set<RolEntity> roles = usuarioDto.getRoles().stream()
                .map(role -> rolService.findRoleByName(role)
                        .orElse(null))
                .collect(Collectors.toSet());

        UsuarioEntity userEntity = UsuarioEntity.builder()
                .idUsuario(usuarioDto.getIdUsuario())
                .nombreUsuario(usuarioDto.getNombreUsuario())
                .emailUsuario(usuarioDto.getEmailUsuario())
                .roles(roles)
                .build();

        UsuarioEntity response = usuarioService.saveUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
