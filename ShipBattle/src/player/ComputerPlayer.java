package player;

import gameelements.GameField;
import gameelements.Point;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Point makeShot() {// TODO: 07.06.2018 make it just a bit smarter

        return new Point(new Random().nextInt(10), new Random().nextInt(10));
    }

    @Override
    public GameField generateField() {

        return new GameField().placeShipsRandomly();
    }


}
