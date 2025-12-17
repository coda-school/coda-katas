<?php

use Kata\Calculator;
use Kata\Operators;
use Kata\UnsupportedOperatorException;

it('add : 9 + 3 = 12', function () {
    $calculator = new Calculator();
    $result = $calculator->calculate(9, 3, Operators::ADD);
    $this->assertSame(12, $result);
});

it('multiply : 3 x 76 = 228', function () {
    $calculator = new Calculator();
    $result = $calculator->calculate(3, 76, Operators::MULTIPLY);
    $this->assertSame(228, $result);
});

it('divide : 9 / 3 = 3', function () {
    $calculator = new Calculator();
    $result = $calculator->calculate(9, 3, Operators::DIVIDE);
    $this->assertSame(3, $result);
});

it('subtract : 42 - 9 = 33', function () {
    $calculator = new Calculator();
    $result = $calculator->calculate(42, 9, Operators::SUBTRACT);
    $this->assertSame(33, $result);
});

it('fails when operator is not supported', function () {
    $calculator = new Calculator();
    $calculator->calculate(9, 3, 'Modulo');
})->throws(UnsupportedOperatorException::class, 'Unsupported operator Modulo');
