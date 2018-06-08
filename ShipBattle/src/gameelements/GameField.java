package gameelements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameField {

    public enum CellStatus {EMPTYSHOT, EMPTY, SHIPSHOT, SHIP}

    private CellStatus[][] cells = new CellStatus[10][10];

    private Ship[] ships = new Ship[10];

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = CellStatus.EMPTY;
            }
        }
    }

    public CellStatus getCell(Point p) {
        return cells[p.getY()][p.getX()];
    }

    public void setCell(Point p, CellStatus st) {

        cells[p.getY()][p.getX()] = st;
    }

    public Ship getShip(Point point) {
        for (Ship ship : ships) {
            if (ship.contains(point)) {
                return ship;
            }
        }
        return null;
    }

    public GameField placeShipsRandomly() {

        for (int i = 0, size = 4; i < 10; i++) {
            if (i == 1 || i == 3 || i == 6) {
                size--;
            }
            ships[i] = new Ship(size);
            placeShip(ships[i], size);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (getCell(new Point(j, i)) == CellStatus.EMPTYSHOT) {
                    setCell(new Point(j, i), CellStatus.EMPTY);
                }
            }
        }

        return this;
    }

    private void placeShip(Ship ship, int size) {

        int shipDirection; //1 - right, 2 - bot, 3 - left, 4 - top
        Point firstPoint;
        do {
            firstPoint = new Point(new Random().nextInt(10), new Random().nextInt(10));
            shipDirection = getCorrectPositionForShip(firstPoint, size);
        }
        while (shipDirection == 0);

        placeShipCorrectly(firstPoint, ship, shipDirection);


    }

    private int getCorrectPositionForShip(Point firstPoint, int size) {

        int k = new Random().nextInt(4) + 1;
        boolean t = true;

        for (int i = 0; i < size; i++) {
            CellStatus status;
            switch (k) {
                case 1:
                    if (firstPoint.getX() + size <= 10) {
                        status = getCell(new Point(firstPoint.getX() + i, firstPoint.getY()));
                        if (status == CellStatus.SHIP || status == CellStatus.EMPTYSHOT) {
                            t = false;
                        }
                    } else {
                        t = false;
                    }
                    break;
                case 2:
                    if (firstPoint.getY() + size <= 10) {
                        status = getCell(new Point(firstPoint.getX(), firstPoint.getY() + i));
                        if (status == CellStatus.SHIP || status == CellStatus.EMPTYSHOT) {
                            t = false;
                        }
                    } else {
                        t = false;
                    }
                    break;
                case 3:
                    if (firstPoint.getX() - size >= -1) {
                        status = getCell(new Point(firstPoint.getX() - i, firstPoint.getY()));
                        if (status == CellStatus.SHIP || status == CellStatus.EMPTYSHOT) {
                            t = false;
                        }
                    } else {
                        t = false;
                    }
                    break;
                case 4:
                    if (firstPoint.getY() - size >= -1) {
                        status = getCell(new Point(firstPoint.getX(), firstPoint.getY() - i));
                        if (status == CellStatus.SHIP || status == CellStatus.EMPTYSHOT) {
                            t = false;
                        }
                    } else {
                        t = false;
                    }
                    break;
            }
        }
        return t ? k : 0;
    }

    private void placeShipCorrectly(Point firstPoint, Ship ship, int shipDirection) {

        Point[] shipPoints = new Point[ship.getSize()];
        Point[] pointsAroundShip;

        for (int i = 0; i < ship.getSize(); i++) {
            Point point = null;
            switch (shipDirection) {
                case 1:
                    point = new Point(firstPoint.getX() + i, firstPoint.getY());
                    break;
                case 2:
                    point = new Point(firstPoint.getX(), firstPoint.getY() + i);
                    break;
                case 3:
                    point = new Point(firstPoint.getX() - i, firstPoint.getY());
                    break;
                case 4:
                    point = new Point(firstPoint.getX(), firstPoint.getY() - i);
                    break;
            }
            setCell(point, CellStatus.SHIP);
            shipPoints[i] = point;
        }

        pointsAroundShip = getPointsAroundShip(shipPoints);

        for (Point aPointsAroundShip : pointsAroundShip) {
            setCell(aPointsAroundShip, CellStatus.EMPTYSHOT);
        }
        ship.setPoints(shipPoints);
        ship.setPointsAround(pointsAroundShip);
    }

    private Point[] getPointsAroundShip(Point[] points) {
        List<Point> p = new ArrayList<>();
        for (Point point : points) {
            p.addAll(pointsAroundPoint(point));
        }
        Point[] retPoints = new Point[p.size()];
        retPoints = p.toArray(retPoints);

        return retPoints;
    }

    private List<Point> pointsAroundPoint(Point point) {
        List<Point> temp = new ArrayList<>();

        for (int i = point.getY() - 1; i <= point.getY() + 1; i++) {
            for (int j = point.getX() - 1; j <= point.getX() + 1; j++) {
                Point arP = new Point(j, i);
                if (isPointCorrect(arP)) {
                    temp.add(arP);
                }
            }
        }
        return temp;
    }

    private boolean isPointCorrect(Point p) {
        return p.getX() >= 0 && p.getY() >= 0
                && p.getX() <= 9 && p.getY() <= 9
                && (getCell(p) != CellStatus.SHIP);
    }
}



