package player;

import gameelements.GameField;
import gameelements.Point;

import java.util.Random;

public class ComputerPlayer extends Player {

    private int wasLastShotSuccesful = 0;

    private Point lastShot;
    private Point lastLastShot;

    boolean[] directions = new boolean[4];

    boolean goX;
    boolean goY;

    public ComputerPlayer(String name) {
        super(name);

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
    public Point makeShot() {// TODO: 07.06.2018 make it just a bit smarter

//        if (wasLastShotSuccesful == 1) {
//
//            if (isShotAvialiable(lastShot.getX() + 1, lastShot.getY()) && !directions[0]) {
//                directions[0] = true;
//                lastLastShot = new Point(lastShot.getX() + 1, lastShot.getY());
//
//            }
//
//            if (isShotAvialiable(lastShot.getX(), lastShot.getY() - 1) && !directions[1]) {
//                directions[1] = true;
//                lastLastShot = new Point(lastShot.getX(), lastShot.getY() - 1);
//                return true;
//            }
//
//            if (isShotAvialiable(lastShot.getX(), lastShot.getY() + 1) && !directions[2]) {
//                directions[2] = true;
//                lastLastShot = new Point(lastShot.getX(), lastShot.getY() + 1);
//                return true;
//            }
//
//            if (isShotAvialiable(lastShot.getX() - 1, lastShot.getY()) && !directions[3]) {
//                directions[3] = true;
//                lastLastShot = new Point(lastShot.getX() - 1, lastShot.getY());
//                return true;
//            }
//            wasLastShotSuccesful = 0;
//            for (int i = 0; i < directions.length; i++) {
//                directions[i] = false;
//
//            }
//
//        }

        lastShot = new Point(new Random().nextInt(10), new Random().nextInt(10));

        return lastShot;
    }



    private void preferYLine() {


    }

    private void preferXLine() {

    }

    private boolean isShotAvialiable(int x, int y) {
        return (x >= 0 && x <= 9
                && y >= 0 && y <= 9
        );
    }




    @Override
    public void setLastSuccess() {
        wasLastShotSuccesful++;
    }


    @Override
    public GameField generateField() {
        GameField fd = new GameField().placeShipRandomly();




        return  fd;
    }


}
