public class Square {
    private boolean isShipPart;
    private int coordinateX;
    private int coordinateY;

    public Square(int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public String toString(){
        String content = (isShipPart) ? " x " : " - ";
        return content;
    }
    public void setIsShipPart(){
        isShipPart = true;
    }
    public boolean getIsShipPart() {
        return this.isShipPart;
    }

    public int getX() {
        return coordinateX;
    }

    public int getY() {
        return coordinateY;
    }
}