package player;

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
    public GameField generateField() {

        return new GameField().placeShipRandomly();
    }

}
