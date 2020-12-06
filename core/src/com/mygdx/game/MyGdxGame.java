package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private Texture background;
	private Texture player;
	private Texture horse1;
	private Texture horse2;
	private Texture horse3;
	private Jokey actorPlayer;
	private Jokey actorHorse1;
	private Jokey actorHorse2;
	private Jokey actorHorse3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		player = new Texture("horse-blue.png");
		horse1 = new Texture("horse-green.png");
		horse2 = new Texture("horse-pink.png");
		horse3 = new Texture("horse-red.png");

		actorPlayer = new Jokey(20, 92, player, this);
		actorHorse1 = new Jokey(20, 108, horse1, this);
		actorHorse2 = new Jokey(20, 124, horse2, this);
		actorHorse3 = new Jokey(20, 140, horse3, this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		actorPlayer.draw();
		actorHorse1.draw();
		actorHorse2.draw();
		actorHorse3.draw();

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
