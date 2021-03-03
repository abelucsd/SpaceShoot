package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
public class BasicBullet extends Bullet {

    BasicBullet(float posX, float posY) {
        // change pos to floats
        // have constant height and width 5 for now.
        super(posX, posY, 15, 15, new Texture("6.png"));
    }

    public void updateAttack(int direction, int multiplier) {
        // change to use vectors.
        // don't think we need the current positions passed in. It should have knowledge from creation.
        this.setY(this.getY() + (direction)*(multiplier) * Gdx.graphics.getDeltaTime());
        this.getCollision().updateVariables(this.getX(), this.getY(), this.getHeight(), this.getWidth());

    }
}
