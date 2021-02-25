package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Hero extends Ship{
    // consider creating a Weapon class. Lazer can be different depending on weapon.
    private String weaponKind;
    private WeaponFactory weaponFactory = new WeaponFactory();
    /* Create ArrayList of Bullet */
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();

    // Scores
    private Scores score;

    Hero(float posX, float posY, String weaponKind) {
        super(posX, posY, 15, 16, new Texture("hero.png"));
        this.weaponKind = weaponKind;
        //weapon = new BasicWeapon("lazer", this.getX(), this.getY());
        this.score = new Scores();
    }

    public Scores getScore() {
        return this.score;
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

    public void updateAttack(ArrayList<Ship> enemies) {
        // condition to run this. bullet exists
        if (!bulletList.isEmpty()) {
            /* loop through all the bullets */
            for (Bullet bullet: bulletList) {
                bullet.updateAttack(); // change. crate a diff function.
                if (bullet.getY() > Gdx.graphics.getHeight()){
                    bullet.setRemove(true);
                }
                bullet.getCollision().updateVariables(bullet.getX(), bullet.getY(), bullet.getHeight(), bullet.getWidth());
            }
            // check for all enemies. O(n^2)? Let's work with this for now.
            // get all the enemies.
            for (Bullet bullet: bulletList) {
                int idx = 0;
                while (idx < enemies.size()) {
                    if (bullet.getCollision().collidesWith(enemies.get(idx).getCollision().getColissionRect())) {
                        enemies.remove(enemies.get(idx));
                        System.out.println("collided");
                        this.score.update(100);
                    }
                    else
                        idx++;
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
}
