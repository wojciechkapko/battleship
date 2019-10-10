import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AiPlayer extends Player {

    // private int difficulty;
    private Random randomizer;

    public AiPlayer(){
        // this.difficulty = difficulty;
        randomizer = new Random();
        this.createShips();
    }

    // @Override
    // public void attack(int x, int y){
    //     int[] coordinates = new int[2];
    //     coordinates = getCooridinates();
    //     x = coordinates [0];
    //     y = coordinates [1];
    //     super.attack(x, y);
    // }

    public void shoot(List<Ship> ships) {
        playerAttack(ships);
    }

    public boolean playerAttack(List<Ship> ships){
        int[] coordinates = new int[2];
        coordinates = getCooridinates();
        int x = coordinates [0];
        int y = coordinates [1];
        Square cell = opponentBoard[x][y];

        while(cell.getCellStatus().equals("miss") || cell.getCellStatus().equals("hit")){
            coordinates = getCooridinates();
            x = coordinates [0];
            y = coordinates [1];
            cell = opponentBoard[x][y];
        }
        
        if (attack(x, y)){
            return true;
        }
        return false;
    }

    public int[] getCooridinates(){
        int x = randomizer.nextInt(ocean.getBoardLimit());
        int y = randomizer.nextInt(ocean.getBoardLimit());
        int[] coordinates = {x, y};
        return coordinates;
    }

    public boolean getisHorizontal(){
        return randomizer.nextInt(2) != 0;
    }

    private void createShips(){
        Map<String, Integer> shipTypes = Settings.getShipTypes();
        for(String shipType: shipTypes.keySet()){
            createSingleShip(shipType, shipTypes);
        }
    }

    private void createSingleShip(String shipType, Map<String, Integer> shipTypes){
        boolean wasAdded;
        while(true){
            int[] coordinates = getCooridinates();
            boolean position = getisHorizontal();
            wasAdded = ocean.addShip(coordinates, shipTypes.get(shipType).intValue(), position, shipType);
            if(wasAdded){
                break;
            }
        }
    }

    public void printOpponentBoard(){

    }
}