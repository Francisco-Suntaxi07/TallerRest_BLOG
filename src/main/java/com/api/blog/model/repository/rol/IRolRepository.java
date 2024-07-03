package com.api.blog.model.repository.rol;

import com.api.blog.model.entity.rol.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends CrudRepository<RolEntity,String> {

    Optional<RolEntity> findByNombreRol(String name);
}
