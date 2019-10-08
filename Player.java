import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player{
    private Ocean oponentOcean;
    private Ocean myOcean;
    Scanner scanner = new Scanner(System.in);
    Player(){
        oponentOcean = new Ocean();
        myOcean = new Ocean();
        createShips();
    }
    public int[] getCooridinates(){
        System.out.print("X: ");
        int x = scanner.nextInt() - 1;
        System.out.print("Y: ");
        int y = scanner.nextInt() - 1;
        int[] coordinates = {x, y};
        return coordinates;
    }
    public boolean getisHorizontal(){
        System.out.println("1. Horizontal");
        System.out.println("2. Vertical");
        int decision = scanner.nextInt();
        if (decision == 1){
            return true;
        }
        else if (decision == 2){
            return false;
        }
        System.out.println("Unsupported input");
        return getisHorizontal();
    }
    private void createShips(){
        Map<String, Integer> shipTypes = new HashMap<>();
        shipTypes.put("Carrier", 5);
        shipTypes.put("Battleship", 4);
        shipTypes.put("Cruiser", 3);
        shipTypes.put("Submarine", 3);
        shipTypes.put("Destroyer", 2);
        myOcean.printBoard();
        for(String shipType: shipTypes.keySet()){
            createSingleShip(shipType, shipTypes);
            myOcean.printBoard();
        }
    }

    private void createSingleShip(String shipType, Map<String, Integer> shipTypes){
        System.out.println("Creating " + shipType);
        int[] coordinates = getCooridinates();
        boolean position = getisHorizontal();
        myOcean.addShip(coordinates, shipTypes.get(shipType).intValue(), position);
    }
}