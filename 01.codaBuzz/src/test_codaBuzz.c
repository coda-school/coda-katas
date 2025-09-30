#include <assert.h>
#include <string.h>
#include <stdio.h>
#include "codaBuzz.h"

void returns_number_for_classic_ones() {
    assert(strcmp(coda_word(1), "1") == 0);
}

int main(void) {
    returns_number_for_classic_ones();

    printf("✅ All tests ran successfully\n");
    return 0;
}
