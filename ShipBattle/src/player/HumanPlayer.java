package player;

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
        return  null;
    }

    @Override
    public boolean getCorrectShot(Point point) {
        if(field.isCellAlreadyShot(point)) {
            System.out.println("not correct shot");
            return false;
        }

        field.setCellAlreadyShot(point);

        return true;

    }

}
