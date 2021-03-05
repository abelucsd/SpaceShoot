package com.angelo.spaceshooter.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import sun.jvm.hotspot.gc.shared.Space;

public class GameOverScreen implements Screen {
    SpaceShooterGame game;
    Texture gameOver;
    private final float START_X = 60;
    private final float START_Y = 200;

    public GameOverScreen(SpaceShooterGame game) {
        this.game = game;
        this.gameOver = new Texture("gameOverSprite.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

        game.batch.begin();
        game.batch.draw(this.gameOver, START_X, START_Y);
        if (Gdx.input.isTouched()) {
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
