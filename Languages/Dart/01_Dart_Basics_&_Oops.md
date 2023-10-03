# Dart Language Basics
In Dart, you start by defining your variables and writing the core logic of application.
Let's create a Dart file called `game_store.dart`
```dart
// game_store.dart

void main() {
  // Variables
  String gameTitle = "Awesome Game";
  int gamePrice = 20;
  bool isGameAvailable = true;

  // Printing variables
  print("Game Title: $gameTitle");
  print("Game Price: \$$gamePrice");
  print("Is Game Available: $isGameAvailable");
}
```
### Code Explanation
- We declare variables for the game title, price, and availability.
- We use the `print` function to display information in the console.
# Object Oriented Programming
In the context of a game store, we can create a `Game` class to represent games with properties like title, price, and availability.
```dart
// game_store.dart

class Game {
  String title;
  int price;
  bool isAvailable;

  Game(this.title, this.price, this.isAvailable);

  void displayInfo() {
    print("Game Title: $title");
    print("Game Price: \$$price");
    print("Is Game Available: $isAvailable");
  }
}

void main() {
  Game game = Game("Awesome Game", 20, true);
  game.displayInfo();
}
```
### Code Explanation
- We define a `Game` class with properties and a constructor.
- We create an instance of the `Game` class and call the `displayInfo` method to print game information.