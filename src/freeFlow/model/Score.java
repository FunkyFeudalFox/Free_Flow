package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/10/2018 16:22
 */
public class Score implements Comparable <Score>{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String player;

    public Score(String player) {
        this.player = player;
        this.score = 0;
    }

    public Score(String player, int score) {
        this.player = player;
        this.score = score;
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public int compareTo(Score otherScore) {
        int scoreVerschil = this.getScore() - otherScore.getScore();
        if (scoreVerschil != 0) { return scoreVerschil; }
        return this.player.compareTo(otherScore.player);
    }
}
