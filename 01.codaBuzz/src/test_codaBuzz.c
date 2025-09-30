#include <assert.h>
#include <limits.h>
#include <string.h>
#include <stdio.h>

#include "codaBuzz.h"

void assertOutOfRangeFor(const int value) {
    assert(coda_word(value) == NULL);
}

void out_of_range_for_negative_numbers(void) {
    assertOutOfRangeFor(-1);
    assertOutOfRangeFor(0);
    assertOutOfRangeFor(INT_MIN);
}

void out_of_range_for_numbers_gt_100(void) {
    assertOutOfRangeFor(101);
}

void returns_number_for_classic_ones(void) {
    assert(strcmp(coda_word(1), "1") == 0);
    assert(strcmp(coda_word(16), "16") == 0);
}

int main(void) {
    out_of_range_for_negative_numbers();
    out_of_range_for_numbers_gt_100();
    returns_number_for_classic_ones();

    printf("✅ All tests ran successfully\n");
    return 0;
}
