package com.angelo.spaceshooter;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/*
* Added Methods to Ship:
*
* */
public abstract class Enemy extends Ship {

    private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    private String weaponKind;

    public Enemy(float posX, float posY, int height, int width, Texture enemyImg) {
        super(posX, posY, height, width, enemyImg);
    }

    public abstract void entranceAnimation(float startY);
    public abstract void attack();
    public abstract void updateAttack(Ship hero);
    public ArrayList<Bullet> getBullets() {return this.bulletList;}
    public void setWeaponKind(String weaponKind) {
        this.weaponKind = weaponKind;
    }
    public String getWeaponKind() {
        return this.weaponKind;
    }
}
