package com.api.blog.service.usuario;

import com.api.blog.model.entity.usuario.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<UsuarioEntity> findAllUsers();

    public Optional<UsuarioEntity> findUserById(String id);

    public UsuarioEntity saveUser(UsuarioEntity usuario);

    public Boolean deleteUserById(String id);

}
