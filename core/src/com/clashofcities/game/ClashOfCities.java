package com.clashofcities.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.awt.Rectangle;

public class ClashOfCities extends ApplicationAdapter implements ApplicationListener  {
	SpriteBatch batch;
	Texture[] frames;
	Texture coin1;
	Texture coin2;
	Texture coin3;
	Texture coin4;
	Texture coin5;
	Texture coin6;
	Texture coin7;
	Texture coin0;
	Texture background;
	TextureRegion bgRegion;
	Texture house;
	Animation<Texture> coinAnimation;
	Rectangle button;//210 316
	float stateTime;

	@Override
	public void create () {
		batch = new SpriteBatch();
		button= new Rectangle();
		button.x=200;
		button.y=100;
		button.height=316;
		button.width=210;
		coin0 = new Texture("coin_0.png");
		coin1 = new Texture("coin_1.png");
		coin2 = new Texture("coin_2.png");
		coin3 = new Texture("coin_3.png");
		coin4 = new Texture("coin_4.png");
		coin5 = new Texture("coin_5.png");
		coin6 = new Texture("coin_6.png");
		coin7 = new Texture("coin_7.png");
		background= new Texture("floor.png");
		house=new Texture("house.png");
		background.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
		bgRegion = new TextureRegion(background,0,0,800,480);
		frames =new Texture[8];
		frames[0]=coin0;
		frames[1]=coin1;
		frames[2]=coin2;
		frames[3]=coin3;
		frames[4]=coin4;
		frames[5]=coin5;
		frames[6]=coin6;
		frames[7]=coin7;
		coinAnimation = new Animation<Texture>(0.1f,frames);
		batch=new SpriteBatch();
		stateTime=0f;


	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		Texture currentFrame= coinAnimation.getKeyFrame(stateTime,true);
		batch.begin();
		batch.draw(bgRegion,0,0);
		batch.draw(house,200,100);
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			if(button.contains(touchPos.x,touchPos.y)){
				batch.draw(currentFrame,touchPos.x,touchPos.y);
			}
		}
		//
		batch.end();
	}



	@Override
	public void dispose () {
		batch.dispose();
		coin0.dispose();
		coin1.dispose();
		coin2.dispose();
		coin3.dispose();
		coin4.dispose();
		coin5.dispose();
		coin6.dispose();
		coin7.dispose();
		background.dispose();
	}
}

