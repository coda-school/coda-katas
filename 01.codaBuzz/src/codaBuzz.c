#include "codaBuzz.h"

#include <stddef.h>
#include <stdio.h>

const int lowerBound = 1;
const int greaterBound = 100;

const char *number_to_string(const int n) {
    static char buffer[12];
    snprintf(buffer, sizeof(buffer), "%d", n);
    return buffer;
}

int is_out_of_range(const int n) {
    return n < lowerBound || n > greaterBound;
}

const char *convert(const int n) {
    if (is_out_of_range(n)) {
        return NULL;
    }
    if (n % 15 == 0) return "CodaBuzz";
    if (n % 3 == 0) return "Coda";
    if (n % 5 == 0) return "Buzz";

    return number_to_string(n);
}
