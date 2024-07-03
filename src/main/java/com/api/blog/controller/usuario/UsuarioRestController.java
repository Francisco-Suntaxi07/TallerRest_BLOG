package com.api.blog.controller.usuario;

import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.service.usuario.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> findAllUsers(){
        return ResponseEntity.ok().body(usuarioService.findAllUsers());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<UsuarioEntity>> findUserById(@PathVariable String id){
        return ResponseEntity.ok().body(usuarioService.findUserById(id));
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Optional<UsuarioEntity>> findUserByName(@PathVariable String name){
        return ResponseEntity.ok().body(usuarioService.findUserByName(name));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioEntity user, BindingResult result){
        if(result.hasErrors()){
            return this.validate(result);
        }
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


    private ResponseEntity<?> validate(BindingResult result) {
        List<Map<String, Object>> errors = new ArrayList<>();

        for (FieldError error : result.getFieldErrors()) {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("Campo", error.getField());
            errorMap.put("Mensaje", error.getDefaultMessage());
            errors.add(errorMap);
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
