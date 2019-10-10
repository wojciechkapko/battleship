import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;


public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(){
        scanner = new Scanner(System.in);
        this.createShips();
    }

    public int[] getCooridinates(){
        System.out.println("---------------------------");
        System.out.println("Input coordinates:");
        System.out.println("---------------------------");
        int x = getCoordinate("X: ");
        int y = getCoordinate("Y: ");
        int[] coordinates = {x, y};
        return coordinates;
    }

    private int getCoordinate(String prompt) {
        System.out.print(prompt);
        String x = scanner.next().strip();
        int coordinate = 0;
        try {
            coordinate = Integer.parseInt(x);
            if(coordinate > 10 || coordinate < 1 ){
                System.out.println("Blimey! I dont understand, Did ye have too much rum?");
                getCoordinate(prompt);
            }
        } catch (NumberFormatException e) {
            System.out.println("Blimey! I dont understand, Did ye have too much rum?");
            getCoordinate(prompt);
        }

        return coordinate-1;
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
        System.out.println("Sail ho! I dont understand, Did ye have too much rum?");
        return getisHorizontal();
    }


    public void shoot(List<Ship> ships) {
        System.out.println("Alas! Aim thee cannons!");
        playerAttack(ships);
    }

    public boolean playerAttack(List<Ship> ships){
        int[] coordinates = new int[2];
        coordinates = getCooridinates();
        int x = coordinates [0];
        int y = coordinates [1];
        Square cell = opponentBoard[x][y];

        while(cell.getCellStatus().equals("miss") || cell.getCellStatus().equals("hit")){
            System.out.println("Alas! We hav alreeady attacked this coordinate.");
            coordinates = getCooridinates();
            x = coordinates [0];
            y = coordinates [1];
            cell = opponentBoard[x][y];
        }

        if (attack(x, y)){
            System.out.println("\nArr! We got them\n");
            isShipDestroyed(cell, ships);
            return true;
        }
        System.out.println("\nBlimey! we missed!\n");
        return false;
    }

    private void isShipDestroyed(Square cell, List<Ship> ships){
        int count = 0;
        for(Ship ship: ships){
            for (Square element: ship.getShipElements()){
                if(element == cell){
                    for(Square shipElement: ship.getShipElements()){
                        if (shipElement.getCellStatus().equals("hit")){
                            count++;
                        }
                    }
                    if (count == ship.getShipElements().length){
                        System.out.println(ship.getName()+" destroyed");
                    }
                }
            }
        }
        

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
        System.out.println("Arr! Direct thee " + shipType + " (Size - " + shipTypes.get(shipType) + ")");
        boolean wasAdded;
        while(true){
            int[] coordinates = getCooridinates();
            boolean position = getisHorizontal();
            wasAdded = ocean.addShip(coordinates, shipTypes.get(shipType).intValue(), position, shipType);
            if(wasAdded)
                break;
            else
                System.out.println("No quarter! Ye cannot haven it thar.");
        }
    }

    public void printOpponentBoard(){
        ocean.printYAxis();
        for(int x = 0; x < ocean.getBoardLimit(); x++){
            ocean.printXAxis(x);
            for(int y = 0; y < ocean.getBoardLimit(); y++){
                Square boardSquare = getOpponentBoard()[x][y];
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