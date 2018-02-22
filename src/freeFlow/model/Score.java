package freeFlow.model;

/**
 * @author Arjan Tammer
 * @version 1.0 2/10/2018 16:22
 */
public class Score implements Comparable <Score>{
    private int Score;

    public int getScore() {
        return Score;
    }

    private Player player;

    @Override
    public int compareTo(Score otherScore) {
        int scoreVerschil = this.getScore() - otherScore.getScore();
        if (scoreVerschil != 0) { return scoreVerschil; }
        return this.player.getName().compareTo(otherScore.player.getName());
    }
}
