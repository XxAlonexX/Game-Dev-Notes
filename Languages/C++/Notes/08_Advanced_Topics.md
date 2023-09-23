# Templates and Generic Programming
Templates and generic programming in C++ are powerful features that allow you to write code that works with different data types without duplicating code. Templates enable you to create functions, classes, and data structures that are parameterized with one or more data types or values. This results in more flexible and reusable code.
## Function Templates
- Function templates allow you to define a generic function that can work with various data types.
- You specify the data type as a template parameter.
```cpp
template <typename T>
T add(T a, T b) {
    return a + b;
}

int main() {
    int result1 = add(5, 3);       // Calls add<int>
    double result2 = add(2.5, 3.7); // Calls add<double>
    return 0;
}
```
## Class Templates
- Class templates are similar to function templates, but they allow you to create generic classes.
- Template parameters can represent data types or values.
```cpp
template <typename T>
class MyContainer {
public:
    T data;
    MyContainer(T value) : data(value) {}
};

int main() {
    MyContainer<int> container1(42);       // Uses int as the type parameter
    MyContainer<double> container2(3.14); // Uses double as the type parameter
    return 0;
}
```
## Template Specialization
- Template specialization allows you to provide specialized implementations for specific data types.
- This can be useful when you want to optimize or customize behavior for certain types.
```cpp
template <typename T>
class MyContainer {
public:
    T data;
    MyContainer(T value) : data(value) {}
};

// Specialization for the string data type
template <>
class MyContainer<std::string> {
public:
    std::string data;
    MyContainer(std::string value) : data("Specialized: " + value) {}
};
```
## Non-Type Template Parameters
- Non-type template parameters allow you to use values, not just types, as template parameters.
- They are useful for creating templates that depend on constants or compile-time values.
```cpp
template <int N>
class FixedSizeArray {
public:
    int data[N];
    FixedSizeArray() {
        for (int i = 0; i < N; ++i) {
            data[i] = 0;
        }
    }
};

int main() {
    FixedSizeArray<5> arr; // Creates an array of size 5
    return 0;
}
```
## Generic Algorithms
- C++ Standard Library provides generic algorithms that work with various containers and data types.
- Examples include `std::sort`, `std::find`, `std::transform`, and more.
```cpp
std::vector<int> numbers = {3, 1, 4, 1, 5, 9};
std::sort(numbers.begin(), numbers.end());
```
>Templates and generic programming in C++ promote code reusability, flexibility, and maintainability. They allow you to write highly versatile code that can adapt to different data types and values, reducing the need for code duplication and increasing the overall efficiency of your programs.
# Lambda Expression
Lambda expressions, often referred to as "lambdas," are a powerful feature introduced in C++11 that allow you to create anonymous, inline functions. Lambdas are particularly useful for defining short, one-time-use functions without the need for explicitly declaring a separate function or function object. They are often used in modern C++ for tasks like sorting, filtering, and transforming data within algorithms and containers.
```cpp
[capture_clause](parameter_list) -> return_type {
    // Lambda body
}
```
## Capture Clause (Optional)
- The capture clause allows you to specify which variables from the surrounding scope the lambda can access.
- Variables can be captured by value (`[var]`) or by reference (`[&var]`).
- You can also capture multiple variables and mix capture modes.
```cpp
int x = 10;
auto lambda = [x]() {
    // 'x' is captured by value
    std::cout << x << std::endl;
};
```
## Parameter List (Optional)
- Like regular functions, lambdas can have parameters that are used within the lambda body.
- Parameters are defined within parentheses.
```cpp
auto add = [](int a, int b) {
    return a + b;
};
```
## Return Type (Optional)
In most cases, the return type of a lambda can be deduced by the compiler. However, you can specify it explicitly using the `->` operator.
```cpp
auto multiply = [](int a, int b) -> int {
    return a *
```
## Lambda Body
- The lambda body contains the code that gets executed when the lambda is invoked.
- It can include any valid C++ code, just like a regular function.
    **Using Lambda Expressions:**
    You can assign lambda expressions to variables and invoke them as if they were functions.
    ```cpp
    int main() {
    int x = 5;
    
    // Lambda captures 'x' by value and takes no parameters
    auto lambda = [x]() {
        std::cout << "Captured value: " << x << std::endl;
    };
    
    lambda(); // Invoke the lambda
    
    return 0;
}

  ```
