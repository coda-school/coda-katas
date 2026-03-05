package droids;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Episode 3: Le Reveil des Droides")
class DroidStackTest {

    @Test
    @DisplayName("manages droids correctly")
    void managesDroidsCorrectly() {
        DroidStack stack = new DroidStack();
        String[] droids = {"R2D2", "C3PO", "BB8", "K2SO", "IG-88", "D-O", "Chopper", "L3-37", "BD-1", "HK-47"};
        for (String droid : droids) {
            stack.push(droid);
        }

        assertThat(stack.pop()).isEqualTo("HK-47");
        assertThat(stack.pop()).isEqualTo("BD-1");
        assertThat(stack.pop()).isEqualTo("L3-37");
    }

    @Test
    @DisplayName("returns null when no droid")
    void returnsNullWhenNoDroid() {
        DroidStack stack = new DroidStack();
        assertThat(stack.pop()).isNull();
    }
}
