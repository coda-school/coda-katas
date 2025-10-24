#include <assert.h>
#include <stdio.h>
#include "calculator.h"

void simple_test(void) {
    assert(doSomething() == 0);
}

int main(void) {
    simple_test();

    printf("✅ All tests ran successfully\n");
    return 0;
}