## Lambda Expressions with Standard Algorithms
Lambdas are often used with standard algorithms like `std::for_each`, `std::sort`, and `std::find_if` to customize their behavior.
```cpp
#include <iostream>
#include <vector>
#include <algorithm>

int main() {
    std::vector<int> numbers = {3, 1, 4, 1, 5, 9};
    
    // Use a lambda to print each number
    std::for_each(numbers.begin(), numbers.end(), [](int num) {
        std::cout << num << " ";
    });

    // Use a lambda to find the first even number
    auto even = std::find_if(numbers.begin(), numbers.end(), [](int num) {
        return num % 2 == 0;
    });

    if (even != numbers.end()) {
        std::cout << "\nFirst even number: " << *even << std::endl;
    }
    
    return 0;
}
```
>Lambda expressions make it easier to write concise and readable code by encapsulating functionality within the scope where it is needed. They are a powerful tool for working with algorithms, data transformations, and custom operations in modern C++.
# Multithreading
Multithreading is a powerful programming technique that allows a program to execute multiple threads concurrently. Each thread is an independent unit of execution, capable of running its code concurrently with other threads. Multithreading is especially useful for improving performance in applications that can benefit from parallelism, such as data processing, simulations, and user interfaces.

> In C++, you can work with multithreading using the `<thread>` header and the `std::thread` class from the C++ Standard Library. Here's an overview of multithreading in C++:

## Creating Threads
You can create threads by constructing objects of the `std::thread` class and passing a callable function or function object (like a lambda) that the thread will execute.
```cpp
#include <iostream>
#include <thread>

void threadFunction() {
    // Code to be executed by the thread
    std::cout << "Thread is running." << std::endl;
}

int main() {
    std::thread t1(threadFunction); // Create a new thread
    t1.join(); // Wait for the thread to finish

    std::cout << "Main thread continues." << std::endl;
    return 0;
}
```
## Managing Threads
You can use member functions of the `std::thread` class to manage threads, such as `join()` to wait for a thread to finish and `detach()` to allow it to run independently.
```cpp
std::thread t1(threadFunction);
t1.join(); // Wait for t1 to finish

std::thread t2(threadFunction);
t2.detach(); // Allow t2 to run independently
```
## Data Sharing and Synchronization
- When multiple threads access shared data, you need to ensure proper synchronization to avoid data races and unpredictable behavior.
- C++ provides various synchronization primitives like `std::mutex`, `std::lock_guard`, `std::unique_lock`, and others to protect shared resources.
```cpp
#include <iostream>
#include <thread>
#include <mutex>

std::mutex mtx;

void threadFunction() {
    std::lock_guard<std::mutex> lock(mtx); // Lock the mutex
    std::cout << "Thread is running." << std::endl;
} // Automatically unlocks the mutex upon exiting the function

int main() {
    std::thread t1(threadFunction);
    t1.join();

    std::cout << "Main thread continues." << std::endl;
    return 0;
}
```
## Thread Safety 
It's essential to write thread-safe code when working with multithreading. Thread safety ensures that multiple threads can access shared data without causing conflicts or errors..
## Asynchronous Operations
C++ also provides asynchronous programming facilities using the `<future>` header and classes like `std::async` and `std::future`. These allow you to execute functions asynchronously and retrieve their results.
```cpp
#include <iostream>
#include <future>

int asyncFunction() {
    return 42;
}

int main() {
    std::future<int> result = std::async(std::launch::async, asyncFunction);
    int value = result.get(); // Wait for the async task to complete and get the result

    std::cout << "Async result: " << value << std::endl;
    return 0;
}
```

>Multithreading in C++ enables you to leverage the full power of modern CPUs by executing tasks concurrently. However, it also introduces challenges related to synchronization and coordination. Properly managing multithreaded code is essential to avoid issues like data races and deadlocks.