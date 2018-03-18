package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:14
 */
public class Player {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    private Score highscore;

    public Score getHighscore() {
        return highscore;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.highscore = new Score(username);
    }

    public Player(String name, String username, String password, int score){
        this.name = name;
        this.username = username;
        this.password = password;
        this.highscore = new Score(username, score);
    }
}
