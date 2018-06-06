package player;

import gameelements.Point;

import java.util.Random;

public class ComputerPlayer extends Player {


    public ComputerPlayer(String name) {
        super(name);

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

        return new Point(new Random().nextInt(10),new Random().nextInt(10));
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
