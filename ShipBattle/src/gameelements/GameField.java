package gameelements;

public class GameField {

    public enum CellStatus {EMPTYSHOT, EMPTY, SHIPSHOT, SHIP}



    private CellStatus[][] cells = new CellStatus[10][10];

    public CellStatus getCell(Point p) {
        return cells[p.getY()][p.getX()];
    }

    public void setCell(Point p, CellStatus st) {
        cells[p.getY()][p.getX()] = st;
    }

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = CellStatus.EMPTY;
                if (i == 5) {
                    cells[i][j] = CellStatus.SHIP;
                }

            }
        }
    }

    public GameField random() {

        return this;
    }

}
