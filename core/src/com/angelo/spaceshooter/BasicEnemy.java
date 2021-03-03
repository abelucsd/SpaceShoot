package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class BasicEnemy extends Enemy {
    /*
    * Texture is hard to put in a variable for now. So, hard code using different classes
    * to keep it DRY and clean.
    * Additional methods to create that would go to specific enemies:
    * attack()
    *
    * */
    Texture img;
    private WeaponFactory weaponFactory = new WeaponFactory();

    BasicEnemy(float posX, float posY) {
        super(posX, posY, 30, 32, new Texture("basicEnemy.png"));
        setWeaponKind("basic");
    }


    public void attack() {
        this.getBullets().add(weaponFactory.createBullet(this.getWeaponKind(), this.getX(), this.getY()));
    }

    public void updateAttack(Ship hero) {
        if (!this.getBullets().isEmpty()) {
            for (Bullet bullet: this.getBullets()) {
                bullet.updateAttack(-1, 50);
                if (bullet.getY() < 0)
                    bullet.setRemove((true));
                // insert collision here
                bullet.getCollision().updateVariables(bullet.getX(), bullet.getY(), bullet.getHeight(), bullet.getWidth());;
            }

            for (Bullet bullet: this.getBullets()) {
                int idx = 0;
                if (bullet.getCollision().collidesWith(hero.getCollision().getColissionRect())) {
                    // hero life subtraction.
                }
            }

            // delete bullets
            int idx = 0;
            while (idx < this.getBullets().size()) {
                if (this.getBullets().get(idx).getRemove())
                    this.getBullets().remove(idx);
                idx++;
            }
        }
    }

    public void entranceAnimation(float startY) {
        this.setY(startY);
        float endY = Gdx.graphics.getHeight() - 50;
        if (this.getY() >= endY)
            this.setY(this.getY() - 75  * Gdx.graphics.getDeltaTime());

    }
}
