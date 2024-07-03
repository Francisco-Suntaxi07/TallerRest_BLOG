package com.api.blog.service.rol;

import com.api.blog.model.entity.rol.RolEntity;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    public List<RolEntity> findAllRoles();

    public Optional<RolEntity> findRoleById(String id);

    public RolEntity saveRole(RolEntity rol);

    public Boolean deteleRoleById(String id);

}
