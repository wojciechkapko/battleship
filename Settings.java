import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static Map<String, Integer> shipTypes = new HashMap<String, Integer>(){{
        put("Carrier", 5);
        put("Cruiser", 3);
        put("Destroyer", 2);
        put("Submarine", 3);
        put("Battleship", 4);
    }};

    public static Map<String, Integer> getShipTypes() {
        return shipTypes;
    }
}