<?php

namespace Kata;

use DateTime;

class Time
{
    public static function timeOfDay(): string
    {
        $hour = (int)(new DateTime())->format('H');

        return match (true) {
            $hour >= 0 && $hour < 6 => 'Night',
            $hour >= 6 && $hour < 12 => 'Morning',
            $hour >= 12 && $hour < 18 => 'Afternoon',
            default => 'Evening',
        };
    }
}
