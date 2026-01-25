package fi.metropolia.designpatterns.factory.rpgmapgenerator;

public class Game {

    public static Map createMap(String type) {
        if (type.equalsIgnoreCase("city")) {
            return new CityMap(5, 5);
        } else {
            return new WildernessMap(5, 5);
        }
    }

    public static void main(String[] args) {
        Map map = createMap("city");   // change to "wilderness"
        map.display();
    }
}
