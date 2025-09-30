# CodaBuzz game
## Objectifs pédagogiques
- Se rappeler ensemble la syntaxe de base en C et le cycle compiler/exécuter. 
- Comprendre l’algorithme à implémenter en discutant et reformulant à deux.
- Développer à l'aide du pair programming, en alternant les rôles de conducteur (driver) et de copilote (navigator).
- Analyser les erreurs et confronter ses raisonnements grâce au dialogue permanent.
- Créer en équipe des variantes de l’algorithme ou de nouveaux tests.
- Identifier les cas de tests / échantilloner.

## Pair Programming
Avant de se lancer, découvrons ensemble ce qu'est le [Pair Programming](../PAIR-PROGRAMMING.md)

## CodaBuzz
Write a function that returns for a given number from 1 to 100 this given number, except that :
- For multiples of 3 returns “Coda”
- For the multiples of 5 returns “Buzz”
- For numbers which are multiples of both 3 and 5 returns “CodaBuzz”

![CodaBuzz](../img/codabuzz.webp)

### Comment faire ?


```shell
# Compiler le programme principal
gcc main.c coda.c -o coda
./coda

# Compiler et lancer les tests
gcc test_coda.c coda.c -o test_coda
./test_coda
```


En **pair** :
- Découvrir la mission de la [semaine 1](https://github.com/coda-school/cahier-de-vacances-b3/blob/main/exercise/week01/docs/MISSION.md)
- Se mettre d'accord sur la stack à utiliser
- Réfléchir comment implémenter la solution
    - Partir du test
- Coder la solution en `Pair Programming` (Driver / Navigator)
    - Changer de rôle toutes les 5 minutes

> Débrief général en fin de session

### Conclusion
- What did you do faster than usual in pair ?
- What did you do slower than usual in pair ?
- How was the communication ?
- What other pros/cons did you discover during this workshop ?

> Pairing help you identify your blindspots
