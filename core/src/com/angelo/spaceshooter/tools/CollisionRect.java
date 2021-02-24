package com.angelo.spaceshooter.tools;

/*
 *   Takes in rect details and checks if there is collission with other rect
 *   Entities will have this.
 * */
public class CollisionRect {
    private float x, y;
    private int width, height;

    public CollisionRect(float x, float y, int height, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void updateVariables(float x, float y, int height, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(CollisionRect rect) {
        return (this.x < rect.x + rect.width && this.y < rect.y + rect.height && this.x + this.width > rect.x && this.y + this.height > rect.y);
    }

    public CollisionRect getColissionRect() {
        return this;
    }
}
