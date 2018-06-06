package player;

import gameelements.Point;

import java.util.TimerTask;

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

        isThinking = true;



        return shot;
    }

    @Override
    public boolean getCorrectShot(Point point) {
        if(field.isPointAlreadyShot(point)) {
            System.out.println("not correct shot");
            return false;
        }

        field.pointCell(point);

        return true;

    }

}
