package com.angelo.spaceshooter.screens;
import com.angelo.spaceshooter.HighScores;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SpaceShooterGame extends Game {
	public SpriteBatch batch;
	public HighScores highScores;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		highScores = new HighScores();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
