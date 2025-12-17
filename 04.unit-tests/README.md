## Intro aux tests ?**
### **Connect - MythBusters**
In small groups, categorize each sentence about Unit tests in :

- Myth
- Truth

![Mythbusters](img/mythbusters.webp)

### Sentences
- It makes changes more difficult to make
- Using them, I don't have a piece of code that I'm afraid to touch
- Unit tests are only written by testers
- My code is so simple, so I do not need to write a single test on it
- Unit tested code is of higher quality than not tested code
- You only need unit testing when there are many developers
- It reduces the cost of development
- It takes too much time to write

<details>
  <summary markdown='span'>
  Correction
  </summary>

#### Myths
- It makes changes more difficult to make
    - Makes changes easier to make
    - Let developers refactor without fear (again, again, and again)
- Unit tests are only written by testers
    - Usually, they don’t…
    - Developers write unit tests
    - Ideally run them every time they make any change on the system
- My code is so simple, I do not need to write a single test on it
    - Simple code requires simple tests, so there are no excuses.
- You only need unit testing when there are many developers
    - Unit testing can help a one-person team just as much as a 50-person team
    - Even more risky to let a single person hold all the cards
- It takes too much time to write
    - It takes a little while to get used to, but overall will save you time and cut down on wasted time
    - Regression testing will keep things moving forward without having to worry too much
    - `How do you test your development if you do not write Unit tests?`

> Our responsibility is to reduce the cost of quality

#### Facts
- Using them, I don't have a piece of code that I'm afraid to touch
    - When you refactor / add new features it acts as a safety net and increase your confidence
- Unit tested code is of higher quality than not tested one
    - It identifies every defect that may have come up before code is sent further for integration testing
    - Writing tests makes you think harder about the problem
    - It exposes the edge cases and makes you write better code
- It reduces the cost of development
    - Since the bugs are found early, unit testing helps reduce the cost of bug fixes
    - Bugs detected earlier are easier to fix
</details>

### **Concepts**
* Courte explication :
    * But d’un test
    * La [pyramide de tests](https://martinfowler.com/articles/practical-test-pyramid.html)
    * [Quadrant de tests](https://www.all4test.fr/blog-du-testeur/la-methode-agile-et-le-test-logiciel-tous-savoir/)
    * Notion AAA (Arrange–Act–Assert)

![Unit Testing](img/unit-testing.png)
![Good vs Bad Tests](img/good-vs-bad.png)
![What is a Unit Test](img/what-is-unit-test.png)
![Anatomy of Unit Tests](img/anatomy-of-unit-test.png)
![Test Doubles](img/test-doubles.png)

[Infographie "Unit Testing Principles, Practices, and Patterns"](files/Unit%20Testing%20Principles%2C%20Practices%2C%20and%20Patterns.pdf)

### **Concrete Practice**
[“Mon premier test automatisé”](src/php/how-to.md) avec [pest](https://pestphp.com/).

* Bonus : faire échouer volontairement un test.

### **Conclusion**
* Question finale :
  → “Quel type de test a le plus de valeur à ton niveau actuel ? Pourquoi ?”

---