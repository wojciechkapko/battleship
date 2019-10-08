import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AiPlayer extends Player {

    // private int difficulty;
    protected Random randomizer;

    public AiPlayer(){
        // this.difficulty = difficulty;
        randomizer = new Random();
        this.createShips();
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
        Map<String, Integer> shipTypes = new HashMap<>();
        shipTypes.put("Carrier", 5);
        shipTypes.put("Battleship", 4);
        shipTypes.put("Cruiser", 3);
        shipTypes.put("Submarine", 3);
        shipTypes.put("Destroyer", 2);
        for(String shipType: shipTypes.keySet()){
            createSingleShip(shipType, shipTypes);
        }
    }

    private void createSingleShip(String shipType, Map<String, Integer> shipTypes){
        boolean wasAdded;
        while(true){
            int[] coordinates = getCooridinates();
            boolean position = getisHorizontal();
            wasAdded = ocean.addShip(coordinates, shipTypes.get(shipType).intValue(), position);
            if(wasAdded){
                break;
            }
        }
    }
}