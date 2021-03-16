package com.angelo.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;
import sun.jvm.hotspot.gc.shared.Space;

public class HighScoresScreen implements Screen {
    SpaceShooterGame game;
    Texture highScore;
    private final float START_X = 60;
    private final float START_Y = 100;
    private final int NUM_SCORES = 5;
    BitmapFont font;

    public HighScoresScreen(SpaceShooterGame game){
        this.game = game;
        // make highscore texture
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        game.batch.begin();
        game.batch.draw(this.highScore, START_X, START_Y);
        //font.draw(game.batch, hero.getScore().getScoreString(), 10, 10);
        float x_pos = START_X + 50;
        float y_pos = START_Y + 30;

        for (int i = 0; i < NUM_SCORES; i++) {
            font.draw(game.batch, String.valueOf(game.highScores.getScoreList().get(i)), x_pos, y_pos);
            y_pos += 30;
        }
        if (Gdx.input.isTouched()) {
            // touch input button/dimensions
            this.dispose();
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    game.setScreen(new MainMenuScreen(game));
                }
            }, 1);
        }
        game.batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
