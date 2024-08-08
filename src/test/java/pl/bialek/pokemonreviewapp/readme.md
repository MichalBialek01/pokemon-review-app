It is a good practise to have high code coverage, and test the most important, and sensitive fragments of code.
In this projects tests are excessive, and often writen for educational purposes. 

Test convention:
BDD - Behavior-driven development (given-when-then convention) 

Tests naming convention:

(tested-service/repository/code)_(method)_(expected_result)

ex. 
```
PokemonRepository_SaveAll_ReturnsSavedPokemon()
```
Type convention: camelCase

Used frameworks:
* AssertJ
* JUnit 5 

Testing database: 
* H2 embedded database 
* (testcontainers in future)