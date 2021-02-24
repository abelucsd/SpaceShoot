package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
public class BasicBullet extends Bullet {

    BasicBullet(float posX, float posY) {
        // change pos to floats
        super(posX, posY, new Texture("6.png"));
    }

    public void updateAttack() {
        // change to use vectors.
        // don't think we need the current positions passed in. It should have knowledge from creation.
        System.out.println("updateattack");
        this.setY(this.getY() + 100 * Gdx.graphics.getDeltaTime());
    }

    // create delete function
}
