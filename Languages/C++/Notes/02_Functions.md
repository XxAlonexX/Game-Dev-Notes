## Declaration 
A function declaration specifies the function's name, return type, and its parameters (if any). It informs the compiler about the existence and signature of the function.

```Cpp
return_type function_name(parameter_type1 parameter1, parameter_type2 parameter2, ...) {
    // Function body
}
```

```cpp
int add(int x, int y) {
    return x + y;
}
```
## Definition
The function definition provides the actual implementation of the function, including the code to be executed when the function is called.
```cpp
int add(int x, int y) {
    return x + y;
}
```
## Function Call
To use a function, you need to call it. You do this by using the function's name followed by arguments enclosed in parentheses. If the function has a return value, you can assign it to a variable or use it in an expression.
```cpp
int result = add(5, 3); // Calling the add function
```
## Return Statement
Functions can return values using the `return` statement. The return type in the function declaration specifies the type of value the function should return.
```cpp
int add(int x, int y) {
    return x + y; // Returns the sum of x and y
}
```
## Parameters 
Functions can accept zero or more parameters (also known as arguments) that provide data for the function to work with. Parameters are specified in the function declaration and used in the function body.
```cpp
int multiply(int x, int y) {
    return x * y;
}
```
## Overloading
C++ supports function overloading, which allows you to define multiple functions with the same name but different parameter lists. The correct function is called based on the arguments provided.
```cpp
int add(int x, int y) {
    return x + y;
}

double add(double x, double y) {
    return x + y;
}
```
## Prototypes
In larger programs, you may declare function prototypes at the beginning to inform the compiler about the functions you'll define later in the code.
```cpp
// Function prototype
int add(int x, int y);

int main() {
    int result = add(5, 3);
    return 0;
}

// Function definition
int add(int x, int y) {
    return x + y;
}
```

## Pass By value 
- When a parameter is passed by value, a copy of the argument's value is made and used within the function.
- Changes made to the parameter inside the function do not affect the original argument.
- Pass by value is the default behavior for most data types in C++.
```cpp
void increment(int x) {
    x++; // This does not affect the original value outside the function.
}

int main() {
    int num = 5;
    increment(num);
    std::cout << num << std::endl; // Output: 5 (unchanged)
    return 0;
}
```

## Pass By Reference 
- When a parameter is passed by reference, the function operates directly on the original argument, rather than making a copy.
- Changes made to the parameter inside the function affect the original data.
- Pass by reference is often used when you want to modify the original data or to avoid the overhead of copying large data structures.
```cpp
void increment(int &x) {
    x++; // This affects the original value outside the function.
}

int main() {
    int num = 5;
    increment(num);
    std::cout << num << std::endl; // Output: 6 (modified)
    return 0;
}
```
Using Pointers
```cpp
void increment(int *x) {
    (*x)++; // This affects the original value outside the function.
}

int main() {
    int num = 5;
    increment(&num);
    std::cout << num << std::endl; // Output: 6 (modified)
    return 0;
}
```
>Pass by reference can be more efficient than pass by value, especially for large data structures, as it avoids copying the data. However, you should use pass by reference carefully, as it can lead to unexpected side effects when modifying data within a function.