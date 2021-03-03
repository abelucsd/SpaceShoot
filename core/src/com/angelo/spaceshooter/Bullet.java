package com.angelo.spaceshooter;
import com.angelo.spaceshooter.tools.CollisionRect;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public abstract class Bullet {

    private Rectangle bullet;
    private Texture bulletImg;
    private float posX;
    private float posY;
    private int height;
    private int width;

    private CollisionRect collision;

    private boolean remove;

    Bullet(float posX, float posY, int height, int width, Texture bulletImg) {
        this.posX = posX;
        this.posY = posY;
        this.bullet = new Rectangle();
        this.bulletImg = bulletImg;
        this.remove = false;
        this.height = height;
        this.width = width;

        this.collision = new CollisionRect(this.posX, this.posY, this.height, this.width);
    }

    public void updateAttack(int direction, int multiplier) {

    }

    public void setX(float posX){
        this.posX = posX;
    }
    public void setY(float posY){
        this.posY = posY;
    }
    public float getX(){
        return posX;
    }
    public float getY(){
        return posY;
    }

    public int getHeight() {return this.height;}
    public int getWidth() {return this.width;}

    public Texture getTexture(){ return bulletImg; }
    public Rectangle getRectangle(){
        return bullet;
    }

    public void setRemove(boolean flag) {
        this.remove = flag;
    }
    public boolean getRemove() {
        return this.remove;
    }

    public CollisionRect getCollision() {
        return this.collision;
    }
}
