package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Hero extends Ship{
    private String weaponKind;
    private WeaponFactory weaponFactory = new WeaponFactory();
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    private Scores score;
    private int health;

    public Hero(float posX, float posY, String weaponKind) {
        super(posX, posY, 15, 16, new Texture("hero.png"));
        this.weaponKind = weaponKind;
        this.score = new Scores();
        this.health = 3;
    }
    public Scores getScore() {
        return this.score;
    }
    public ArrayList<Bullet> getBullets() {
        return this.bulletList;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return this.health;
    }
    public void updateHealthOnDamage(int damage){
        this.health -= damage;
    }
    /*
    *  Input:
    *  Output:
    *  Expectation: Dispose after colliding with an enemy or passing the display boundary.
    * */
    public void attack() {
        bulletList.add(weaponFactory.createBullet(weaponKind, this.getX(), this.getY()));
    }

    public void updateAttack(ArrayList<Enemy> enemies) {
        // condition to run this. bullet exists
        if (!bulletList.isEmpty()) {
            for (Bullet bullet: bulletList) {
                bullet.updateAttack(1, 100);
                if (bullet.getY() > Gdx.graphics.getHeight()){
                    bullet.setRemove(true);
                }
                bullet.getCollision().updateVariables(bullet.getX(), bullet.getY(), bullet.getHeight(), bullet.getWidth());
            }

            // check for all enemies. O(n^2)? Let's work with this for now.
            for (Bullet bullet: bulletList) {
                int idx = 0;
                while (idx < enemies.size()) {
                    if (bullet.getCollision().collidesWith(enemies.get(idx).getCollision().getColissionRect())) {
                        enemies.remove(enemies.get(idx));
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
