package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Jokey {
    private double speed = 1;
    public boolean isPlayer;
    private Sprite sprite;
    private MyGdxGame game;
    private int move = 0;
    public float x, y;
    private int step = 0;
    private Texture texture;
    private int w, h;
    private static final int animationMax = 4;
    private int animation;
    private Random rand = new Random();

    Jokey(float x, float y, boolean isPlayer, Texture texture, MyGdxGame game) {
        this.game = game;
        this.texture = texture;
        this.isPlayer = isPlayer;
        this.x = x;
        this.y = y;
        w = 1120 / 7;
        h = 100;
        sprite = new Sprite(new TextureRegion(texture, 0, 0, w, h));
    }

    private void updateAnimation() {
        animation++;
        if (animation > animationMax) {
            animation = 0;
            step++;
            if (step >= 7) step = 0;
        }
    }

    private boolean outOfScreen() {
        float px = x - game.x;
        float py = y - game.y;
        return (px > game.w) || (px + w < 0) || (py > game.h) || (py + h < 0);
    }

    void run() {
        x += speed;
        updateAnimation();
    }

    void speed() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if(this.speed <= 7){
                this.speed += 1;
            }
        }else if(speed > 2){
            speed -= 0.5;
        }
    }

    void vanish(){
        sprite.setRegion(new TextureRegion(texture, step * w, h, w, h));
    }

    void botSpeed(){
        this.speed = rand.nextInt(8) + 1;
    }

    void draw() {
        if (outOfScreen()) return;
        sprite.setRegion(new TextureRegion(texture, step * w, 0, w, h));
        sprite.setPosition(x - game.x, y - game.y);
        sprite.draw(game.batch);
    }
}
