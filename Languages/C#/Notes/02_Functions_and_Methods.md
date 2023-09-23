>In C#, functions, also known as methods, are blocks of code that perform a specific task. Methods allow you to modularize your code, making it more organized, reusable, and maintainable.
## Method Declaration
- To declare a method, you specify its name, return type (if any), and parameters (if any).
```cs
// Method with no parameters and no return value (void).
void SayHello()
{
    Console.WriteLine("Hello, world!");
}

// Method with parameters and a return value.
int Add(int a, int b)
{
    int sum = a + b;
    return sum;
}
```
## Calling a Method
- To execute a method, you call it by its name and provide the required arguments (if any).
```cs
SayHello(); // Calling the SayHello method.

int result = Add(5, 3); // Calling the Add method and storing the result in 'result'.
```
## Return Values
A method can return a value using the `return` keyword. The return type in the method declaration should match the type of value being returned.
## Parameters
- Parameters are variables that you can pass to a method to provide input data.
- Methods can have zero or more parameters.
- Parameters are defined within parentheses in the method declaration.
```cs
void Greet(string name)
{
    Console.WriteLine("Hello, " + name + "!");
}
```
## Method Overloading
- C# allows you to define multiple methods with the same name in a class, as long as they have different parameter lists. This is known as method overloading.
```cs
int Add(int a, int b)
{
    return a + b;
}

double Add(double a, double b)
{
    return a + b;
}
```
## Access Modifiers
Access modifiers like `public`, `private`, and `protected` determine the visibility of methods. Public methods can be accessed from anywhere, while private methods are only accessible within the same class.
## Static Methods
Static methods belong to a class rather than an instance of the class. They can be called without creating an object of the class.
```cs
public static void PrintMessage()
{
    Console.WriteLine("This is a static method.");
}
```
## Method Parameters
Methods can have value parameters (pass by value) or reference parameters (pass by reference). By default, C# uses pass by value.
```cs
void ModifyValue(int x)
{
    x = 10;
}

void ModifyReference(ref int x)
{
    x = 10;
}
```
## Method Return 
- Methods can return various types, including value types, reference types, or even custom objects.
```cs
string GetMessage()
{
    return "Hello, world!";
}
```
