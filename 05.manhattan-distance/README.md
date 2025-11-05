## Distance de Manhattan
Vous travaillez pour une entreprise de logistique qui souhaite optimiser les trajets de ses livreurs en ville. 

Contrairement à la distance "à vol d'oiseau", les livreurs ne peuvent se déplacer **que selon les axes des rues** (horizontalement ou verticalement), comme sur un damier.

Votre mission : **calculer la distance réelle parcourue par un livreur** entre deux points de livraison, en utilisant la **distance de Manhattan**.

![manhattan.webp](img/manhattan.webp)

### **Besoin Métier**
1. **Calculer la distance entre deux points** :
   - Un livreur part du point A (coordonnées : `x1`, `y1`).
   - Il doit rejoindre le point B (coordonnées : `x2`, `y2`).
   - La distance est la **somme des déplacements horizontaux et verticaux** (sans diagonale).

2. **Exemples concrets** :
   - Entre `(1, 2)` et `(4, 6)` : le livreur parcourt **3 blocs horizontaux** et **4 blocs verticaux** → **7 blocs au total**.
   - Entre `(0, 0)` et `(3, 4)` : **7 blocs**.
   - Si les deux points sont identiques (ex : `(5, 5)` et `(5, 5)`), la distance est **0** (pas de déplacement).

3. **Cas d’usage** :
   - Afficher la distance à un livreur avant qu’il ne parte.
   - Estimer le temps de trajet en fonction de la distance (1 bloc = 1 minute).

### **Exigences**
- Le calcul doit être **rapide et précis** (pas d’approximation).
- La solution doit fonctionner pour **toutes les coordonnées entières** (positives ou négatives).
- Aucune diagonale n’est autorisée : seuls les déplacements **horizontaux** et **verticaux** comptent.

### **Exemples de Scénarios**

| Point A  | Point B  | Distance de Manhattan | Explication               |
|----------|----------|-----------------------|---------------------------|
| (1, 2)   | (4, 6)   | 7                     | 4-1 + 6-2 = 3 + 4 = 7     |
| (0, 0)   | (3, 4)   | 7                     | 3-0 + 4-0 = 3 + 4 = 7     |
| (5, 5)   | (5, 5)   | 0                     | Pas de déplacement.       |
| (-2, 3)  | (1, -1)  | 7                     | 1- -2 + -1-3 = 3 + 4 = 7  |

---

#### **Extensions (pour aller plus loin)**
- **Afficher le trajet** : Proposez une liste des déplacements (ex : "3 blocs à droite, 4 blocs en haut").
- **Optimisation** : Si plusieurs points de livraison sont donnés, calculez le trajet total entre tous les points dans l’ordre.