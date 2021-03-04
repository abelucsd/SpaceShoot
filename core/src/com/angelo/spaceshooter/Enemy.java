package com.angelo.spaceshooter;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/*
* Added Methods to Ship: entranceAnimation, setWeaponKind, getWeaponKind, getBullets
*
* Note that all the added functions seem to be the same as Hero. Perhaps put them in Ship.
* However, I still want an Enemy class because I know that all enemies will share the same functions that hero won't
* have. Such as entranceAnimation().
* This is a design tradeoff. We will most likely need an abstract Enemy class in the future.
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
