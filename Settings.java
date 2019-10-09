import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static Map<String, Integer> shipTypes = Map.of(
        "Carrier", 5
        // "Battleship", 4,
        // "Cruiser", 3,
        // "Submarine", 3,
        // "Destroyer", 2
    );

    public static Map<String, Integer> getShipTypes() {
        return shipTypes;
    }
}