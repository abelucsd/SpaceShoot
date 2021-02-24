package com.angelo.spaceshooter;
import com.angelo.spaceshooter.tools.CollisionRect;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Ship {
    // All enemies have Texture, Rectangle, posX, posY, height and width
    private Rectangle enemy;
    private Texture enemyImg;
    private float posX;
    private float posY;
    // height and width should be determined by the kind of enemy. right now only 1 kind.
    private int height;
    private int width;

    // collision
    private CollisionRect collision;

    Ship(float posX, float posY, int height, int width, Texture enemyImg) {
        this.posX = posX;
        this.posY = posY;
        this.enemy = new Rectangle();
        this.enemyImg = enemyImg;
        this.height = height;
        this.width = width;

        this.collision = new CollisionRect(this.posX, this.posY, this.height, this.width);
    }

    public void setX(float posX){
        this.posX = posX;
        this.collision = new CollisionRect(this.posX, this.posY, this.height, this.width);
    }
    public void setY(float posY){
        this.posY = posY;
        this.collision = new CollisionRect(this.posX, this.posY, this.height, this.width);
    }
    public float getX(){
        return posX;
    }
    public float getY(){
        return posY;
    }

    public Texture getTexture(){ return enemyImg; }
    public Rectangle getRectangle(){
        return enemy;
    }

    public CollisionRect getCollision() {
        return this.collision;
    }
}
