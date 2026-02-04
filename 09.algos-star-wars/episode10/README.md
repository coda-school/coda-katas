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