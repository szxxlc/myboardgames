package me.paulina.myboardgames.games;

public class Game {

    private Long id;
    private String nameOfGame;
    private Integer minNumberOfPeople;
    private Integer maxNumberOfPeople;
    private Integer minAge;
    private String gameLength;

    public Game(){

    }
    public Game(Long id, String nameOfGame, Integer minNumberOfPeople, Integer maxNumberOfPeople, Integer minAge, String gameLength) {
        this.id = id;
        this.nameOfGame = nameOfGame;
        this.minNumberOfPeople = minNumberOfPeople;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.minAge = minAge;
        this.gameLength = gameLength;
    }
    public Game(String nameOfGame, Integer minNumberOfPeople, Integer maxNumberOfPeople, Integer minAge, String gameLength) {
        this.nameOfGame = nameOfGame;
        this.minNumberOfPeople = minNumberOfPeople;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.minAge = minAge;
        this.gameLength = gameLength;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    public Integer getMinNumberOfPeople() {
        return minNumberOfPeople;
    }

    public void setMinNumberOfPeople(Integer minNumberOfPeople) {
        this.minNumberOfPeople = minNumberOfPeople;
    }

    public Integer getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(Integer maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getGameLength() {
        return gameLength;
    }

    public void setGameLength(String gameLength) {
        this.gameLength = gameLength;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name of game='" + nameOfGame + '\'' +
                ", minimum number of people='" + minNumberOfPeople + '\'' +
                ", maximum number of people=" + maxNumberOfPeople + '\'' +
                ", minimum age=" + minAge + '\'' +
                ", length of game='" + gameLength + '\'' +
                '}';
    }

}