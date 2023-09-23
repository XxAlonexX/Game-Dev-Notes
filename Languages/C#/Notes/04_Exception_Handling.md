- Handle exceptions at an appropriate level in your application, considering where you can provide meaningful error messages and recover from errors.
- Avoid catching and swallowing exceptions without appropriate handling or logging.
- Log exceptions for debugging and monitoring purposes.
- Use specific exception types when possible to catch only the expected exceptions.

```cs
using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Welcome to the Guess the Number game!");
        Console.WriteLine("I've selected a number between 1 and 100. Try to guess it.");

        // Generate a random number between 1 and 100.
        Random random = new Random();
        int secretNumber = random.Next(1, 101);

        int attempts = 0;
        bool hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly)
        {
            Console.Write("Enter your guess: ");
            string input = Console.ReadLine();

            if (int.TryParse(input, out int guess))
            {
                attempts++;

                if (guess < secretNumber)
                {
                    Console.WriteLine("Too low! Try again.");
                }
                else if (guess > secretNumber)
                {
                    Console.WriteLine("Too high! Try again.");
                }
                else
                {
                    Console.WriteLine($"Congratulations! You guessed the number {secretNumber} correctly in {attempts} attempts.");
                    hasGuessedCorrectly = true;
                }
            }
            else
            {
                Console.WriteLine("Invalid input. Please enter a valid number.");
            }
        }
    }
}
```
**Here's how the game works:**

1. The computer generates a random number between 1 and 100.
2. The player is prompted to guess the number.
3. The player's input is checked for validity (whether it's a number).
4. If the guess is too low or too high, the player is given a hint.
5. If the player guesses the correct number, they receive a congratulatory message with the number of attempts.