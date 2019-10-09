public class Square {
    private String cellStatus;
    private int coordinateX;
    private int coordinateY;

    public Square(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.cellStatus = "empty";
    }

    public String toString(){
        switch(cellStatus){
            case "shippart":
                return " @ ";
            case "empty":
                return " - ";
            case "hit":
                return " X ";
            case "miss":
                return " O ";
        }
        return "";
    }
    public void setCellStatus(String status){
        cellStatus = status;
    }

    public boolean getIsShipPart() {
        return cellStatus.equals("shippart");
    }

    public String getCellstatus(){
        return cellStatus;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }
}