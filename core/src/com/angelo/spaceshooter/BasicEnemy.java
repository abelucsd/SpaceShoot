package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
public class BasicEnemy extends Enemy {
    /*
    * Texture is hard to put in a variable for now. So, hard code using different classes
    * to keep it DRY and clean.
    * Additional methods to create that would go to specific enemies:
    * attack()
    *
    * */
    Texture img;

    BasicEnemy(float posX, float posY) {
        super(posX, posY, 30, 32, new Texture("basicEnemy.png"));
    }

    public void entranceAnimation(float startY) {
        this.setY(startY);
        float endY = Gdx.graphics.getHeight() - 50;
        if (this.getY() >= endY)
            this.setY(this.getY() - 75  * Gdx.graphics.getDeltaTime());

    }
}
