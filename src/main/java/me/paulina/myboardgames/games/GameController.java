package me.paulina.myboardgames.games;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/game")
public class GameController {
    @PostMapping("/")
    public void registerNewGame(@RequestBody Game game){
        gameService.addNewGame(game);
    }
        
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/")
    public List<Game> getGames(){
        return gameService.getGames();
    }

    @DeleteMapping(path = "/{gameId}")
    public void deleteGame(@PathVariable("gameId") Long gameId) {
        gameService.deleteGame(gameId);
    }

    @PutMapping(path = "/{gameId}")
    public void updateGame(
            @PathVariable("gameId") Long gameId,
            @RequestParam(required = false) String nameOfGame,
            @RequestParam(required = false) Integer minNumberOfPeople,
            @RequestParam(required = false) Integer maxNumberOfPeople,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) String gameLength){
        gameService.updateGame(gameId, nameOfGame, minNumberOfPeople, maxNumberOfPeople, minAge, gameLength);
    }

}
