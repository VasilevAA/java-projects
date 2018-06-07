package game;

import gameelements.Cell;
import gameelements.Point;
import player.Player;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private Player player; // It's you
    private Player opponent; // your opponent (comp or real human)


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

    public void run() {//!!!

    }

    public void makeShot(Point point) {

       // Cell.CellStatus status = opponent.getCellStatus(point); //point came without mistakes

        if(opponent.getCellStatus(point) == Cell.CellStatus.EMPTY) {
            opponent.setCellStatus(point, Cell.CellStatus.EMPTYSHOT);
        } else {
            opponent.setCellStatus(point,Cell.CellStatus.SHIPSHOT);
        }
        opponent.printField();

        //return  opponent.getCellStatus(point);

    }

    // TODO: 07.06.2018 maybe we need hierarchy of game classes: human game and computer
    public Point getShot() {

        Point point;
        do {
            point = opponent.makeShot();
        } while (player.getCellStatus(point) == Cell.CellStatus.EMPTYSHOT
                || player.getCellStatus(point) == Cell.CellStatus.SHIPSHOT);

        if (player.getCellStatus(point) == Cell.CellStatus.EMPTY) {
            player.setCellStatus(point, Cell.CellStatus.EMPTYSHOT);
        } else {
            player.setCellStatus(point, Cell.CellStatus.SHIPSHOT);
            opponent.setLastSuccess();
        }

        player.printField();
        return point;
    }
}
