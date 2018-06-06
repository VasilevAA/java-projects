package gameelements;

public class GameField {

    Cell[][] fill = new Cell[10][10];

    public GameField() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fill[i][j] = new Cell();
            }
        }
    }

    public boolean isPointAlreadyShot(Point point) {
        return fill[point.getY()][point.getX()].isAlreadyShot();
    }


    public void pointCell(Point point){
        fill[point.getY()][point.getX()].setAlreadyShot(true);
    }

}
