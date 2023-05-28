package me.paulina.myboardgames.games;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    List<Game> getGames(){
        return gameRepository.findAll();
    }

    public void addNewGame(Game game) {
        System.out.println(game);
        Optional<Game> gameOptional = gameRepository.findGameByNameOfGame(game.getNameOfGame());
        if (gameOptional.isPresent()) {
            throw new IllegalStateException("Game with given name already exists");
        }
        if (!(game.getGameLength().equals("Short") || game.getGameLength().equals("Medium") || game.getGameLength().equals("Long"))) {
            throw new IllegalStateException("Game length must be Short, Medium or Long");
        }
        if (game.getMaxNumberOfPeople()<game.getMinNumberOfPeople()) {
            throw new IllegalStateException("The max number of people can't be less than min number of people");
        }
        gameRepository.save(game);
    }


    public void deleteGame(Long gameId) {
        boolean exists = gameRepository.existsById(gameId);

        if (!exists) {
            throw new IllegalStateException("Game with Id number " + gameId + " does not exist!");
        } else {
            gameRepository.deleteById(gameId);
        }
    }

    @Transactional
    public void updateGame(Long gameId, String nameOfGame, Integer minNumberOfPeople, Integer maxNumberOfPeople, Integer minAge, String gameLength) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalStateException(
                        "Game with id " + gameId + " does not exists"
                ));

        if (nameOfGame != null && nameOfGame.length() > 0 && !Objects.equals(game.getNameOfGame(), nameOfGame)) {
            Optional<Game> gameOptional = gameRepository.findGameByNameOfGame(nameOfGame);
            if (gameOptional.isPresent()) {
                throw new IllegalStateException("Game with given name already exists");
            }
            game.setNameOfGame(nameOfGame);
        }

        if (minNumberOfPeople != null && minNumberOfPeople > 0 && !Objects.equals(game.getMinNumberOfPeople(), minNumberOfPeople)){
            game.setMinNumberOfPeople(minNumberOfPeople);
        }

        if (maxNumberOfPeople != null && maxNumberOfPeople > 0 && !Objects.equals(game.getMaxNumberOfPeople(), maxNumberOfPeople)){
            if (maxNumberOfPeople<game.getMinNumberOfPeople()){
                throw new IllegalStateException("The max number of people can't be less than min number of people");
            }
            game.setMaxNumberOfPeople(maxNumberOfPeople);
        }

        if (minAge != null && minAge > 0 && !Objects.equals(game.getMinAge(), minAge)){
            game.setMinAge(minAge);
        }

        if (gameLength != null && gameLength.length() > 0 && !Objects.equals(game.getGameLength(), gameLength)) {
            if (!(gameLength.equals("Short") || gameLength.equals("Medium") || gameLength.equals("Long"))) {
                throw new IllegalStateException("Game length must be Short, Medium or Long");
            }
            game.setGameLength(gameLength);
        }
    }
}
