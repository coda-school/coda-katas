package skywalker;

import java.util.List;

public class SkywalkerPower {

    public record Jedi(String name, int power, List<Jedi> children) {}

    public static int skywalkerPower(Jedi root) {
        // TODO
        return 0;
    }
}
