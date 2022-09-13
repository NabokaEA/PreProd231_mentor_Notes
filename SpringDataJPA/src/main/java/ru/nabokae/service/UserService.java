package ru.nabokae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nabokae.entity.User;
import ru.nabokae.DAO.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository repo;

    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
