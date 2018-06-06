package game;

import player.Player;

public class Game {

    Player first;
    Player second;

    public Game(Player first, Player second){
        this.first = first;
        this.second = second;
    }

    public void run(){
        System.out.println("opa, zarabotalo");
    }
}
