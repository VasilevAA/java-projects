package game;

import gameelements.GameField;
import gameelements.Point;
import player.Player;

public class Game {

    public enum ShotType {WOUND, MISS, FINISH}

    private Player player; // It's you

    private Player opponent; // your opponent (comp or real human)

    public Game(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;

    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void makeShot(Point point) {

        if (opponent.getCellStatus(point) == GameField.CellStatus.EMPTY) {
            opponent.setCellStatus(point, GameField.CellStatus.EMPTYSHOT);
        } else {
            opponent.setCellStatus(point, GameField.CellStatus.SHIPSHOT);
        }

        opponent.printField();

    }

    public Player getWinner(){
        if(!player.hasAliveShips())
            return opponent;
        if(!opponent.hasAliveShips())
            return player;
        return null;
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
        }

        player.printField();
        return point;
    }
}
