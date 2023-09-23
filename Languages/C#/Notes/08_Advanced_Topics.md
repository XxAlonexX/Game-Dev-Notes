# Advanced Exception Handling
Exception handling in C# involves more than just using `try`, `catch`, and `finally` blocks. There are advanced concepts and practices that can help you write robust and reliable code. Here are some advanced topics related to exception handling in C#:
## Custom Exceptions
- You can create custom exception classes by deriving from `System.Exception` to represent application-specific errors.
- Custom exceptions allow you to provide more context and information about errors that occur in your application.
```cs
class MyCustomException : Exception
{
    public MyCustomException(string message) : base(message)
    {
    }
}
```
## Exception Filters
- Exception filters allow you to catch exceptions only if a specific condition is met.
- They are introduced with the `when` keyword.
```cs
try
{
    // Code that may throw exceptions.
}
catch (Exception ex) when (ex.Message.Contains("specific condition"))
{
    // Handle the exception if the condition is met.
}
```
## AggregateException
- An `AggregateException` is used when multiple exceptions are thrown concurrently (e.g., in parallel processing) and you need to handle all of them.
- It contains a collection of inner exceptions.
```cs
try
{
    // Code that may throw multiple exceptions concurrently.
}
catch (AggregateException ex)
{
    foreach (var innerException in ex.InnerExceptions)
    {
        // Handle each inner exception.
    }
}
```
## UnobservedTaskExceptions
- When dealing with asynchronous code using tasks, unhandled exceptions can lead to application crashes.
- You can subscribe to the `TaskScheduler.UnobservedTaskException` event to handle unobserved task exceptions and prevent application termination.
```cs
TaskScheduler.UnobservedTaskException += (sender, e) =>
{
    // Handle unobserved task exceptions.
    e.SetObserved();
};
```
## Exception Logging
- Logging exceptions, along with contextual information, is crucial for debugging and monitoring applications.
- Logging libraries like Serilog, NLog, or built-in logging mechanisms can be used to log exceptions.
## Using `throw` in `finally` block
- Be cautious when using `throw` within a `finally` block, as it can suppress exceptions that occurred in the corresponding `try` or `catch` blocks.
## Handling Specific Exceptions
It's generally better to handle specific exceptions rather than catching the base `System.Exception` class, as it allows you to provide more targeted error handling.

# Multithreading and Asynchronous Programming
Multithreading and asynchronous programming are essential for building responsive and high-performance applications in C#. These techniques allow you to execute tasks concurrently, making efficient use of CPU resources.
## Multithreading
- Multithreading involves running multiple threads of execution within a single process.
- Threads are lightweight units of execution that can perform tasks concurrently.
- In C#, you can work with threads using the `System.Threading` namespace.
```cs
using System;
using System.Threading;

class Program
{
    static void Main()
    {
        Thread thread1 = new Thread(() =>
        {
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() =>
        {
            for (int i = 0; i < 5; i++)
            {
                Console.WriteLine("Thread 2: " + i);
            }
        });

        thread1.Start();
        thread2.Start();

        // Wait for both threads to finish.
        thread1.Join();
        thread2.Join();
    }
}
```
## Task Parallel Library (TPL)
- TPL is a higher-level abstraction for managing tasks and parallelism in C#.
- The `Task` class represents an asynchronous operation or task.
```cs
using System;
using System.Threading.Tasks;

class Program
{
    static async Task Main()
    {
        Task task1 = Task.Run(() =>
        {
            Console.WriteLine("Task 1 is running.");
        });

        Task task2 = Task.Run(() =>
        {
            Console.WriteLine("Task 2 is running.");
        });

        await Task.WhenAll(task1, task2);
    }
}

```
## Asynchronous Programming
- Asynchronous programming allows you to write non-blocking code that improves the responsiveness of your application.
- The `async` and `await` keywords are used to work with asynchronous methods.
```cs
using System;
using System.Threading.Tasks;

class Program
{
    static async Task Main()
    {
        await Task.Delay(1000); // Simulate asynchronous operation.
        Console.WriteLine("Task completed after delay.");
    }
}
```
## Synchronization and Locking
- Multithreading can introduce synchronization issues and race conditions.
- Techniques like locks (`lock` keyword) and other synchronization primitives are used to ensure thread safety.
## Thread Safety Patterns
Design patterns like the Producer-Consumer pattern and the Reader-Writer pattern help manage concurrent access to resources.
## Cancelation Token
`CancellationToken` allows you to cancel long-running tasks gracefully.
## Parallel LINQ(PLINQ)
PLINQ is an extension of LINQ that allows for parallel execution of LINQ queries, improving performance for data-intensive operations.
