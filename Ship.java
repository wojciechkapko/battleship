public class Ship{
    Square[] shipElements;
    String shipName;
    Ship(Square[] shipElements, String name){
        this.shipElements = shipElements;
        this.shipElements = name;
        for (Square element: shipElements){
            element.setCellStatus("shippart");
        }
    }
}