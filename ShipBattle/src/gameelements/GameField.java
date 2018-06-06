package gameelements;

public class GameField {

    private Cell[][] mainField = new Cell[10][10];

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mainField[i][j] = new Cell();
            }
        }
    }

    public boolean isCellAlreadyShot(Point point) {

        return mainField[point.getY()][point.getX()].isAlreadyShot();
    }


    public void setCellAlreadyShot(Point point) {
        mainField[point.getY()][point.getX()].setAlreadyShot();
    }

}
