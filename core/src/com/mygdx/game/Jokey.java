package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Jokey {
    private int speed = 2;
    private boolean isPlayer;
    private Sprite sprite;
    private MyGdxGame game;
    private int move = 0;
    private float x, y;
    private int step = 0;
    private Texture texture;
    private int w, h;
    private static final int animationMax = 4;
    private int animation;

    Jokey(float x, float y, Texture texture, MyGdxGame game) {
        this.game = game;
        this.texture = texture;
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

    void draw() {
        if (outOfScreen()) return;
        sprite.setRegion(new TextureRegion(texture, step * w, 0, w, h));
        sprite.setPosition(x - game.x, y - game.y);
        sprite.draw(game.batch);
    }
}
