package com.angelo.spaceshooter;

public class Scores {

    private int score;
    private String scoreStr;

    public Scores () {
        this.score = 0;
        this.scoreStr = "0";
    }

    public void update(int morePoints) {
        this.score += morePoints;
        this.scoreStr = Integer.toString(this.score);
    }

    public String getScoreString() {
        return this.scoreStr;
    }
   
}
