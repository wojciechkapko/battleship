public class Ship{
    Square[] shipElements;
    String shipName;
    Ship(Square[] shipElements, String name){
        this.shipElements = shipElements;
        this.shipName = name;
        for (Square element: shipElements){
            element.setCellStatus("shippart");
        }
    }
    public Square[] getShipElements(){
        return shipElements;
    }
    public String getName(){
        return shipName;
    }
}