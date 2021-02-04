package com.angelo.spaceshooter;
import com.badlogic.gdx.graphics.Texture;
public class BasicEnemy extends Ship {
    /*
    * Texture is hard to put in a variable for now. So, hard code using different classes
    * to keep it DRY and clean.
    * Additional methods to create that would go to specific enemies:
    * attack()
    *
    * */
    Texture img;

    BasicEnemy(int posX, int posY) {
        super(posX, posY, new Texture("basicEnemy.png"));
    }
}
