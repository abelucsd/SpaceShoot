package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
public class BasicBullet extends Bullet {

    BasicBullet(float posX, float posY) {
        // have constant height and width for now.
        super(posX, posY, 15, 15, new Texture("6.png"));
    }

    /*
    * Parameters: direction, multiplier
    * The bullet will be fired at the direction of Ship firing and at the magnitude of the multiplier.
    * Soon will be vector.
    * */
    public void updateAttack(int direction, int multiplier) {
        // change to use vectors.
        this.setY(this.getY() + (direction)*(multiplier) * Gdx.graphics.getDeltaTime());
        this.getCollision().updateVariables(this.getX(), this.getY(), this.getHeight(), this.getWidth());

    }
}
