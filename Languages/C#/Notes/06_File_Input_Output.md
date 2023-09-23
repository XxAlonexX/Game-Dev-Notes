# Reading From Files
You can read data from a file using classes like `StreamReader` or `File.ReadAllText`.
Using `StreamReader`:
```cs
using System;
using System.IO;

class Program
{
    static void Main()
    {
        try
        {
            using (StreamReader reader = new StreamReader("example.txt"))
            {
                string line;
                while ((line = reader.ReadLine()) != null)
                {
                    Console.WriteLine(line);
                }
            }
        }
        catch (FileNotFoundException)
        {
            Console.WriteLine("File not found.");
        }
    }
}
```
# Writing To Files
- You can write data to a file using classes like `StreamWriter` or `File.WriteAllText`.

Using `StreamWriter`:

```cs
using System;
using System.IO;

class Program
{
    static void Main()
    {
        try
        {
            using (StreamWriter writer = new StreamWriter("output.txt"))
            {
                writer.WriteLine("Hello, world!");
            }
        }
        catch (IOException)
        {
            Console.WriteLine("An error occurred while writing to the file.");
        }
    }
}
```
# File And Directory Manipulation
C# provides classes like `File` and `Directory` for common file and directory operations, such as checking if a file exists, creating directories, and deleting files.
```cs
using System;
using System.IO;

class Program
{
    static void Main()
    {
        string filePath = "example.txt";

        if (File.Exists(filePath))
        {
            Console.WriteLine("File exists.");
        }
        else
        {
            Console.WriteLine("File does not exist.");
        }
    }
}
```
# Binary File I/O
- Binary file I/O is used to read and write non-text data, such as images, audio, and binary files.
- Classes like `BinaryReader` and `BinaryWriter` are used for binary file operations.
# Exception Handling for I/O
When performing file I/O operations, it's essential to handle exceptions related to file access, such as `FileNotFoundException`, `IOException`, and `UnauthorizedAccessException`.
# Asynchronous File Type
C# supports asynchronous file I/O operations using the `async` and `await` keywords for improved responsiveness in applications.
