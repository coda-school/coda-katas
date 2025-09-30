#include "codaBuzz.h"

#include <stddef.h>
#include <stdio.h>

#define LOWER_BOUND 1
#define UPPER_BOUND 100

static const char *const CODA = "Coda";
static const char *const BUZZ = "Buzz";
static const char *const CODABUZZ = "CodaBuzz";

const char *number_to_string(const int input) {
    static char buffer[12];
    snprintf(buffer, sizeof(buffer), "%d", input);
    return buffer;
}

int is_out_of_range(const int input) {
    return input < LOWER_BOUND || input > UPPER_BOUND;
}

const char *convert_safely(const int input) {
    if (input % 15 == 0) return CODABUZZ;
    if (input % 3 == 0) return CODA;
    if (input % 5 == 0) return BUZZ;

    return number_to_string(input);
}

const char *convert(const int input) {
    if (is_out_of_range(input)) return NULL;
    return convert_safely(input);
}

const char *convert_with_handler(const int input, ResultHandler handler) {
    const char *result = convert(input);
    if (result != NULL && handler != NULL) {
        handler(result);
    }
    return result;
}
