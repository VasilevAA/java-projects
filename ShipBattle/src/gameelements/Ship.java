package gameelements;

public class Ship {

    private Point[] points;

    private Point[] pointsAround;

    private int numberOfAlreadyShot = 0;

    private int size;

    Ship(int size) {
        this.size = size;
        points = new Point[size];
    }

    public Point[] getPointsAround() {
        return pointsAround;
    }

    void setPointsAround(Point[] pointsAround) {
        this.pointsAround = pointsAround;
    }

    void setPoints(Point[] points) {
        this.points = points;
    }

    int getSize() {
        return size;
    }

    boolean contains(Point p) {
        for (Point point : points) {
            if (p.equals(point)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSank() {
        return numberOfAlreadyShot == size;
    }

    public void hitShip() {
        numberOfAlreadyShot++;
    }
}
