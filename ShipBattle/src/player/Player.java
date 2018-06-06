package player;

import gameelements.GameField;
import gameelements.Point;

public abstract class Player {

    private String name;

    GameField field;


    Player(String name) {
        this.name = name;
        field = new GameField();
    }

    public String getName() {
        return name;
    }

    public abstract boolean startTurn();

    public abstract boolean endTurn();

    public abstract Point makeShot();

    public abstract boolean getCorrectShot(Point point);

    public void printField(){
        System.out.println("player " + name + " field:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char c = field.isCellAlreadyShot(new Point(j,i)) ? 'X' : '_';
                System.out.print(Character.toString(c) + ' ');
            }
            System.out.println();
        }

        System.out.println();
    }




}

