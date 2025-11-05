#include <stdbool.h>
#include <tgmath.h>

bool is_prime(const int number) {
    if (number <= 1) return false;

    for (int i = 2; i <= sqrt(number); i++)
        if (number % i == 0) return false;

    return true;
}
