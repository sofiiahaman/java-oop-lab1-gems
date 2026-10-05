# Gems Collection
A Java project for working with a collection of gemstones and creating a necklace.

## Description
The program allows you to:
* create precious and semi-precious gemstones;
* add and remove gemstones from a necklace;
* calculate total weight and value;
* sort gemstones by value;
* find gemstones by transparency range.

## Project Structure
```text
src
├── main
│   └── java
│       └── com.university.lab1.gems
│           ├── Main.java
│           ├── collection
│           │   └── Necklace.java
│           └── model
│               ├── ClarityGrade.java
│               ├── Gemstone.java
│               ├── GemstoneType.java
│               ├── PreciousGemstone.java
│               └── SemiPreciousGemstone.java
│
└── test
    └── java
        └── com.university.lab1.gems
            ├── collection
            │   └── NecklaceTest.java
            └── model
                ├── GemstoneTest.java
                ├── PreciousGemstoneTest.java
                └── SemiPreciousGemstoneTest.java
```

## OOP
The project demonstrates:
* **Encapsulation** - private fields and public methods.
* **Inheritance** - `PreciousGemstone` and `SemiPreciousGemstone` extend `Gemstone`.
* **Polymorphism** - different gemstone types implement their own behavior.
* **Abstraction** - `Gemstone` is an abstract class.

## Technologies
* Java
* JUnit 5
* IntelliJ IDEA

## Testing
The project contains unit tests for:
* gemstone validation and calculations;
* precious and semi-precious gemstones;
* necklace operations;
* sorting by value;
* transparency filtering;
* equality and string representation.

Run all tests from IntelliJ IDEA by right-clicking the test package and selecting Run Tests.

## Running the Program
Run `Main.java` to see an example of creating gemstones, adding them to a necklace, calculating their total weight and value, sorting them, and filtering them by transparency.