# Calcul de prix
Générer une chaine de caractères avec le prix total à partir des informations suivantes :
- Nombre d'articles
- Prix unitaire
- Taxe en % (voir exemple)

Exemples chiffrées :
- 3 articles à 1,21 € et taxe 0 % → “3.63 €”
- 3 articles à 1,21 € et taxe 5 % → “3.81 €”
- 3 articles à 1,21 € et taxe 20 % → “4.36 €”

Puis on ajoute des réductions si le prix total HT dépasse un seuil :
- 1000 € → Remise 3% :
    - Ex : 5 x 345,00 € + taxe 10% → “1840.58 €”
- 5000 € → Remise 5% :
    - Ex : 5 x 1299,00 € + taxe 10% → “6787.28 €”

⚠️ Pour les remises, il n'y a pas besoin d'ajouter de paramètres d'entrée puisque c'est basé sur le prix total HT !

Pour compiler et exécuter :

```shell
gcc calculator.c -o calculator
gcc tests.c calculator.c -o tests
```

## Vidéo (résolution)
[![Pricing Kata on Youtube](img/pricing-kata-challenge.png)](https://youtu.be/v0xUUKDYUt0)

## Example Mapping
![Example mapping](img/example-mapping.jpg)

Détails à retrouver sur miro [ici](https://miro.com/app/board/uXjVM706BBU=/?share_link_id=431682749138).