package com.ar9013.life17;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by ar9013 on 2017/1/31.
 */
public class MyActor extends Image {

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());

        ((TextureRegionDrawable)getDrawable()).draw(batch,getX(),getY(),
                getOriginX(),getOriginY(),
                getWidth(),getHeight(),
                getScaleX(),getScaleY(),
                getRotation());
    }

    public MyActor(Texture texture) {
        super(texture);
        setBounds(getX(),getY(),getWidth(),getHeight());

        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch (keycode){
                    case Input.Keys.W:
                        MoveToAction moveToAction = new MoveToAction();  // 移動到指定位置
                        moveToAction.setPosition(200f,200f);
                        moveToAction.setDuration(5f);
                        MyActor.this.addAction(moveToAction);
                        break;


                    case Input.Keys.A:
                        MoveByAction moveByAction = new MoveByAction(); // 移動到相對的位置
                        moveByAction.setAmount(-200f,0f);
                        moveByAction.setDuration(3f);
                        MyActor.this.addAction(moveByAction);
                        break;

                    case  Input.Keys.D:
                        ColorAction colorAction = new ColorAction();
                        colorAction.setEndColor(Color.PINK);
                        colorAction.setDuration(5f);
                        MyActor.this.addAction(colorAction);
                        break;
                }
                return  true;
            }
        });
    }
}
