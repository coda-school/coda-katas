<?php

namespace Kata;

class Calculator
{
    private array $supportedOperators;

    public function __construct()
    {
        $this->supportedOperators = [
            Operators::ADD => fn($a, $b) => $a + $b,
            Operators::MULTIPLY => fn($a, $b) => $a * $b,
            Operators::DIVIDE => fn($a, $b) => $a / $b,
            Operators::SUBTRACT => fn($a, $b) => $a - $b,
        ];
    }

    /**
     * @throws UnsupportedOperatorException
     */
    public function calculate($a, $b, $operator): mixed
    {
        return !array_key_exists($operator, $this->supportedOperators)
            ? throw new UnsupportedOperatorException("Unsupported operator {$operator}")
            : $this->supportedOperators[$operator]($a, $b);
    }
}
