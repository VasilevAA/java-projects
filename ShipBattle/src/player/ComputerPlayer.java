package player;

import gameelements.GameField;

public class ComputerPlayer implements Player {

    private String name;
    private GameField mField;

    public ComputerPlayer(String name){
        this.name = name;
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
    public boolean makeTurn() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
