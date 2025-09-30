#include "codaBuzz.h"

#include <stddef.h>
#include <stdio.h>

const char *number_to_string(const int n) {
    static char buffer[12];
    snprintf(buffer, sizeof(buffer), "%d", n);
    return buffer;
}

const char *convert(const int n) {
    if (n < 1 || n > 100) {
        return NULL;
    }
    if (n % 3 == 0) return "Coda";
    if (n % 5 == 0) return "Buzz";

    return number_to_string(n);
}
