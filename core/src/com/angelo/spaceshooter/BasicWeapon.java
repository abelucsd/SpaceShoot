package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;

/*
* Unused class
* */

public class BasicWeapon extends Weapon{

    BasicWeapon(String name, float posX, float posY) {
        super(name, posX, posY);
    }

    @Override
    public void fire(float posX, float posY) {
        float temp = this.getY();
        this.setY(this.getY() + 400 * Gdx.graphics.getDeltaTime());
    }
}
