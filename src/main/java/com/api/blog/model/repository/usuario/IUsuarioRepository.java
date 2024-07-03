package com.api.blog.model.repository.usuario;

import com.api.blog.model.entity.usuario.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity,String> {
}
