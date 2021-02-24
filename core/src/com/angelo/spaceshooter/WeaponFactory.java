package com.angelo.spaceshooter;

public class WeaponFactory {

    /*
    * The weapon produces bullets. Different kinds in fact.
    * */

    WeaponFactory(){}

    public Bullet createBullet(String weaponKind, float xPos, float yPos) {
        Bullet bullet = null;
        switch(weaponKind) {
            case "basic":
                bullet = new BasicBullet( xPos, yPos);
                break;
            default:
                bullet = new BasicBullet(0, 0);
                break;
        }
        return bullet;
    }

}
