package ru.nabokae.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nabokae.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
