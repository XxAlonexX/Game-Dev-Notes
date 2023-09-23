# Classes and Objects
- A class is a blueprint or template for creating objects. It defines the structure and behavior of objects.
- An object is an instance of a class. It represents a real-world entity and encapsulates data and methods (functions) to work with that data.
```cpp
class Car {
public:
    // Data members (attributes)
    std::string make;
    std::string model;
    int year;

    // Member functions (methods)
    void start() {
        // Code to start the car
    }

    void stop() {
        // Code to stop the car
    }
};
```

# Encapsulation
- Encapsulation is the concept of bundling data (attributes) and the methods (functions) that operate on that data into a single unit (the class).
- Access specifiers like `public`, `private`, and `protected` determine the visibility and accessibility of class members.
```cpp

class Student {
private:
    std::string name;
    int age;

public:
    void setName(std::string newName) {
        name = newName;
    }

    std::string getName() {
        return name;
    }

    void setAge(int newAge) {
        age = newAge;
    }

    int getAge() {
        return age;
    }
};
```

# Inheritance
- Inheritance allows you to create a new class (subclass or derived class) that inherits properties and behaviors from an existing class (base class or parent class).
- It promotes code reuse and the creation of hierarchies of classes.\
```cpp
class Animal {
public:
    void speak() {
        std::cout << "Animal speaks" << std::endl;
    }
};

class Dog : public Animal {
public:
    void speak() {
        std::cout << "Dog barks" << std::endl;
    }
};
```

# Polymorphism
- Polymorphism allows objects of different classes to be treated as objects of a common base class.
- It enables you to define a single interface or method that can work with objects of various derived classes.
```cpp
class Shape {
public:
    virtual void draw() {
        std::cout << "Drawing a shape" << std::endl;
    }
};

class Circle : public Shape {
public:
    void draw() override {
        std::cout << "Drawing a circle" << std::endl;
    }
};

class Square : public Shape {
public:
    void draw() override {
        std::cout << "Drawing a square" << std::endl;
    }
};
```
# Abstraction
- Abstraction is the process of simplifying complex reality by modeling classes based on the essential properties and behaviors.
- It hides the complex implementation details and exposes only the necessary functionality.

# Constructors and Destructors
Constructors and destructors are special member functions in C++ that are used to initialize and clean up objects of a class, respectively.
## Constructors
### Definition
- A constructor is a special member function with the same name as the class.
- It is called automatically when an object of the class is created.
- Constructors initialize the object's data members and allocate necessary resources.
```cpp
class MyClass {
public:
    // Constructor
    MyClass() {
        // Initialization code here
    }
};
```

### Default Constructor
- If you don't define any constructor for a class, C++ provides a default constructor with no parameters.
- You can also define your own default constructor.
```cpp
class MyClass {
public:
    // Default Constructor
    MyClass() {
        // Initialization code here
    }
};
```
### Parameterized Constructors
- Constructors can accept parameters to initialize the object's data members based on provided values.
- Parameterized constructors allow you to create objects with different initial states.
```cpp
class Person {
public:
    // Parameterized Constructor
    Person(std::string name, int age) {
        this->name = name;
        this->age = age;
    }
    std::string name;
    int age;
};
```

## Destructors
### Definition
- A destructor is a special member function with the same name as the class, preceded by a tilde (~).
- It is called automatically when an object goes out of scope or is explicitly deleted.
- Destructors are used to release resources, such as memory or file handles, held by the object.
```cpp
class MyClass {
public:
    // Destructor
    ~MyClass() {
        // Cleanup code here
    }
};
```
### Default Destructors
- If you don't define a destructor for a class, C++ provides a default destructor that does nothing.
- If your class allocates resources that need cleanup, you should define a destructor.
```cpp
class MyClass {
public:
    // Destructor
    ~MyClass() {
        // Cleanup code here (e.g., releasing memory)
    }
};
```
### Resource Managment
Destructors are often used for resource management, such as deallocating memory, closing files, or releasing network connections.
```cpp
class FileHandler {
private:
    FILE *file;

public:
    FileHandler(const char *filename) {
        file = fopen(filename, "r");
    }

    ~FileHandler() {
        if (file != nullptr) {
            fclose(file);
        }
    }
};
```