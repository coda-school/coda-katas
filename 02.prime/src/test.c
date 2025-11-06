#include <assert.h>
#include <stdio.h>
#include <time.h>

#include "prime.h"

typedef void (*CallToMeasure)(void);

void assert_prime(const int value, const bool expected) {
    const bool result = is_prime(value);
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

double measureExecutionTimeFor(CallToMeasure procedure) {
    const clock_t start_time = clock();
    procedure();

    return (double) (clock() - start_time) / CLOCKS_PER_SEC;
}

void test_large_prime(void) {
    // Time taken to execute must_be_prime(2147483647): 6.713937 seconds
    // Après optimisation : 0.000335 seconds
    must_be_prime(2147483647);
}

void true_for_prime_numbers(void) {
    must_be_prime(5);
    must_be_prime(7);
    must_be_prime(13);

    printf(
        "Time taken to execute must_be_prime(2147483647): %f seconds\n",
        measureExecutionTimeFor(test_large_prime)
    );
}

void false_for_not_prime_numbers(void) {
    must_not_be_prime(4);
    must_not_be_prime(6);
    must_not_be_prime(12);
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
