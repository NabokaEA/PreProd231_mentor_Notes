package ru.nabokae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nabokae.entity.User;
import ru.nabokae.DAO.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repo;

    @Transactional
    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return repo.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return (List<User>) repo.findAll();
    }
    @Transactional
    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
