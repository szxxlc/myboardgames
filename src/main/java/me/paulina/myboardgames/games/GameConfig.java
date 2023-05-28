package me.paulina.myboardgames.games;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameConfig {

    @Bean
    CommandLineRunner commandLineRunner(GameRepository gameRepository) {
        return args -> {
            Game carcassonne = new Game(
                    "Carcassonne",
                    2,
                    6,
                    7,
                    "Medium"
            );
            Game ticketToRide = new Game(
                    "Ticket to ride",
                    2,
                    5,
                    8,
                    "Medium"
            );
            Game ageOfSteam = new Game(
                    "Age of Steam",
                    1,
                    6,
                    13,
                    "Long"
            );
            gameRepository.saveAll(
                    List.of(carcassonne, ticketToRide, ageOfSteam)
            );

        };
    }
}
