package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Jokey {
    private int speed;
    private boolean isPlayer;
    private Sprite sprite;
    private MyGdxGame game;
    private int move = 1;
    private float x, y;
    private Texture texture;
    private int w, h;

    Jokey(float x, float y, Texture texture, MyGdxGame game) {
        this.game = game;
        this.texture = texture;
        this.x = x;
        this.y = y;
        w = 2800 / 7;
        h = 250;
        sprite = new Sprite(new TextureRegion(texture, 0, 0, w, h));
    }

    void run() { // metodo pra fazer os cavalos correrem automaticamente

    }

    void draw() {
        //sprite.setRegion(new TextureRegion(texture, move * w, h, w, h));
        //sprite.setPosition(x, y);

        sprite.draw(game.batch);
    }
}
