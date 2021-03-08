package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.graalvm.compiler.phases.common.RemoveValueProxyPhase;

public class BasicEnemy extends Enemy {

    private WeaponFactory weaponFactory = new WeaponFactory();
    private final float MOVE_MAGNITUDE = 150;

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

    public void move() {
        int direction = this.getDirection();
        switch (direction) {
            case 0:
                direction = -1;
                break;
            case 1:
                direction = 1;
                break;
        }
        if (this.getX() <= 0)
            direction = 1;
        else if (this.getX() >= 800)
            direction = -1;
        this.setX(this.getX() + (direction) * (MOVE_MAGNITUDE) * Gdx.graphics.getDeltaTime());
    }

    public void entranceAnimation(float startY) {
        this.setY(startY);
        float endY = Gdx.graphics.getHeight() - 50;
        if (this.getY() >= endY)
            this.setY(this.getY() - 75  * Gdx.graphics.getDeltaTime());

    }
}
