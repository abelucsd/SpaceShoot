package com.angelo.spaceshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class SpaceShooterGame extends ApplicationAdapter {
	//private int screenHeight = Gdx.graphics.getHeight();
	SpriteBatch batch;
	// make the hero
	Hero hero;

	// make a list of enemies
	ArrayList<Enemy> basicEnemies = new ArrayList<Enemy>();
	private int enemySpacingX = 40;
	private int numBasicEnemies = 5;

	EnemyFactory enemyFactory = new EnemyFactory();

	BitmapFont font;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		hero = new Hero(800/2, 20, "basic");
		basicEnemies = enemyFactory.createEnemies("basic", 5);

		font = new BitmapFont();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, .2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		for (Enemy enemy: basicEnemies) {
			enemy.entranceAnimation(enemy.getY());
		}

		batch.draw(hero.getTexture(), hero.getX(), hero.getY());
		for (Ship basicEnemy: basicEnemies) {
			batch.draw(basicEnemy.getTexture(), basicEnemy.getX(), basicEnemy.getY());
		}


		for (Bullet bullet: hero.getBullets()) {
			batch.draw(bullet.getTexture(), bullet.getX(), bullet.getY());
		}

		if (Gdx.input.isTouched()) {
			hero.attack();
		}


		hero.updateAttack(basicEnemies);

		font.draw(batch, hero.getScore().getScoreString(), 10, 10);

		batch.end();

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
	public void dispose () {
		batch.dispose();
		//hero.dispose();heroImg.dispose();
	}
}
