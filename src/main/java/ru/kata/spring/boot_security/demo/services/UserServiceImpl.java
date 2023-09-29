package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleDAO;
import ru.kata.spring.boot_security.demo.repositories.UserDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private final RoleDAO roleDAO;

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public void update(Long id, User updatedUser) {
        Optional<User> userToBeUpdated = userDAO.findById(id);

        userToBeUpdated.get().setUsername(updatedUser.getUsername());
        userToBeUpdated.get().setEmail(updatedUser.getEmail());
        userToBeUpdated.get().setRoles(updatedUser.getRoles());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(getById(id));
    }
}
