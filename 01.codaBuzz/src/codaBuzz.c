#include "codaBuzz.h"

#include <stddef.h>
#include <stdio.h>

const char *coda_word(const int n) {
    if (n < 1 || n > 100) {
        return NULL;
    }
    static char buffer[12];
    snprintf(buffer, sizeof(buffer), "%d", n);
    return buffer;
}
