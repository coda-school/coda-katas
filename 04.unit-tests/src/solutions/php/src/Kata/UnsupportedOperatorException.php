<?php

namespace Kata;

use Exception;

class UnsupportedOperatorException extends Exception
{
    public function __construct(string $string)
    {
        parent::__construct($string);
    }
}
