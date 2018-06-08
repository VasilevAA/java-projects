package player;

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

    public  GameField.CellStatus getCellStatus(Point point){
        return field.getCell(point);
    }

    public abstract void setCellStatus(Point point, GameField.CellStatus status);

    public void setLastSuccess(){}

    public abstract GameField generateField();

    public void printField() {
        System.out.println("player " + name + " field:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = (getCellStatus(new Point(j, i)) == GameField.CellStatus.EMPTYSHOT) ? 'o' :
                        getCellStatus(new Point(j,i)) == GameField.CellStatus.SHIP ? '#' :
                                getCellStatus(new Point(j,i)) == GameField.CellStatus.SHIPSHOT ? 'X' :'_';
                System.out.print(Character.toString(c) + ' ');
            }
            System.out.println();
        }

        System.out.println();
    }


}

