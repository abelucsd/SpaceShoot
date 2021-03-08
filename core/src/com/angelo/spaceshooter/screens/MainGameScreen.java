package com.angelo.spaceshooter.screens;

import com.angelo.spaceshooter.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.angelo.spaceshooter.EnemyFactory;
import java.util.ArrayList;
import java.util.Random;

public class MainGameScreen implements Screen {
    private final int SCREEN_WIDTH = 800;
    private final int MOVE_BUFFER_COLLISION = 50;
    SpaceShooterGame game;
    Hero hero;
    ArrayList<Enemy> basicEnemies = new ArrayList<Enemy>();
    private int enemySpacingX = 40;
    private int numBasicEnemies = 5;
    EnemyFactory enemyFactory = new EnemyFactory();
    BitmapFont font;
    private float clock;
    private float clockMove;
    private Random rand;

    public MainGameScreen(SpaceShooterGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        hero = new Hero(800/2, 20, "basic");
        basicEnemies = enemyFactory.createEnemies("basic", 5);

        font = new BitmapFont();
        clock = 0;
        clockMove = 0;
        rand = new Random();
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, .2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        for (Enemy enemy: basicEnemies) {
            enemy.entranceAnimation(enemy.getY());
        }

        game.batch.draw(hero.getTexture(), hero.getX(), hero.getY());
        for (Ship basicEnemy: basicEnemies) {
            game.batch.draw(basicEnemy.getTexture(), basicEnemy.getX(), basicEnemy.getY());
        }

        for (Bullet bullet: hero.getBullets()) {
            game.batch.draw(bullet.getTexture(), bullet.getX(), bullet.getY());
        }
        for (Enemy enemy: basicEnemies) {
            for (Bullet bullet: enemy.getBullets()) {
                game.batch.draw(bullet.getTexture(), bullet.getX(), bullet.getY());
            }
        }

        if (hero.getHealth() == 0) {
            this.dispose();
            game.setScreen(new GameOverScreen(game));
        }

        if (Gdx.input.isTouched()) {
            hero.attack();
        }


        hero.updateAttack(basicEnemies);

        if (clock > 2) {
            for (Enemy enemy : basicEnemies) {
                enemy.attack();
            }
            clock = 0;
        }
        for (Enemy enemy: basicEnemies) {
            enemy.updateAttack(hero);
        }

        if (clockMove > 1) {
            for (Enemy enemy: basicEnemies) {
                if (enemy.getX() <= MOVE_BUFFER_COLLISION)
                    enemy.setDirection(1);
                else if (enemy.getX() >= SCREEN_WIDTH - MOVE_BUFFER_COLLISION)
                    enemy.setDirection(0);
                else
                    enemy.setDirection(rand.nextInt(2));
                clockMove = 0;
            }
        }
        for (Enemy enemy: basicEnemies) {
            enemy.move();
        }

        font.draw(game.batch, hero.getScore().getScoreString(), 10, 10);

        clock += Gdx.graphics.getDeltaTime();
        clockMove += Gdx.graphics.getDeltaTime();

        game.batch.end();

		/*if (Gdx.input.isTouched()) {
			// change this to keyboard input/not mouse.
			// mouse input.
			// make touchPos an object field so we do not have to instantiate it all the time.
			// garbage collector does extra work this case.
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			hero.setX(touchPos.x - 64/2);
		}*/


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) hero.setX(hero.getX() - 200 * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))  hero.setX(hero.getX() + 200 * Gdx.graphics.getDeltaTime());

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
