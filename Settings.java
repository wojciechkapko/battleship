import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static Map<String, Integer> shipTypes = new HashMap<String, Integer>(){{
        put("Carrier", 1);
        // "Battleship", 4,
        // "Cruiser", 3,
        // "Submarine", 3,
        // "Destroyer", 2
    }};

    public static Map<String, Integer> getShipTypes() {
        return shipTypes;
    }
}