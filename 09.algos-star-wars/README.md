## Algorithmique Wars
![Algorithmique Wars](img/algorithmique-wars.webp)

### Episode 0 : les midichloriens
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

### Episode 3 : le réveil des droïdes
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