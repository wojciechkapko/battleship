import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static Map<String, Integer> shipTypes = new HashMap<>();

    public static Map<String, Integer> getShipTypes() {
        shipTypes.put("Carrier", 5);
        shipTypes.put("Battleship", 4);
        shipTypes.put("Cruiser", 3);
        shipTypes.put("Submarine", 3);
        shipTypes.put("Destroyer", 2);
        return shipTypes;
    }
}