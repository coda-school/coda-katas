#include <assert.h>
#include <limits.h>
#include <math.h>
#include <string.h>
#include <stdio.h>

#include "codaBuzz.h"

void assert_out_of_range_for(const int value) {
    assert(convert(value) == NULL);
}

void out_of_range_for_negative_numbers(void) {
    assert_out_of_range_for(-1);
    assert_out_of_range_for(0);
    assert_out_of_range_for(INT_MIN);
}

void out_of_range_for_numbers_gt_100(void) {
    assert_out_of_range_for(101);
}

void assert_conversion(const int value, const char *expectedValue) {
    const char *result = convert(value);
    if (strcmp(result, expectedValue) != 0) {
        fprintf(stderr, "Test failed for value %d: expected '%s', got '%s'\n", value, expectedValue, result);
    }
    assert(strcmp(result, expectedValue) == 0);
}

void number_for_classic_ones(void) {
    assert_conversion(1, "1");
    assert_conversion(16, "16");
    assert_conversion(91, "91");
}

void coda_for_multiples_of_3(void) {
    assert_conversion(3, "Coda");
    assert_conversion(63, "Coda");
    assert_conversion(81, "Coda");
}

void buzz_for_multiples_of_5(void) {
    assert_conversion(5, "Buzz");
    assert_conversion(50, "Buzz");
    assert_conversion(85, "Buzz");
}

void coda_buzz_for_multiples_of_3_and_5(void) {
    assert_conversion(15, "CodaBuzz");
    assert_conversion(45, "CodaBuzz");
    assert_conversion(90, "CodaBuzz");
}

int main(void) {
    out_of_range_for_negative_numbers();
    out_of_range_for_numbers_gt_100();

    number_for_classic_ones();
    coda_for_multiples_of_3();
    buzz_for_multiples_of_5();
    coda_buzz_for_multiples_of_3_and_5();

    printf("✅ All tests ran successfully\n");
    return 0;
}
