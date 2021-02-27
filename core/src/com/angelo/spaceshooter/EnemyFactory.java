package com.angelo.spaceshooter;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class EnemyFactory {
    // creates enemies.
    private static int xSpacing = 40;
    private float initPosX = 800/2 - 64/2;
    private float initPosY = 480 - 64/2 - 20;


    EnemyFactory() {
    }

    /*
    * Input: What kind of enemy is it?; # of enemies
    * Return: Enemy object
    * */
    public ArrayList<Enemy> createEnemies(String enemyKind, int numEnemies) {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int i = 0; i < numEnemies; i++) {
            // create specific enemy
            enemies.add(createEnemy(enemyKind));
        }
        // initialize x and y pos for the enemies.
        enemySpacing(enemies, numEnemies);
        return enemies;
    }

    /*
    *  Input: Kind of enemy
    *  Return: Enemy but specific through polymorphism
    * */
    private Enemy createEnemy(String enemyKind) {
        Enemy enemy = null;
        switch(enemyKind) {
            case "basic" :
                enemy = new BasicEnemy(0, Gdx.graphics.getHeight() + 100);
                break;
            case "skinny":
                //enemy = new SkinnyEnemy();
                break;
            case "yellow":
                //enemy = new YellowEnemy();
                break;
            case "green":
                //enemy = new GreenEnemy();
                break;
            default:
                // basic enemy

        }
        return enemy;
    }

    /*
    * Input: enemy list and # enemies
    * Return: void
    * Expectation: initialize the x and y position of the enemies.
    * */
    private void enemySpacing(ArrayList<Enemy> enemies, int numEnemies) {
        float sumPosXSpace = initPosX;
        for (int i = 0; i < numEnemies; i++) {
            sumPosXSpace += xSpacing;
            enemies.get(i).setX(sumPosXSpace);
            //enemies.get(i).setY(initPosY);
        }
    }
}
