package clones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static clones.CloneSequence.cloneSequence;

@DisplayName("Episode 6: La Sequence des Clones")
class CloneSequenceTest {
    @Test
    @DisplayName("generates first 10 Fibonacci numbers")
    void generatesFirst10FibonacciNumbers() {
        assertThat(cloneSequence(10))
                .containsExactly(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
    }

    @Test
    @DisplayName("handles n = 0")
    void handlesN0() {
        assertThat(cloneSequence(0))
                .isEmpty();
    }

    @Test
    @DisplayName("handles n = 1")
    void handlesN1() {
        assertThat(cloneSequence(1))
                .containsExactly(0);
    }

    @Test
    @DisplayName("handles n = 2")
    void handlesN2() {
        assertThat(cloneSequence(2))
                .containsExactly(0, 1);
    }

    @Test
    @DisplayName("handles larger sequence")
    void handlesLargerSequence() {
        assertThat(cloneSequence(15))
                .containsExactly(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377);
    }
}
