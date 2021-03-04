package com.angelo.spaceshooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MainMenuScreen implements Screen {
    SpaceShooterGame game;
    Texture mainMenu;

    private final float START_X = 260;
    private final float START_Y = 100;

    Vector2 touchPosition = new Vector2();

    public MainMenuScreen(SpaceShooterGame game) {
        this.game = game;
        this.mainMenu = new Texture("startGameSprite.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        game.batch.begin();
        game.batch.draw(this.mainMenu, START_X, START_Y);

        if (Gdx.input.isTouched()) {
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
            if (touchPosition.x >= 260 && touchPosition.y >= 300 && touchPosition.x <= 460 && touchPosition.y <= 400) {
                this.dispose();
                game.setScreen(new MainGameScreen((game)));
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
