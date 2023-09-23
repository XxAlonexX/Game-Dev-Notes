# Classes & Objects 
### Classes
A class is a blueprint for creating objects. It defines the structure and behavior of objects of that type.
```cs
class Person
{
    public string Name;
    public int Age;

    public void SayHello()
    {
        Console.WriteLine("Hello, my name is " + Name);
    }
}
```
### Objects
An object is an instance of a class, representing a real-world entity or concept. You can create multiple objects from the same class.
```cs
Person person1 = new Person();
person1.Name = "Alice";
person1.Age = 30;
```

# Encapsulation
- Encapsulation is the concept of bundling data (fields) and methods (functions) that operate on the data into a single unit (class). It hides the internal implementation details of a class and exposes a controlled interface.
- Access modifiers (`public`, `private`, `protected`, `internal`, etc.) control the visibility of class members.
# Inheritance
Inheritance is a mechanism that allows a class (derived or child class) to inherit the properties and behaviors of another class (base or parent class).
```cs
class Student : Person
{
    public int StudentId;
}
```
# Polymorphism
- Polymorphism allows objects of different classes to be treated as objects of a common base class. It enables method overriding and dynamic method binding.
- Method overriding: A derived class can provide its own implementation of a method inherited from a base class.
```cs
class Animal
{
    public virtual void MakeSound()
    {
        Console.WriteLine("Animal makes a sound");
    }
}

class Dog : Animal
{
    public override void MakeSound()
    {
        Console.WriteLine("Dog barks");
    }
}
```
# Abstraction
- Abstraction is the process of simplifying complex systems by breaking them into smaller, more manageable parts. In C#, you can create abstract classes and methods.
- Abstract classes cannot be instantiated and are often used as base classes with one or more abstract methods that must be implemented by derived classes.
# Interfaces
- An interface is a contract that defines a set of methods that a class must implement. A class can implement multiple interfaces, enabling it to fulfill multiple contracts.
```cs
interface IDrawable
{
    void Draw();
}
```
# Constructors & Distructors
- Constructors are special methods used to initialize objects when they are created. C# supports parameterized constructors and constructor overloading.
- Destructors are used for cleaning up resources when an object is destroyed (not often used due to automatic memory management).