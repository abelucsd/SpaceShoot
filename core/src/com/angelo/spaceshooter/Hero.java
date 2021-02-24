package com.angelo.spaceshooter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Hero extends Ship{
    // consider creating a Weapon class. Lazer can be different depending on weapon.
    private String weaponKind;
    private WeaponFactory weaponFactory = new WeaponFactory();
    /* Create ArrayList of Bullet */
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

    Hero(float posX, float posY, String weaponKind) {
        super(posX, posY, new Texture("hero.png"));
        this.weaponKind = weaponKind;
        //weapon = new BasicWeapon("lazer", this.getX(), this.getY());
    }

    public ArrayList<Bullet> getBullets() {
        return this.bulletList;
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
        bulletList.add(weaponFactory.createBullet(weaponKind, this.getX(), this.getY()));
        //weapon.fire(this.getX(), this.getY());
    }

    public void updateAttack() {
        // condition to run this. bullet exists
        if (!bulletList.isEmpty()) {
            /* loop through all the bullets */
            for (Bullet bullet: bulletList) {
                bullet.updateAttack(); // change. crate a diff function.
                if (bullet.getY() > Gdx.graphics.getHeight()){
                    bullet.setRemove(true);
                }
            }

            /* Delete bullets at height */
            int idx = 0;
            while (idx < bulletList.size())
            {
                if (bulletList.get(idx).getRemove()) {
                    bulletList.remove(idx);
                }
                idx++;
            }
        }
    }

    // delete this. Refactored to WeaponFactory to making bullets, not weapons.
    /*public Weapon getWeapon() {
        return this.weapon;
    }*/
}
