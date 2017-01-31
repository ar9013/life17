package com.ar9013.life17;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Life17 extends ApplicationAdapter {
	Stage stage;

	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		stage.addActor(new MyActor(new Texture(Gdx.files.internal("badlogic.jpg"))));
		Gdx.input.setInputProcessor(stage);
		stage.setKeyboardFocus(stage.getActors().first());

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {

	}
}
