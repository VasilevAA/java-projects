package game;

import gameelements.Point;
import player.Player;

public class Game {

    private Player player; // It's you
    private Player opponent; // your opponent (comp or real human)


    public Game(Player first, Player second) {
        this.player = first;
        this.opponent = second;

    }

    public void run() {//!!!
        System.out.println("opa, zarabotalo");

    }

    public void makeShot(Point point) {
        opponent.getCorrectShot(point); //point came without mistakes
        opponent.printField();

        getShot();

    }

    // TODO: 07.06.2018 maybe we need hierarchy of game classes: human game and computer
    private void getShot() {
        while(!player.getCorrectShot(opponent.makeShot())) {
            //waiting for opponent shot
        }
        player.printField();
    }
}
