 
>Exception handling is a critical feature in C++ that allows you to deal with unexpected errors or exceptional conditions that can occur during program execution. It provides a way to gracefully handle and recover from errors, rather than allowing them to crash your program. Exception handling in C++ involves three key components: `try`, `catch`, and `throw`.

# `try` Block
- The `try` block is used to enclose the code where an exception might occur.
- Inside the `try` block, you write the code that may throw an exception.
```cpp
try {
    // Code that may throw an exception
}
```
# `catch` Block
- The `catch` block is used to catch and handle exceptions thrown in the associated `try` block.
- You can have one or more `catch` blocks, each handling a specific type of exception.
```cpp
try {
    // Code that may throw an exception
}
catch (ExceptionType1 &e) {
    // Handle ExceptionType1
}
catch (ExceptionType2 &e) {
    // Handle ExceptionType2
}
// ...
```
# `throw` Statement
- The `throw` statement is used to explicitly throw an exception.
- You can throw exceptions of different types, including built-in types, custom classes, or standard library exceptions.
```cpp
if (condition) {
    throw SomeException("An error occurred");
}
```

Example
```cpp
#include <iostream>
#include <stdexcept>

int divide(int x, int y) {
    if (y == 0) {
        throw std::runtime_error("Division by zero");
    }
    return x / y;
}

int main() {
    try {
        int result = divide(10, 0);
        std::cout << "Result: " << result << std::endl;
    }
    catch (const std::exception &e) {
        std::cerr << "Exception caught: " << e.what() << std::endl;
    }

    return 0;
}
// In this example, the `divide` function may throw a `std::runtime_error` exception when dividing by zero. The `try` block in `main` catches this exception and prints an error message.
```

# Common Exception Examples
C++ provides several built-in exception classes in the `<stdexcept>` header, such as `std::runtime_error`, `std::logic_error`, `std::out_of_range`, etc. These can be used for common error conditions.tdd
# stdd::exception
- `std::exception` is the base class for all standard C++ exception classes.
- It defines a `what()` method, which returns a description of the exception.
- Derived exception classes should override this method to provide meaningful error messages.
```cpp
class std::exception {
public:
    virtual const char* what() const noexcept;
};
```
# std::logic_error
- `std::logic_error` is derived from `std::exception`.
- It is used for exceptions that represent errors in program logic, such as invalid arguments to functions.
```cpp
class std::logic_error : public std::exception {
public:
    explicit logic_error(const std::string& what_arg);
};
```
# std::domain_error
Used when an argument to a function is outside the valid domain of that function.
# std::invalid_argument
Used to indicate that an argument to a function is invalid or out of range.
# std::lenghth_error
Used when a container or string exceeds its maximum allowed length.
# std::out_of_range
Used to indicate that an attempt was made to access an element outside the valid range, such as indexing a container with an out-of-range index.
# Custom Exception Classes
You can create your own custom exception classes by inheriting from `std::exception` or a related exception class. Custom exception classes should typically provide a meaningful `what()` method to return an error message.
```cpp
class MyException : public std::exception {
public:
    MyException(const std::string &msg) : message(msg) {}
    const char *what() const noexcept override {
        return message.c_str();
    }

private:
    std::string message;
};
```

> Exception handling is a crucial aspect of robust C++ programming, allowing you to handle errors gracefully and ensure that your program remains stable even in the presence of unexpected issues.