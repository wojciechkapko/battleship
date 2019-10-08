public class Square {
    private boolean isShipPart;

    public String toString(){
        String content = (isShipPart) ? " x " : " - ";
        return content;
    }
    public void setIsShipPart(){
        isShipPart = true;
    }
}