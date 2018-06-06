package game;

import player.Player;

public class Game {

    Player first;
    Player second;

    boolean isPlayingFirst;

    boolean isFirstWon;

    boolean isRunning;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
        isPlayingFirst = true;
        isFirstWon = false;
        isRunning = true;
    }

    public void run() {
        System.out.println("opa, zarabotalo");

        while (isRunning) {
            makeShot();
        }
    }

    private void makeShot() {
        Player one = isPlayingFirst ? first : second;
        Player two = isPlayingFirst ? second : first;
        System.out.println("now playing player: " + one.getName());

        //one.startTurn();


        while (!two.getCorrectShot(one.makeShot())) ;


        two.printField();


        one.endTurn();

        isPlayingFirst = !isPlayingFirst;

    }
}
