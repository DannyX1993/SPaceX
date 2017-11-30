package models.daos;

import models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    @Override
    List<User> findAll();

    List<User> findByNickname(String nick);
}
