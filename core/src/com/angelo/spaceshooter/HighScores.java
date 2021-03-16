package com.angelo.spaceshooter;

import java.util.ArrayList;
import java.util.Arrays;

public class HighScores {
    ArrayList<Integer> scoreList;
    public HighScores() {
        this.scoreList = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public ArrayList<Integer> getScoreList() {
        return this.scoreList;
    }

    public void addHighScore(int score) {
        if (!isHighScore(score)) {
            return;
        }

        int idx = 0;
        while (score <= scoreList.get(idx))
            idx++;

        for (int i = idx; i < scoreList.size(); i++) {
            int temp = scoreList.get(i);
            scoreList.remove(scoreList.size()-1);
            scoreList.add(i, score);
            score = temp;
        }
    }

    private boolean isHighScore(int score) {
        int last = scoreList.size() - 1;
        if (score > scoreList.get(last))
            return true;
        return false;
    }
}
