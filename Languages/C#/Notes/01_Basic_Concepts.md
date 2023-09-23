>In C#, variables are used to store and manage data in your programs. Data types define the kind of data a variable can hold.
# Variables & Datatypes
## Variables
- A variable is a symbolic name for a value in your program's memory.
- You declare variables using a data type followed by a variable name
```Cs
int age; // Declares an integer variable named 'age.'
```
## Data Types
- **Integers:**
    
    - `int`: Represents whole numbers (e.g., -5, 0, 42).
    - `long`: Used for large integer values.
    - `short` and `byte`: For smaller integer values with limited range.
- **Floating-Point Numbers:**
    
    - `float`: Represents single-precision floating-point numbers.
    - `double`: Represents double-precision floating-point numbers (commonly used).
    - `decimal`: Used for financial calculations where precision is essential.
- **Text:**
    
    - `char`: Represents a single character (e.g., 'A', '1').
    - `string`: Represents a sequence of characters (text).
- **Boolean:**
    
    - `bool`: Represents a binary value, either `true` or `false`.
- **Other Data Types:**
    
    - `DateTime`: Represents dates and times.
    - `enum`: Used to define a set of named integer constants.
    - `object`: The base type for all types in C# (used for generalization).
## Variable Initialization
```cs
int score = 100; // Initializes 'score' with the value 100.
```
## Type Interface (var)
C# supports type inference using the `var` keyword. The compiler determines the data type based on the assigned value:
```cs
var playerName = "Alice"; // 'playerName' is inferred as a string.
```
## Constance 
You can declare constants using the `const` keyword. Constants have fixed values that cannot be changed during program execution:
```cs
const double PI = 3.14159265359;
```
# Operators

>Operators are symbols or keywords that perform operations on variables and values. C# supports various types of operators for different purposes.
## Arithmetic Operators
Arithmetic operators perform mathematical operations on numeric values:

- `+` (Addition)
- `-` (Subtraction)
- `*` (Multiplication)
- `/` (Division)
- `%` (Modulus, returns the remainder)
```cs
int x = 10;
int y = 5;
int result = x + y; // 'result' will be 15.
```
## Comparison Operators
Comparison operators are used to compare values and return a Boolean result (`true` or `false`):

- `==` (Equal to)
- `!=` (Not equal to)
- `<` (Less than)
- `>` (Greater than)
- `<=` (Less than or equal to)
- `>=` (Greater than or equal to)
```cs
int a = 7;
int b = 5;
bool isGreaterThan = a > b; // 'isGreaterThan' will be true.
```
## Logical Operators
Logical operators perform logical operations on Boolean values:

- `&&` (Logical AND)
- `||` (Logical OR)
- `!` (Logical NOT)
```cs
bool hasMoney = true;
bool hasTime = false;
bool canGoShopping = hasMoney && !hasTime; // 'canGoShopping' will be true.
```
## Assignment Operators
Assignment operators are used to assign values to variables:

- `=` (Assignment)
- `+=` (Add and assign)
- `-=` (Subtract and assign)
- `*=` (Multiply and assign)
- `/=` (Divide and assign)
```cs
int count = 10;
count += 5; // 'count' will be 15.
```
## Increment and Decrement Operators 
Increment and decrement operators change the value of a variable by 1:

- `++` (Increment)
- `--` (Decrement)
```cs
int counter = 5;
counter++; // 'counter' will be 6.
```
## Ternary Operator (Conditional Operator)
The ternary operator (`? :`) is a shorthand way to write an `if-else` statement in a single line:
```cs
int age = 18;
string message = (age >= 18) ? "Adult" : "Minor";
```
# Control Flow in C# 
Control flow refers to the order in which statements are executed in a program. In C#, you can control the flow of your program's execution using various control structures.
## Conditional Statements
- **if Statement:** The `if` statement is used for conditional branching. It executes a block of code if a specified condition is true.
```cs
int age = 20;
if (age >= 18)
{
    Console.WriteLine("You are an adult.");
}
```
- **if-else Statement:** The `if-else` statement allows you to execute different code blocks based on a condition.
```cs
int score = 75;
if (score >= 60)
{
    Console.WriteLine("You passed.");
}
else
{
    Console.WriteLine("You failed.");
}
```
- **switch Statement:** The `switch` statement is used for multi-branching based on the value of an expression.
```cs
char grade = 'B';
switch (grade)
{
    case 'A':
        Console.WriteLine("Excellent!");
        break;
    case 'B':
        Console.WriteLine("Good job!");
        break;
    default:
        Console.WriteLine("Try harder next time.");
        break;
}
```
## Looping Statement
- **for Loop:** The `for` loop is used for executing a block of code a specific number of times.
```cs
for (int i = 0; i < 5; i++)
{
    Console.WriteLine("Iteration " + i);
}
```
- **while Loop:** The `while` loop executes a block of code as long as a specified condition is true.
```cs
int count = 0;
while (count < 3)
{
    Console.WriteLine("Count: " + count);
    count++;
}
```
- **do-while Loop:** The `do-while` loop is similar to the `while` loop, but it guarantees that the block of code is executed at least once.
```cs
int num = 5;
do
{
    Console.WriteLine("Number: " + num);
    num--;
} while (num > 0);
```
## Jump Statements
- **break:** The `break` statement is used to exit a loop or switch statement prematurely.
- **continue:** The `continue` statement skips the remaining code in the current iteration of a loop and continues to the next iteration.
## Conditional Ternary Operator
![[#Ternary Operator (Conditional Operator)]]

```cs
// Example Code
using System;

public class Example{

    static public void Main (){

        string input = Console.ReadLine();
        // Check if the input is a valid integer value.

        if (Int32.TryParse(input, out int gameCount))

        {

            Console.WriteLine("Your game count is: " + gameCount);

        }

        else

        {

            Console.WriteLine("Invalid input. Please enter an integer value.");

        }

    }

}

```