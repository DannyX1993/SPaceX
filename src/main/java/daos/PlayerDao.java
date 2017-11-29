package daos;

import entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by danielgonzalez on 28/11/17.
 */
public interface PlayerDao extends JpaRepository<Player, Integer> {
    @Override
    List<Player> findAll();
}
