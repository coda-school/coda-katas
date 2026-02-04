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