package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Bullet {

    private Rectangle bullet;
    private Texture bulletImg;
    private float posX;
    private float posY;
    private int height;
    private int width;

    private boolean remove;

    Bullet(float posX, float posY, Texture bulletImg) {
        this.posX = posX;
        this.posY = posY;
        this.bullet = new Rectangle();
        this.bulletImg = bulletImg;
        this.remove = false;
    }

    public void updateAttack() {

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
}
