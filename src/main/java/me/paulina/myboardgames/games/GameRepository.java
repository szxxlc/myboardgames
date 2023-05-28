package me.paulina.myboardgames.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    Optional<Game> findGameByNameOfGame(String nameOfGame);

}
