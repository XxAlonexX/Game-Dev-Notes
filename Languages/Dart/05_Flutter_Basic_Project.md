We'll focus on creating a simple Flutter user interface for our game purchasing store. We'll display the game information we've been working with and allow the user to purchase games.
```dart
// main.dart

import 'package:flutter/material.dart';

void main() {
  runApp(GameStoreApp());
}

class Game {
  final String title;
  final int price;
  final bool isAvailable;

  Game(this.title, this.price, this.isAvailable);
}

class GameStoreApp extends StatelessWidget {
  final List<Game> games = [
    Game("Awesome Game 1", 20, true),
    Game("Awesome Game 2", 25, false),
    Game("Awesome Game 3", 15, true),
  ];

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Game Purchasing Store'),
        ),
        body: ListView.builder(
          itemCount: games.length,
          itemBuilder: (context, index) {
            return ListTile(
              title: Text(games[index].title),
              subtitle: Text('Price: \$${games[index].price}'),
              trailing: games[index].isAvailable
                  ? ElevatedButton(
                      onPressed: () {
                        // Add purchase logic here
                        showDialog(
                          context: context,
                          builder: (BuildContext context) {
                            return AlertDialog(
                              title: Text('Purchase Successful'),
                              content: Text(
                                'You have purchased ${games[index].title}',
                              ),
                              actions: [
                                TextButton(
                                  onPressed: () {
                                    Navigator.of(context).pop();
                                  },
                                  child: Text('OK'),
                                ),
                              ],
                            );
                          },
                        );
                      },
                      child: Text('Purchase'),
                    )
                  : Text('Not Available'),
            );
          },
        ),
      ),
    );
  }
}
```
### Code Explanation
- We create a simple Flutter app with a list of games displayed in a `ListView.builder`.
- Each game item includes the title, price, and a "Purchase" button (ElevatedButton) if the game is available.
- When the "Purchase" button is pressed, an AlertDialog is shown to simulate a successful purchase.