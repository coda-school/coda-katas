# Test it or Die Tryin (35')

- Le projet de test utilise **Pest** pour PHP.
- Documentation de Pest : [pestphp.com](https://pestphp.com/)

---

## Calculator

### Objectif

- Écrire quelques tests pour la classe `Calculator` en PHP.
    - Identifier les **cas limites (Edge cases)** et écrire des tests pour ceux-ci.

### Code de la classe `Calculator`

```php
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
```

> Vous n'avez pas le droit de changer la moindre ligne du code de production

---

## TimeUtility

### Objectif

- Écrire au moins un test pour la classe `TimeUtility`.
- Identifier le problème lié à l'utilisation de `DateTime`

```php
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
```
