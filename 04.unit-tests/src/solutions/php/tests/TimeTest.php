<?php

use Kata\Clock;
use Kata\Time;

dataset('times', [
    [20, 'Evening'],
    [6, 'Morning'],
    [13, 'Afternoon'],
    [1, 'Night'],
]);

it('return string for', function (int $hour, string $expectedMessage) {
    $clockMock = Mockery::mock(Clock::class);
    $clockMock->shouldReceive('hour')->andReturn($hour);

    $time = Time::timeOfDay($clockMock);
    expect($time)->toBe($expectedMessage);
})->with('times');
