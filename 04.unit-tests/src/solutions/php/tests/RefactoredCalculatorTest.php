<?php

namespace Tests;

use DivisionByZeroError;
use Kata\Calculator;
use Kata\Operators;
use Kata\UnsupportedOperatorException;

beforeEach(function () {
    $this->calculator = new Calculator();
});

dataset('operations', [
    [9, 3, Operators::ADD, 12],
    [3, 76, Operators::MULTIPLY, 228],
    [9, 3, Operators::DIVIDE, 3],
    [42, 9, Operators::SUBTRACT, 33],
]);

it('supports operations', function (int $a, int $b, string $operator, float|int $expected) {
    expect($this->calculator->calculate($a, $b, $operator))
        ->toBe($expected);
})->with('operations');

it('fails when operator is not supported', function () {
    $this->calculator->calculate(9, 3, 'Modulo');
})->throws(UnsupportedOperatorException::class, 'Unsupported operator Modulo');

it('fails when dividing by zero', function () {
    $this->calculator->calculate(9, 0, Operators::DIVIDE);
})->throws(DivisionByZeroError::class);
