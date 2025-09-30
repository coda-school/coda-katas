#include "codaBuzz.h"

#include <stddef.h>

const char *coda_word(const int n) {
    if (n < 1) {
        return NULL;
    }
    return "1";
}
