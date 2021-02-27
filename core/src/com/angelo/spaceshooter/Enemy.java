package com.angelo.spaceshooter;

import com.badlogic.gdx.graphics.Texture;

/*
* Added Methods to Ship:
*
* */
public abstract class Enemy extends Ship {
    Enemy(float posX, float posY, int height, int width, Texture enemyImg) {
        super(posX, posY, height, width, enemyImg);
    }

    abstract void entranceAnimation(float startY);
}
