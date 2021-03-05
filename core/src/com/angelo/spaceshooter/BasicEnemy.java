package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BasicEnemy extends Enemy {

    private WeaponFactory weaponFactory = new WeaponFactory();

    BasicEnemy(float posX, float posY) {
        super(posX, posY, 30, 32, new Texture("basicEnemy.png"));
        setWeaponKind("basic");
    }

    public void attack() {
        this.getBullets().add(weaponFactory.createBullet(this.getWeaponKind(), this.getX(), this.getY()));
    }

    public void updateAttack(Hero hero) {
        if (!this.getBullets().isEmpty()) {
            for (Bullet bullet: this.getBullets()) {
                bullet.updateAttack(-1, 50);
                if (bullet.getY() < 0)
                    bullet.setRemove(true);
                bullet.getCollision().updateVariables(bullet.getX(), bullet.getY(), bullet.getHeight(), bullet.getWidth());;
            }
            this.bulletCollission(hero);
            this.deleteBullets();
        }
    }

    public void entranceAnimation(float startY) {
        this.setY(startY);
        float endY = Gdx.graphics.getHeight() - 50;
        if (this.getY() >= endY)
            this.setY(this.getY() - 75  * Gdx.graphics.getDeltaTime());

    }
}
