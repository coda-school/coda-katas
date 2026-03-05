package planets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static planets.PlanetFinder.findPlanet;
import static planets.PlanetFinder.Planet;

@DisplayName("Episode 2: L'Arbre des Planetes")
class PlanetFinderTest {

    private final Planet galaxy = new Planet("Coruscant", List.of(
            new Planet("Tatooine", List.of(
                    new Planet("Naboo", List.of(
                            new Planet("Alderaan", List.of())
                    ))
            )),
            new Planet("Hoth", List.of(
                    new Planet("Dagobah", List.of()),
                    new Planet("Endor", List.of())
            )),
            new Planet("Mustafar", List.of(
                    new Planet("Geonosis", List.of())
            ))
    ));

    @Test
    @DisplayName("finds planets in the galaxy")
    void findsPlanetsInTheGalaxy() {
        assertThat(findPlanet(galaxy, "Naboo")).isTrue();
        assertThat(findPlanet(galaxy, "Endor")).isTrue();
        assertThat(findPlanet(galaxy, "Geonosis")).isTrue();
        assertThat(findPlanet(galaxy, "Coruscant")).isTrue();
        assertThat(findPlanet(galaxy, "Hoth")).isTrue();
        assertThat(findPlanet(galaxy, "Tatooine")).isTrue();
        assertThat(findPlanet(galaxy, "Dagobah")).isTrue();
        assertThat(findPlanet(galaxy, "Alderaan")).isTrue();
        assertThat(findPlanet(galaxy, "Mustafar")).isTrue();
        assertThat(findPlanet(galaxy, "Yavin")).isFalse();
    }
}
