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