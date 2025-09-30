#include <stdio.h>

#include "codaBuzz.h"

int main(void) {
    for (int i = 1; i <= 100; i++) {
        printf("%s ", convert(i));
    }
    printf("\n");
    return 0;
}
