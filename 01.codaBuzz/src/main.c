#include <stdio.h>
#include <stdlib.h>

#include "codaBuzz.h"

// for MacOS
void speak(const char *text) {
    char cmd[1024];
    snprintf(cmd, sizeof(cmd), "say \"%s\"", text);
    system(cmd);
}

int main(void) {
    for (int i = 1; i <= 100; i++) {
        printf("%s ", convert_with_handler(i, speak));
    }
    printf("\n");
    return 0;
}
