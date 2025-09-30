#include <assert.h>
#include <string.h>
#include <stdio.h>
#include "codaBuzz.h"

void out_of_range_for_negative_numbers(void) {
    assert(coda_word(-1) == NULL);
}

void returns_number_for_classic_ones(void) {
    assert(strcmp(coda_word(1), "1") == 0);
}

int main(void) {
    out_of_range_for_negative_numbers();
    returns_number_for_classic_ones();

    printf("✅ All tests ran successfully\n");
    return 0;
}
