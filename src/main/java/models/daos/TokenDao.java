package models.daos;

import models.entities.Token;
import models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Token, Integer>{

    Token findByUser(User user);

}
