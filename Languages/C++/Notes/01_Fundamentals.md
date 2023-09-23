# Variables/Datatypes/Operators
## Variables
- Variables are used to store data in program
- They have a name (an identifier) and a data type that specifies what kind of data they can hold.
- C++ is case-sensitive, so `myVariable` and `myvariable` are considered different variables.

```Cpp
int age; // Declaring an integer variable named 'age'
double price; // Declaring a double variable named 'price'
```

## Data Types
- Data types define the type of data a variable can store.
- C++ provides several built-in data types, including:
    - **int**: Used for integers (whole numbers).
    - **double**: Used for floating-point numbers (decimals).
    - **char**: Used for individual characters.
    - **bool**: Used for Boolean values (true or false).
    - **string**: Used for sequences of characters.

```Cpp
int age = 25;
double price = 19.99;
char grade = 'A';
bool isStudent = true;
std::string name = "John";

```

## Operators
- Operators are symbols used to perform operations on variables and values.
- C++ supports various types of operators, including:
    - **Arithmetic Operators**: Used for basic mathematical operations like addition, subtraction, multiplication, division, and modulus.
    - **Comparison Operators**: Used to compare values and return true or false.
    - **Logical Operators**: Used for logical operations like AND, OR, and NOT.
    - **Assignment Operators**: Used to assign values to variables.
    - **Increment/Decrement Operators**: Used to increase or decrease the value of a variable.
    - **Bitwise Operators**: Used to perform operations on individual bits.
    - **Conditional (Ternary) Operator**: Used for conditional expressions.
```Cpp
int x = 10, y = 5;
int sum = x + y;         // Addition
int difference = x - y;  // Subtraction
int product = x * y;     // Multiplication
int quotient = x / y;    // Division
int remainder = x % y;   // Modulus

bool isGreater = (x > y); // Comparison
bool logicalAnd = (x > 0) && (y > 0); // Logical AND

x++; // Increment x by 1
y--; // Decrement y by 1

int result = (x > y) ? x : y; // Ternary Operator

```

# Control Structure
Control structures in programming allow you to control the flow of your program's execution.
## Conditional Statements
- **if**: Executes a block of code if a specified condition is true.
- **else**: Executes a block of code if the condition in the preceding `if` statement is false.
- **else if**: Used to specify multiple conditions to be checked in sequence.
- **switch**: Allows you to select among several different code blocks based on the value of an expression.
```Cpp
int age = 18;
if (age < 18) {
    std::cout << "You are a minor." << std::endl;
} else {
    std::cout << "You are an adult." << std::endl;
}
```

## Loops
- **for**: Executes a block of code a specific number of times.
- **while**: Repeats a block of code while a specified condition is true.
- **do-while**: Similar to `while`, but ensures the code block is executed at least once.
```Cpp
for (int i = 0; i < 5; i++) {
    std::cout << "Iteration " << i << std::endl;
}
```
## Jump Statments
- **break**: Exits the current loop or switch statement.
- **continue**: Skips the current iteration of a loop and proceeds to the next one.
- **return**: Exits a function and optionally returns a value.
**Break**
```Cpp
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        std::cout << "Breaking loop at iteration " << i << std::endl;
        break;
    }
    std::cout << "Iteration " << i << std::endl;
}

```
**Continue**
```cpp
#include <iostream>
#include <thread>

void threadFunction(int threadID) {
    for (int i = 0; i < 5; ++i) {
        if (i == 2) {
            std::cout << "Thread " << threadID << " is skipping iteration " << i << std::endl;
            continue; // Skip iteration 2
        }
        std::cout << "Thread " << threadID << " is in iteration " << i << std::endl;
    }
}

int main() {
    std::thread t1(threadFunction, 1);
    std::thread t2(threadFunction, 2);

    t1.join();
    t2.join();

    return 0;
}

```
**Return**
```cpp
#include <iostream>
#include <thread>

void threadFunction(int threadID) {
    for (int i = 0; i < 5; ++i) {
        if (i == 2) {
            std::cout << "Thread " << threadID << " is terminating at iteration " << i << std::endl;
            return; // Terminate the thread at iteration 2
        }
        std::cout << "Thread " << threadID << " is in iteration " << i << std::endl;
    }
}

int main() {
    std::thread t1(threadFunction, 1);
    std::thread t2(threadFunction, 2);

    t1.join();
    t2.join();

    return 0;
}
```