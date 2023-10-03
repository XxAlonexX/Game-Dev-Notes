# Error Handling
We can add error handling to ensure that the user enters a valid price.
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
  
  int? price;
  while (price == null) {
    stdout.write("Enter game price (numeric value): ");
    try {
      price = int.parse(stdin.readLineSync() ?? "");
    } catch (e) {
      print("Invalid input. Please enter a numeric value.");
    }
  }
  
  stdout.write("Is the game available? (true/false): ");
  bool isAvailable = (stdin.readLineSync()?.toLowerCase() == "true");

  Game game = Game(title, price, isAvailable);
  game.displayInfo();
}
```
### Code Explanation
- We use a `while` loop to repeatedly prompt the user until a valid price is entered.
- We catch exceptions if the user enters a non-numeric value.
# Asynchronous Programming
In our game purchasing store, we may want to fetch game information from a remote server, which involves asynchronous operations. Let's simulate this using Dart's `Future` and `async/await`:
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

Future<void> fetchGameInfo() async {
  await Future.delayed(Duration(seconds: 2)); // Simulate a network request delay
  return Game("Awesome Game", 20, true); // Simulated game data
}

void main() async {
  stdout.write("Fetching game information... ");

  try {
    Game game = await fetchGameInfo();
    game.displayInfo();
  } catch (e) {
    print("Error: Failed to fetch game information.");
  }
}
```
### Code Explanation
- We create a `fetchGameInfo` function that simulates fetching game information from a server with a delay using `Future.delayed`.
- We use the `async` and `await` keywords to handle asynchronous operations gracefully.
- We handle errors using a `try-catch` block.
