## Algorithmique Wars
![Algorithmique Wars](img/algorithmique-wars.webp)

### Episode 0 : les Midichloriens
Chaque Jedi a un nombre de midichloriens.

Tu reçois une **liste simple** de Jedi.
Ta mission : calculer le total.

## Pièges
- Tableau vide
- Un seul élément

```typescript
it("sums all midichlorians", () => {
    expect(totalMidichlorians([
        { name: "Luke", midichlorians: 8000 },
        { name: "Yoda", midichlorians: 12000 }
    ])).toBe(20000);
});
```

### Episode 1 : la puissance de Skywalker
Chaque Jedi peut avoir des apprentis.
Cela forme un **arbre**.

Tu dois calculer le total des midichloriens dans toute la lignée.
Tu dois utiliser la `récursivité`.

> Certains Jedi ont 0 enfant

```typescript
export type Jedi = {
    name: string
    power: number
    children: Jedi[]
}

export function skywalkerPower(root: Jedi): number {
    // TODO
    return 0;
}
```

### Episode 2 : l'arbre des planètes
Parcourir un arbre de planètes et vérifier si une planète existe.

```typescript
const galaxy: Planet = {
    name: "Coruscant",
    satellites: [
        { name: "Tatooine", satellites: [{ name: "Naboo", satellites: [] }, { name: "Alderaan", satellites: [] }] },
        { name: "Hoth", satellites: [{ name: "Dagobah", satellites: [] }, { name: "Endor", satellites: [] }] },
        { name: "Mustafar", satellites: [{ name: "Geonosis", satellites: [] }] }
    ]
}
```

Si on appelle `pop` sur une pile vide elle doit retourner `undefined`.

### Episode 3 : le réveil des Droïdes
L’Alliance Rebelle gère un hangar de droïdes.
Les droïdes arrivent pour être réparés, mais ils doivent être traités dans l’ordre inverse de leur arrivée.

Le dernier droïde arrivé est toujours le premier à repartir.

Ce type de structure est appelé une `pile` (stack).

Tu dois implémenter une structure de données appelée `DroidStack` qui fonctionne comme une pile (`LIFO – Last In, First Out`).
Elle permettra de gérer les droïdes stockés dans le hangar.

```typescript
push(object: Object)
pop()
```

Si on appelle `pop` sur une pile vide elle doit retourner `undefined`.

### Episode 4 : L'Unicité de la Force
Dans l'Ordre Jedi, chaque nom de Jedi doit être unique. Malheureusement, les archives ont été corrompues et contiennent des doublons.

Ta mission : éliminer les doublons et retourner la liste des noms uniques de Jedi.

```typescript
export function uniqueJediNames(names: string[]): string[] {
    return [];
}
```

### Episode 5 : Le Recensement Galactique
Le Sénat Galactique doit compter combien de fois chaque planète apparaît dans les rapports de voyage.
Ta mission : compter les occurrences de chaque planète.

```typescript
export function countPlanets(planets: string[]): Record<string, number> {
    return {};
}
```

### Episode 6 : La Séquence des Clones
Les clones sont produits selon une séquence mathématique ancienne : la `suite de Fibonacci`.

> Chaque génération de clones = somme des deux générations précédentes.

Ta mission : générer les `n` premiers nombres de la séquence de Fibonacci.

**Séquence :** 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...

```typescript
export function cloneSequence(n: number): number[] {
    return [];
}
```

### Episode 7 : Le Code Sith
Les Sith utilisent des codes secrets qui se lisent de la même manière dans les deux sens (palindromes).
Ta mission : vérifier si un code est un palindrome en utilisant la `récursivité`.

**Exemples de palindromes :** "radar", "kayak", "level"

```typescript
export function isSithCode(code: string): boolean {
    // TODO: Vérifier récursivement si c'est un palindrome
    return false;
}
```

### Episode 8 : La Transmission Droïde
Les droïdes communiquent en utilisant une suite pour `crypter` leurs messages.

Exemples : 
```text
1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
...
```

Ta mission : 
- comprendre cette `suite`
- générer le n-ième terme

```typescript
export function droidTransmission(n: number): string {
    // TODO: Générer le n-ième terme
    return "";
}
```

### Episode 9 : Les Routes de l'Hyperespace
Les vaisseaux utilisent un réseau de routes hyperspatiales connectant les planètes.

Ce réseau forme un `graphe`. Tu dois vérifier si une planète est accessible depuis une autre en utilisant un parcours en profondeur (`DFS`).

Explications [ici](https://fr.wikipedia.org/wiki/Algorithme_de_parcours_en_profondeur).

**Structure du graphe :**
```typescript
export type HyperspaceNetwork = {
    [planet: string]: string[]  // planète → liste des planètes connectées
}
```

Ta mission : implémenter une recherche `DFS` pour trouver un chemin entre deux planètes.

```typescript
export function canReach(
    network: HyperspaceNetwork,
    start: string,
    destination: string
): boolean {
    // TODO: Utiliser DFS pour vérifier si destination est accessible depuis start
    return false;
}
```
