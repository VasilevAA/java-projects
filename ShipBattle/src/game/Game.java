package game;

import gameelements.GameField;
import gameelements.Point;
import gameelements.Ship;
import player.Player;

public class Game {

    private Player player; // It's you
    private Player opponent; // your opponent (comp or real human)

    public  enum ShotType{WOUND,MISS,FINISH}

    public Game(Player first, Player second) {
        this.player = first;
        this.opponent = second;

    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }



    public ShotType makeShot(Point point) {

       // Cell.CellStatus status = opponent.getCellStatus(point); //point came without mistakes

        ShotType ret;
        if(opponent.getCellStatus(point) == GameField.CellStatus.EMPTY) {
           ret = opponent.setCellStatus(point, GameField.CellStatus.EMPTYSHOT);
        } else {
           ret = opponent.setCellStatus(point,GameField.CellStatus.SHIPSHOT);
        }
        opponent.printField();


        return ret;
        //return  opponent.getCellStatus(point);

    }



    // TODO: 07.06.2018 maybe we need hierarchy of game classes: human game and computer
    public Point getShot() {

        Point point;
        do {
            point = opponent.makeShot();
        } while (player.getCellStatus(point) == GameField.CellStatus.EMPTYSHOT
                || player.getCellStatus(point) == GameField.CellStatus.SHIPSHOT);

        if (player.getCellStatus(point) == GameField.CellStatus.EMPTY) {
            player.setCellStatus(point, GameField.CellStatus.EMPTYSHOT);
        } else {
            player.setCellStatus(point, GameField.CellStatus.SHIPSHOT);
//            opponent.setLastSuccess();
        }

        player.printField();
        return point;
    }
}
