package gameelements;

public class Ship {
    private Point[] points;
    private int numberOfAlreadyShot = 0;
    private int size;

    public Ship(int size) {
        this.size = size;
        points = new Point[size];
    }

    boolean isSank(){
        return  numberOfAlreadyShot == size;
    }

    void hitShip(){
        numberOfAlreadyShot++;
    }
}
