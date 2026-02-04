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