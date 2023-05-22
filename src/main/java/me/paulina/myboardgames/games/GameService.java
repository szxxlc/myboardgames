package me.paulina.myboardgames.games;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class GameService {
    List<Game> getGames(){
        return List.of(
                new Game(
                        1L,
                        "Carcassone",
                        2,
                        6,
                        8,
                        "medium"
                ),
                new Game(
                        2L,
                        "Ticket to Ride",
                        2,
                        5,
                        10,
                        "medium"
                )
        );
    }
}
