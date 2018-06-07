package player;

import gameelements.Cell;
import gameelements.GameField;
import gameelements.Point;

public class HumanPlayer extends Player {


    public HumanPlayer(String text) {
        super(text);
    }

    @Override
    public boolean startTurn() {
        return false;
    }

    @Override
    public boolean endTurn() {
        return false;
    }

    @Override
    public Point makeShot() {
        return null;
    }



    @Override
    public Cell.CellStatus getCellStatus(Point point) {


        return field.getCells()[point.getY()][point.getX()].getStatus();


    }

    @Override
    public void setCellStatus(Point point, Cell.CellStatus status) {
        field.getCells()[point.getY()][point.getX()].setStatus(status);
    }


    @Override
    public GameField generateField() {
        return new GameField();
    }

}
