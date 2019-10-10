import java.util.List;
import java.util.ArrayList;


public class TurnLogic {

    public static boolean playTurn(Player player, List<Ship> ships) {
        player.shoot(ships);
        return checkIfWon(ships);
    }

    private static boolean checkIfWon(List<Ship> ships) {
        int allShips = 0;
        int shipPartsHit = 0;
        for(Ship ship: ships) {
            for(Square shipPart: ship.getShipElements()){
                allShips++;
                if(shipPart.getCellStatus().equals("hit")){
                    shipPartsHit++;
                }
            }
        }

        if (allShips == shipPartsHit) {
            return true;            
        }
        return false;
    }
}