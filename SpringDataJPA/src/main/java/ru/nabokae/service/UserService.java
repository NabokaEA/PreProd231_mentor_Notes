package ru.nabokae.service;

import ru.nabokae.entity.User;

public interface UserService {
    void save(User entity);

    User findById(Long id);

    Iterable<User> findAll();

    void delete(Long id);
}
