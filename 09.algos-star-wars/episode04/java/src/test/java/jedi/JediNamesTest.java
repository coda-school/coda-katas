package jedi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static jedi.JediNames.uniqueJediNames;

@DisplayName("Episode 4: L'Unicite de la Force")
class JediNamesTest {

    @Test
    @DisplayName("removes duplicate Jedi names")
    void removesDuplicateJediNames() {
        assertThat(uniqueJediNames(new String[]{"Luke", "Yoda", "Luke", "Obi-Wan", "Yoda"}))
                .containsExactly("Luke", "Yoda", "Obi-Wan");
    }

    @Test
    @DisplayName("handles empty array")
    void handlesEmptyArray() {
        assertThat(uniqueJediNames(new String[]{})).isEmpty();
    }

    @Test
    @DisplayName("handles array with no duplicates")
    void handlesArrayWithNoDuplicates() {
        assertThat(uniqueJediNames(new String[]{"Luke", "Yoda", "Obi-Wan"}))
                .containsExactly("Luke", "Yoda", "Obi-Wan");
    }

    @Test
    @DisplayName("handles array with all same names")
    void handlesArrayWithAllSameNames() {
        assertThat(uniqueJediNames(new String[]{"Yoda", "Yoda", "Yoda"}))
                .containsExactly("Yoda");
    }
}
