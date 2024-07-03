package com.api.blog.service.usuario;

import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.model.repository.usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAllUsers() {
        return (ArrayList<UsuarioEntity>) usuarioRepository.findAll();
    }

    @Override
    public Optional<UsuarioEntity> findUserById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public UsuarioEntity saveUser(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Boolean deleteUserById(String id) {
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
