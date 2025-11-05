#include <assert.h>
#include <stdio.h>
#include "prime.h"

void assert_prime(const int value, const bool expected) {
    const bool result = isPrime(value);
    if (result != expected) {
        fprintf(stderr, "Test failed for value %d\n", value);
    }
    assert(result == expected);
}


void must_not_be_prime(const int value) {
    assert_prime(value, false);
}

void must_be_prime(const int value) {
    assert_prime(value, true);
}


void true_for_prime_numbers(void) {
    must_be_prime(5);
    must_be_prime(7);
    must_be_prime(13);
}

void false_for_not_prime_numbers(void) {

}

void false_for_invalid_numbers(void) {
    must_not_be_prime(0);
    must_not_be_prime(-1);
    must_not_be_prime(-99);
}

int main(void) {
    false_for_invalid_numbers();
    true_for_prime_numbers();
    false_for_not_prime_numbers();

    printf("✅ All tests ran successfully\n");
    return 0;
}
