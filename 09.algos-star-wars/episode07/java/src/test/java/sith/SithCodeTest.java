package sith;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static sith.SithCode.isSithCode;

@DisplayName("Episode 7: Le Code Sith")
class SithCodeTest {
    @Test
    @DisplayName("detects palindrome codes")
    void detectsPalindromeCodes() {
        assertThat(isSithCode("radar")).isTrue();
        assertThat(isSithCode("kayak")).isTrue();
        assertThat(isSithCode("level")).isTrue();
    }

    @Test
    @DisplayName("detects non-palindrome codes")
    void detectsNonPalindromeCodes() {
        assertThat(isSithCode("sith")).isFalse();
        assertThat(isSithCode("empire")).isFalse();
    }

    @Test
    @DisplayName("handles empty string")
    void handlesEmptyString() {
        assertThat(isSithCode("")).isTrue();
    }

    @Test
    @DisplayName("handles single character")
    void handlesSingleCharacter() {
        assertThat(isSithCode("a")).isTrue();
    }

    @Test
    @DisplayName("ignores spaces and case")
    void ignoresSpacesAndCase() {
        assertThat(isSithCode("A man a plan a canal Panama")).isTrue();
        assertThat(isSithCode("Race Car")).isTrue();
    }
}
