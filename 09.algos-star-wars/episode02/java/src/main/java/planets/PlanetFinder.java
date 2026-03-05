package planets;

import java.util.List;

public class PlanetFinder {

    public record Planet(String name, List<Planet> satellites) {}

    public static boolean findPlanet(Planet root, String target) {
        // TODO
        return false;
    }
}
