#include "codaBuzz.h"

#include <stddef.h>
#include <stdio.h>

#define LOWER_BOUND 1
#define UPPER_BOUND 100

static const char *const CODA = "Coda";
static const char *const BUZZ = "Buzz";
static const char *const CODABUZZ = "CodaBuzz";

const char *number_to_string(const int n) {
    static char buffer[12];
    snprintf(buffer, sizeof(buffer), "%d", n);
    return buffer;
}

int is_out_of_range(const int n) {
    return n < LOWER_BOUND || n > UPPER_BOUND;
}

const char *convert_safely(const int n) {
    if (n % 15 == 0) return CODABUZZ;
    if (n % 3 == 0) return CODA;
    if (n % 5 == 0) return BUZZ;

    return number_to_string(n);
}

const char *convert(const int n) {
    if (is_out_of_range(n)) return NULL;
    return convert_safely(n);
}
