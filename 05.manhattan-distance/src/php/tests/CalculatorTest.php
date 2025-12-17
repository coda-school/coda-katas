<?php

use Kata\Calculator;

const UNIVERSAL_ANSWER = 42;

it('calculate something', function () {
    expect(Calculator::doSomething())->toBe(UNIVERSAL_ANSWER);
});
