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

const char *convert_with_handler(const int input, const ResultHandler handler) {
    const char *result = convert(input);
    if (result != NULL && handler != NULL) {
        handler(result);
    }
    return result;
}

const char *convert_without_if(const int input) {
    static const char *possible_results[] = {NULL, BUZZ, CODA, CODABUZZ};

    const int coda = input % 3 == 0;
    const int buzz = input % 5 == 0;

    /*
    *This line combines two boolean values (coda and buzz) into a single integer index using bitwise operations:
        - coda << 1 shifts the value of coda (0 or 1) left by one bit, making it 0 or 2.
        - buzz is 0 or 1.

    The bitwise OR (|) combines them:
        - neither is true: 0 << 1 | 0 → 0
        - only buzz is true: 0 << 1 | 1 → 1
        - only coda is true: 1 << 1 | 0 → 2
        - both are true: 1 << 1 | 1 → 3
    */
    const int index = coda << 1 | buzz; // 0: none, 1: Buzz, 2: Coda, 3: CodaBuzz
    const char *result = possible_results[index];

    return result != NULL ? result : number_to_string(input);
}
