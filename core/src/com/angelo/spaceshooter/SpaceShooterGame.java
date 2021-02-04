package com.angelo.spaceshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class SpaceShooterGame extends ApplicationAdapter {
	SpriteBatch batch;
	//Texture heroImg;
	//private Rectangle hero;

	// make the hero
	Hero hero;

	// make a list of enemies
	ArrayList<Ship> basicEnemies = new ArrayList<Ship>();
	private int enemySpacingX = 40;
	private int numBasicEnemies = 5;

	EnemyFactory enemyFactory = new EnemyFactory();

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		/*
		heroImg = new Texture("hero.png");
		hero = new Rectangle();
		hero.x = 800/2 - 64 /2;
		hero.y = 20;
		hero.width = 10;
		hero.height = 8;
		*/
		hero = new Hero(800/2, 20);
		basicEnemies = enemyFactory.createEnemies("basic", 5);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, .2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(hero.getTexture(), hero.getX(), hero.getY());
		for (Ship basicEnemy: basicEnemies) {
			batch.draw(basicEnemy.getTexture(), basicEnemy.getX(), basicEnemy.getY());
		}
		batch.draw(hero.getWeapon().getTexture(), hero.getWeapon().getX(), hero.getWeapon().getY());
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

		if (Gdx.input.isTouched()) {
			hero.attack();
		}


		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) hero.setX(hero.getX() - 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))  hero.setX(hero.getX() + 200 * Gdx.graphics.getDeltaTime());

		//if (hero.x < 0) hero.x = 0;
		//if (hero.x > 800-64 ) hero.x = 800-64;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//hero.dispose();heroImg.dispose();
	}
}
