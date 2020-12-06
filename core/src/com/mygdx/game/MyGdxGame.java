package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    float x, y;
    int w, h;

    private Texture background;
    private Map<String, Texture> textures = new HashMap<String, Texture>();
    private List<Jokey> jokeys = new ArrayList<Jokey>();
    private Music music;

    @Override
    public void create() {
        batch = new SpriteBatch();

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        background = new Texture("background.png");

        textures.put("actorPlayer", new Texture("horse-blue.png"));
        textures.put("actorhorse1", new Texture("horse-green.png"));
        textures.put("actorhorse3", new Texture("horse-red.png"));
        textures.put("actorhorse2", new Texture("horse-pink.png"));

        jokeys.add(new Jokey(80, (800 - 440), true, textures.get("actorPlayer"), this));
        jokeys.add(new Jokey(80, (800 - 530), false, textures.get("actorhorse1"), this));
        jokeys.add(new Jokey(80, (800 - 630), false, textures.get("actorhorse3"), this));
        jokeys.add(new Jokey(80, (800 - 735), false, textures.get("actorhorse2"), this));

        music = Gdx.audio.newMusic(Gdx.files.internal("look-at-my-horse.wav"));
        music.play();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        for (Jokey jokey : jokeys) {
            jokey.draw();
        }
        execute();
        batch.end();
        sleep(20);
    }

    private void execute() {
        for (Jokey jokey : jokeys) {
            end(jokey);
            jokey.run();
            if (jokey.isPlayer) {
                jokey.speed();
            } else {
                jokey.botSpeed();
            }
        }
    }

    private void end(Jokey jokey) {
        if(jokey.x >= 1800){
            setScreen(jokey);
        }
    }

    private void setScreen(Jokey jokey){
        for(Jokey j : jokeys){
            j.vanish();
        }

        music.stop();
        if(jokey.isPlayer){
            background = new Texture("win.png");
            music = Gdx.audio.newMusic(Gdx.files.internal("win.wav"));
            music.play();
        }else{
            background = new Texture("lose.png");
            music = Gdx.audio.newMusic(Gdx.files.internal("lose.wav"));
            music.play();
        }
    }

    private void sleep(int timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }
}
