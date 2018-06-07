package gameelements;

public class GameField {

    private Cell[][] mainField = new Cell[10][10];

    public Cell[][] getCells() {
        return mainField;
    }

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mainField[i][j] = new Cell();
                if(j==5)
                    mainField[i][j].setStatus(Cell.CellStatus.SHIP);
            }
        }
    }

}
