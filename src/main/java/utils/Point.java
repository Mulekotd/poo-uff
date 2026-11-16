package utils;

public class Point {
    private int x; // longitude
    private int y; // latitude

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Methods

    public String toCoordinateString() {
        return this.x + " " + this.y;
    }

    @Override
    public String toString() {
        return "POINT (" + this.toCoordinateString() + ")";
    }

    // Getters

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // Setters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
