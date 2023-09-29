package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    User getById(Long id);

    void update(Long id, User updatedUser);

    void delete(Long id);

}
