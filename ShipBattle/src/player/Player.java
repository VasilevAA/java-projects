package player;

import game.Game;
import gameelements.GameField;
import gameelements.Point;
import gameelements.Ship;

public abstract class Player {

    private String name;

    GameField field;

    public GameField getField() {
        return field;
    }

    Player(String name) {
        this.name = name;
        field = generateField();
    }

    public String name() {
        return name;
    }

    public abstract boolean startTurn();

    public abstract boolean endTurn();

    public abstract Point makeShot();

    public GameField.CellStatus getCellStatus(Point point) {
        return field.getCell(point);
    }

    public Game.ShotType setCellStatus(Point point, GameField.CellStatus status) {
        field.setCell(point, status);
        if (status == GameField.CellStatus.SHIPSHOT) {

            Ship temp = field.getShip(point);

            temp.hitShip();


            if (temp.isSank()) {

            Point[] p = temp.getSurrounds();
            for (int i = 0; i < p.length; i++) {
                setCellStatus(p[i],GameField.CellStatus.EMPTYSHOT);
            }
                return Game.ShotType.FINISH;


            } else {
                return Game.ShotType.WOUND;
            }

        }
        return Game.ShotType.MISS;
    }

    public void setLastSuccess() {
    }

    public abstract GameField generateField();

    public void printField() {
        System.out.println("player " + name + " field:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = (getCellStatus(new Point(j, i)) == GameField.CellStatus.EMPTYSHOT) ? 'o' :
                        getCellStatus(new Point(j, i)) == GameField.CellStatus.SHIP ? '#' :
                                getCellStatus(new Point(j, i)) == GameField.CellStatus.SHIPSHOT ? 'X' : '_';
                System.out.print(Character.toString(c) + ' ');
            }
            System.out.println();
        }

        System.out.println();
    }


}

