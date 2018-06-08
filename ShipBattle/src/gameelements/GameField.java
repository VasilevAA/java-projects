package gameelements;

import javafx.scene.control.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameField {

    private Point[] points;

    public enum CellStatus {EMPTYSHOT, EMPTY, SHIPSHOT, SHIP}


    private CellStatus[][] cells = new CellStatus[10][10];

    private Ship[] ships = new Ship[10];

    public CellStatus getCell(Point p) {
        return cells[p.getY()][p.getX()];
    }

    public void setCell(Point p, CellStatus st) {
        cells[p.getY()][p.getX()] = st;
    }

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = CellStatus.EMPTY;


            }
        }


    }

    public GameField placeShipRandomly() {
        ships[0] = new Ship(4);
        placeShip(ships[0], 4);
        for (int i = 1; i <= 2; i++) {
            ships[i] = new Ship(3);
            placeShip(ships[i], 3);
        }
        for (int i = 3; i <= 5; i++) {
            ships[i] = new Ship(2);
            placeShip(ships[i], 2);
        }
        for (int i = 6; i <= 9; i++) {
            ships[i] = new Ship(1);
            placeShip(ships[i], 1);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(getCell(new Point(j,i)) == CellStatus.EMPTYSHOT){
                    setCell(new Point(j,i),CellStatus.EMPTY);
                }
            }
        }

        return this;
    }

    private void placeShip(Ship ship, int size) {

        int direction = 0; //1 - right, 2 - bot, 3 - left, 4 - top
        Point first;
        do {

            first = new Point(new Random().nextInt(10), new Random().nextInt(10));

            direction = analyzeSurrounds(first, size);

        }
        while (direction == 0);
        placeFinalShip(first, ship, direction);


    }

    private int analyzeSurrounds(Point p, int size) {
        int k = new Random().nextInt(4) + 1;
        boolean t = true;
        switch (k) {
            case 1:
                if (p.getX() + size <= 10) {
                    for (int i = p.getX(); i < p.getX() + size; i++) {
                        CellStatus st = getCell(new Point(i, p.getY()));
                        if (st == CellStatus.SHIP
                                || st == CellStatus.EMPTYSHOT) {
                            t = false;
                            break;
                        }
                    }

                } else {
                    t = false;
                }
                break;
            case 2:
                if (p.getY() + size <= 10) {
                    for (int i = p.getY(); i < p.getY() + size; i++) {
                        CellStatus st = getCell(new Point(p.getX(), i));
                        if (st == CellStatus.SHIP
                                || st == CellStatus.EMPTYSHOT) {
                            t = false;
                            break;
                        }
                    }
                } else {
                    t = false;
                }
                break;
            case 3:
                if (p.getX() - size >= -1) {
                    for (int i = p.getX(); i > p.getX() - size; i--) {
                        CellStatus st = getCell(new Point(i, p.getY()));
                        if (st == CellStatus.SHIP
                                || st == CellStatus.EMPTYSHOT) {
                            t = false;
                            break;
                        }
                    }
                } else {
                    t = false;
                }
                break;
            case 4:
                if (p.getY() - size >= -1) {
                    for (int i = p.getY(); i > p.getY() - size; i--) {
                        CellStatus st = getCell(new Point(p.getX(), i));
                        if (st == CellStatus.SHIP
                                || st == CellStatus.EMPTYSHOT) {
                            t = false;
                            break;
                        }
                    }
                } else {
                    t = false;
                }
                break;
            default:

        }
        if (t) {
            return k;
        } else {
            return 0;
        }

    }


    private void placeFinalShip(Point p, Ship ship, int direction) {
        Point[] points = new Point[ship.getSize()];
        Point[] surroundingPoints = null;

        for (int i = 0; i < ship.getSize(); i++) {
            Point point = null;
            switch (direction) {
                case 1:
                    point = new Point(p.getX() + i, p.getY());
                    break;
                case 2:
                    point = new Point(p.getX(), p.getY() + i);
                    break;
                case 3:
                    point = new Point(p.getX() - i, p.getY());
                    break;
                case 4:
                    point = new Point(p.getX(), p.getY() - i);
                    break;
            }
            setCell(point, CellStatus.SHIP);
            points[i] = point;
        }

        surroundingPoints = getSurroundingPoints(points);

        for (int i = 0; i < surroundingPoints.length; i++) {
            setCell(surroundingPoints[i],CellStatus.EMPTYSHOT);
        }
        ship.setPoints(points);
        ship.setSurrounds(surroundingPoints);
        for (int i = 0; i < ship.getPoints().length; i++) {
            System.out.println(ship.getSize() + " - " +ship.getPoints()[i].getX() + " " + ship.getPoints()[i].getY());

        }
        System.out.println();


    }

    private Point[] getSurroundingPoints(Point[] points) {
        this.points = points;

        List<Point> p = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            p.addAll(surOfPoint(points[i]));

        }

        Point[] retPoints = new Point[p.size()];
        retPoints = p.toArray(retPoints);

        return  retPoints;
    }

    private List<Point> surOfPoint(Point point) {
        List<Point> temp = new ArrayList<>();


        for (int i = point.getX() - 1; i <= point.getX() + 1; i++) {
            Point p1 = new Point(i, point.getY() + 1);
            if (isCorrect(p1)) {
                temp.add(p1);
            }

            Point p2 = new Point(i, point.getY() - 1);
            if (isCorrect(p2)) {
                temp.add(p2);
            }
        }
        Point p3 = new Point(point.getX()-1,point.getY());
        if(isCorrect(p3)){
            temp.add(p3);
        }

        Point p4 = new Point(point.getX()+1, point.getY());
        if(isCorrect(p4)){
            temp.add(p4);
        }
        return  temp;
    }

    private boolean isCorrect(Point p) {
        return p.getX() >= 0 && p.getY() >= 0
                && p.getX() <= 9 && p.getY() <= 9
                && (getCell(p) != CellStatus.SHIP);
    }

    public Ship getShip(Point point){
        for (int i = 0; i < ships.length; i++) {
            if(ships[i].contains(point)){
                return ships[i];
               // System.out.println("ttttoasofasdjfoajsdf");
            }
        }
        System.out.println("tut");
        return  null;
    }
}



