package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;
public class BasicWeapon extends Weapon{

    BasicWeapon(String name, float posX, float posY) {
        super(name, posX, posY);
    }

    @Override
    public void fire(float posX, float posY) {
        System.out.println("fire");
        // start at ship's current position and fire.
        // question: how do we render it iteratively upwards?
        float temp = this.getY();
        this.setY(this.getY() + 400 * Gdx.graphics.getDeltaTime());
        /*while (this.getY() <= 400) {
            // can try if (y > Gdx.graphics.getHeight()
            this.setY(this.getY() + 100 * Gdx.graphics.getDeltaTime());
        }*/
        /*
        * if we reach the max height, then we remove the weapon.
        * */

    }
}
