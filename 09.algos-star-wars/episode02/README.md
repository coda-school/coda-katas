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