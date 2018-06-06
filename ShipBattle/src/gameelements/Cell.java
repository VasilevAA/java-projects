package gameelements;

class Cell {
    // TODO: 07.06.2018 need more info bout cell (is ship in it and is it damaged )
    private boolean alreadyShot = false;

    boolean isAlreadyShot() {
        return alreadyShot;
    }

    void setAlreadyShot() {
        this.alreadyShot = true;
    }


}
