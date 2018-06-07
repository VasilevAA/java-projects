package player;

import gameelements.Cell;
import gameelements.GameField;
import gameelements.Point;

public abstract class Player {

    private String name;

    GameField field;


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

    public abstract Cell.CellStatus getCellStatus(Point point);

    public abstract void setCellStatus(Point point, Cell.CellStatus status);

    public void setLastSuccess(){};

    public abstract GameField generateField();

    public void printField() {
        System.out.println("player " + name + " field:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = (getCellStatus(new Point(j, i)) == Cell.CellStatus.EMPTYSHOT) ? 'o' :
                        getCellStatus(new Point(j,i)) == Cell.CellStatus.SHIP ? '№' :
                                getCellStatus(new Point(j,i)) == Cell.CellStatus.SHIPSHOT ? 'X' :'_';
                System.out.print(Character.toString(c) + ' ');
            }
            System.out.println();
        }

        System.out.println();
    }


}

