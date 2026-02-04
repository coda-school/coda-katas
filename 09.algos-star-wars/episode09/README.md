## Episode 9 : Le système Holocron
Les rebelles ont eu une idée brillante : utiliser un vaisseau de reconnaissance pour effectuer un relevé complet des niveaux de Force à travers la galaxie.
Équipé du nouvel instrument de mesure d'énergie de la Force, le `Holocron Quantifier System (HQS)`, le vaisseau a sillonné l'espace en enregistrant des milliers de données…

Mais à leur retour, stupeur : le système de mesure utilise l'ancien langage Jedi que personne ne comprend plus.

Tous les relevés ont été capturés dans le format numérique Jedi du HQS — un système ancien, presque oublié, que toi seul semble capable de déchiffrer.

### Le système de numération HQS
Les anciens Jedi n'utilisaient pas de chiffres classiques, mais une série de symboles gravés dans les holocrons, chacun représentant une valeur spécifique :

| Symbole          | Décimal |
|------------------|---------|
| ⚫ (Côté Obscur)  | -2      |
| ⚪ (Équilibre)    | -1      |
| 0                | 0       |
| ⭐ (Padawan)      | +1      |
| 💫 (Maître Jedi) | +2      |

Le système HQS est basé sur des **puissances de 5**. Ainsi, chaque position correspond à un multiple de 1, 5, 25, 125, 625, etc., exactement comme notre système décimal fonctionne avec les puissances de 10.

**Exemple :**

```
💫⭐0⚪  =  (💫 × 125) + (⭐ × 25) + (0 × 5) + (⚪ × 1)
        =  (2 × 125) + (1 × 25) + (0) + (-1)
        =  250 + 25 - 1 = 274
```

---

### Ta mission
Les rebelles ont extrait du vaisseau un fichier contenant des milliers de mesures HQS, enregistrées pendant le vol : chaque ligne correspondant à une mesure capturée par le capteur HQS.

Ils te demandent ton aide pour déchiffrer les données, et calculer un indicateur clé : **la moyenne décimale** de toutes les mesures relevées.

### Exemple

Voici un exemple de fichier d'entrée avec 5 mesures HQS :

```
💫0
⭐
⚪
⚫
💫⭐⭐
```

**Conversion :**

| HQS  | Décimal |
|------|---------|
| 💫0  | 10      |
| ⭐    | 1       |
| ⚪    | -1      |
| ⚫    | -2      |
| 💫⭐⭐ | 56      |

**Calculs :**
- Somme = `10 + 1 - 1 - 2 + 56 = 64`
- Moyenne = `64 / 5 = 12.8`

**Sortie attendue :** `12.8`

---

### Indices

<details>
<summary>💡 Indice 1 : Comprendre le système en base 5</summary>

Le système HQS fonctionne comme notre système décimal, mais en base 5 :
- Position 0 (la plus à droite) : × 1 (5⁰)
- Position 1 : × 5 (5¹)
- Position 2 : × 25 (5²)
- Position 3 : × 125 (5³)
- etc.

Pour convertir "💫⭐0" :
1. 💫 est à la position 2 → 2 × 25 = 50
2. ⭐ est à la position 1 → 1 × 5 = 5
3. 0 est à la position 0 → 0 × 1 = 0
4. Total : 50 + 5 + 0 = 55
</details>

<details>
<summary>💡 Indice 2 : Mapper les symboles</summary>

Crée d'abord un objet qui associe chaque symbole à sa valeur :

```typescript
const symbolValues: Record<HolocronSymbol, number> = {
    '⚫': -2,
    '⚪': -1,
    '0': 0,
    '⭐': 1,
    '💫': 2
};
```
</details>

<details>
<summary>💡 Indice 3 : Parcourir de droite à gauche</summary>

Pour convertir, parcours la chaîne de droite à gauche :

```typescript
let result = 0;
let position = 0;

for (let i = hqs.length - 1; i >= 0; i--) {
    const symbol = hqs[i] as HolocronSymbol;
    const value = symbolValues[symbol];
    result += value * Math.pow(5, position);
    position++;
}
```
</details>

<details>
<summary>💡 Indice 4 : Calculer la moyenne</summary>

Pour la moyenne :
1. Convertis chaque mesure HQS en décimal
2. Additionne toutes les valeurs
3. Divise par le nombre de mesures

```typescript
const decimals = measurements.map(hqsToDecimal);
const sum = decimals.reduce((acc, val) => acc + val, 0);
return measurements.length > 0 ? sum / measurements.length : 0;
```
</details>

---

### Bonus : Conversion inverse (Décimal → HQS)

Si tu veux aller plus loin, implémente la conversion dans l'autre sens !

```typescript
/**
 * Convertit un nombre décimal en système HQS
 * @param decimal - Nombre en décimal
 * @returns Le nombre au format HQS
 */
export function decimalToHqs(decimal: number): string {
    // TODO: Challenge bonus !
    return '';
}
```

**Exemples :**
- `10` → `"💫0"`
- `56` → `"💫⭐⭐"`
- `-7` → `"⚪⚫"`

Que la Force soit avec toi ! 🌟