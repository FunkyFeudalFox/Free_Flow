package freeFlow.view.Score;


import freeFlow.model.Score;

import java.util.List;

public class ScorePresenter {

    public ScorePresenter(ScoreView view, List<Score> highScores) {

        // fill table
        highScores.forEach(s -> view.addHighScore(s.getPlayer(), s.getScore()));

    }
}
