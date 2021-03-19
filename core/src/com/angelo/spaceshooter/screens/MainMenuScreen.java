package com.angelo.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

public class MainMenuScreen implements Screen {
    SpaceShooterGame game;
    Texture mainMenu;
    Texture highScores;

    private final float START_X = 260;
    private final float START_Y = 250;
    private final float HIGHSCORE_X = 160;
    private final float HIGHSCORE_Y = 150;

    Vector2 touchPosition = new Vector2();

    public MainMenuScreen(SpaceShooterGame game) {
        this.game = game;
        this.mainMenu = new Texture("startGameSprite.png");
        this.highScores = new Texture("highScoresSprite.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, .2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(this.mainMenu, START_X, START_Y);
        game.batch.draw(this.highScores, HIGHSCORE_X, HIGHSCORE_Y);

        if (Gdx.input.isTouched()) {
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
            if (touchPosition.x >= 260 && touchPosition.y >= 170 && touchPosition.x <= 460 && touchPosition.y <= 230) {
                this.dispose();
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        game.setScreen(new MainGameScreen(game));
                    }
                }, 1);
            }
        }
        if (Gdx.input.isTouched()) {
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
            if (touchPosition.x >= 160 && touchPosition.y >= 280 && touchPosition.x <= 460 && touchPosition.y <= 350) {
                this.dispose();
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        game.setScreen(new HighScoresScreen(game));
                    }
                }, 1);
            }
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
