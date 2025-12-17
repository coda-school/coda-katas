<?php

namespace Kata;

class Time
{
    public static function timeOfDay(Clock $clock): string
    {
        $hour = $clock->hour();

        return match (true) {
            $hour >= 0 && $hour < 6 => 'Night',
            $hour >= 6 && $hour < 12 => 'Morning',
            $hour >= 12 && $hour < 18 => 'Afternoon',
            default => 'Evening',
        };
    }
}