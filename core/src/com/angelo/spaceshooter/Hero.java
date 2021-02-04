package com.angelo.spaceshooter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class Hero extends Ship{
    // consider creating a Weapon class. Lazer can be different depending on weapon.
    private Weapon weapon;

    Hero(float posX, float posY) {
        super(posX, posY, new Texture("hero.png"));
        weapon = new BasicWeapon("lazer", this.getX(), this.getY());
    }

    // make a lazer shoot
    /*
    *  Input:
    *  Output:
    *  Expectation: Dispose after colliding with an enemy or passing the display boundary.
    * */
    public void attack() {
        // start with curr x y
        // consider collision.
        // activate by left click
        weapon.fire(this.getX(), this.getY());
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
