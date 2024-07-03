package com.api.blog.service.rol;

import com.api.blog.model.entity.rol.RolEntity;
import com.api.blog.model.repository.rol.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService{

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<RolEntity> findAllRoles() {
        return (ArrayList<RolEntity>) rolRepository.findAll();
    }

    @Override
    public Optional<RolEntity> findRoleById(String id) {
        return rolRepository.findById(id);
    }

    @Override
    public RolEntity saveRole(RolEntity rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Boolean deteleRoleById(String id) {
        if (rolRepository.existsById(id)){
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<RolEntity> findRoleByName(String name){
        return rolRepository.findByNOMBREROL(name);
    }

}
