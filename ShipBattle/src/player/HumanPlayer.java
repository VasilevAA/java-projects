package player;

public class HumanPlayer implements Player {

    private String name;

    public HumanPlayer(String text) {
        this.name = text;
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
