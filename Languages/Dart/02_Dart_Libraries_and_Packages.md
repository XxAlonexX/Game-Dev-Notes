Dart provides built-in libraries for various functionalities. In our game store, we can use the `dart:core` library for basic data types and the `dart:io` library for input and output operations.
```dart
// game_store.dart

import 'dart:io';

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
  stdout.write("Enter game title: ");
  String title = stdin.readLineSync() ?? "";
  
  stdout.write("Enter game price: ");
  int price = int.tryParse(stdin.readLineSync() ?? "") ?? 0;
  
  stdout.write("Is the game available? (true/false): ");
  bool isAvailable = (stdin.readLineSync()?.toLowerCase() == "true");

  Game game = Game(title, price, isAvailable);
  game.displayInfo();
}
```
### Code Explanation
- We import the `dart:io` library for input and output operations.
- We use `stdout` to display prompts and `stdin` to read user input.
