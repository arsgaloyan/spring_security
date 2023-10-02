package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;


public interface RoleService {
    Role save(Role entity);

    Role findById(Long id);

    List<Role> getAllRoles();
}
