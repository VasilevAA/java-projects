package gameelements;

public class Ship {
    private Point[] points;
    private Point[] surrounds;

    private int numberOfAlreadyShot = 0;

    private int size;

    public int getSize() {
        return size;
    }

    public Point[] getSurrounds() {
        return surrounds;
    }

    public void setSurrounds(Point[] surrounds) {
        this.surrounds = surrounds;
    }

    public Ship(int size) {
        this.size = size;
        points = new Point[size];
    }

    public boolean contains(Point p){
        for (int i = 0; i < points.length; i++) {
            if(p.equals(points[i])){
                return true;
            }
        }
        return  false;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public boolean isSank(){
        return  numberOfAlreadyShot == size;
    }

    public void hitShip(){
        numberOfAlreadyShot++;
    }
}
