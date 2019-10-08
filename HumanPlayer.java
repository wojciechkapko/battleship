import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(){
        scanner = new Scanner(System.in);
        this.createShips();
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
        ocean.printBoard();
        for(String shipType: shipTypes.keySet()){
            createSingleShip(shipType, shipTypes);
            ocean.printBoard();
        }
    }

    private void createSingleShip(String shipType, Map<String, Integer> shipTypes){
        System.out.println("Creating " + shipType);
        boolean wasAdded;
        while(true){
            int[] coordinates = getCooridinates();
            boolean position = getisHorizontal();
            wasAdded = ocean.addShip(coordinates, shipTypes.get(shipType).intValue(), position);
            if(wasAdded)
                break;
            else
                System.out.println("You cannot place it there.");
        }
    }
}