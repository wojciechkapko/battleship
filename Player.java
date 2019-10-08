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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] coordinates = {x, y};
        return coordinates;
    }
    public boolean getisHorizontal(){
        int decision = scanner.nextInt();
        if (decision == 1){
            return true;
        }
        else if (decision == 2){
            return false;
        }
        return getisHorizontal();
    }
    private void createShips(){
        Map<String, Integer> shipTypes = new HashMap<String, Integer>();
        shipTypes.put();
        shipTypes.put();
        shipTypes.put();
        shipTypes.put();
        shipTypes.put();
        for(String shipType: shipTypes.keySet()){
            int[] coordinates = getCooridinates();
        }
    }


}