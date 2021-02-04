package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
public abstract class Weapon {
    private Rectangle weapon;
    private Texture weaponImg;
    private String name;
    private float posX;
    private float posY;

    Weapon(String name, float posX, float posY){
        this.name = name;
        this.weapon = new Rectangle();
        this.weaponImg = new Texture("6.png");
        this.posX = posX;
        this.posY = posY;
    };

    public Texture getTexture() {
        return this.weaponImg;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setX(float posX) {
        this.posX = posX;
    }
    public float getX() {
        return this.posX;
    }
    public void setY(float posY) {
        this.posY = posY;
    }
    public float getY() {
        return this.posY;
    }

    abstract public void fire(float posX, float posY);
}
