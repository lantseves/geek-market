package com.geekbrains.geekmarket.services;

import com.geekbrains.geekmarket.entities.Role;
import com.geekbrains.geekmarket.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findOneByName(roleName);
    }

    public void addRole(Role role) {
        role.setName("ROLE_" + role.getName().toUpperCase());
        roleRepository.save(role) ;
    }
}

