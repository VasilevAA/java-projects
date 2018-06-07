package gameelements;



public class Cell {

    // TODO: 07.06.2018 need more info bout cell (is ship in it and is it damaged )

    public  enum CellStatus{EMPTYSHOT,EMPTY,SHIPSHOT,SHIP};

    private CellStatus status;

    public Cell(){
        status = CellStatus.EMPTY;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }


}
