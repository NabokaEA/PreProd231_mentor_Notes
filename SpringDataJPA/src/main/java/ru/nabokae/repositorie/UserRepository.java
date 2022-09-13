package ru.nabokae.repositorie;

import org.springframework.data.repository.CrudRepository;
import ru.nabokae.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
