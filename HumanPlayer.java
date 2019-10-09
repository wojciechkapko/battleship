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
    public void playerAttack(){
        int[] coordinates = new int[2];
        coordinates = getCooridinates();
        int x = coordinates [0];
        int y = coordinates [1];
        attack(x, y);
    }

    private void createShips(){
        Map<String, Integer> shipTypes = Settings.getShipTypes();
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

    public void printOpponentBoard(){
        ocean.printYAxis();
        for(int x = 0; x < ocean.getBoardLimit(); x++){
            ocean.printXAxis(x);
            for(int y = 0; y < ocean.getBoardLimit(); y++){
                Square boardSquare = getOpponentOcean()[x][y];
                    String cellStatus = boardSquare.getCellStatus();
                    if (cellStatus.equals("shippart")){
                        System.out.print(" - ");
                    }
                    else{
                        System.out.print(boardSquare);
                    }
            }
            System.out.print("\n");
        }
        System.out.println("");
        System.out.println("x");
        System.out.println("");
    }
}