package player;

import gameelements.GameField;
import gameelements.Point;

public class HumanPlayer extends Player {


    public HumanPlayer(String text) {
        super(text);
    }

    @Override
    public Point makeShot() {
        return null;
    }

    @Override
    public GameField generateField() {

        return new GameField().placeShipsRandomly();
    }

}
