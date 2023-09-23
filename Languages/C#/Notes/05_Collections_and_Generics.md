# Arrays 
- An array is a fixed-size collection of elements of the same data type.
- Array elements are accessed by their index, starting from 0.
- Arrays have a fixed length, which cannot be changed after initialization.
```cs
int[] numbers = new int[5]; // Creates an integer array with 5 elements.
numbers[0] = 10;
numbers[1] = 20;
// ...
```
# Lists(System.Collections.Generic.list)
- A list is a dynamic-size collection that can grow or shrink as needed.
- Lists are part of the `System.Collections.Generic` namespace.
```cs
List<string> names = new List<string>(); // Creates a list of strings.
names.Add("Alice");
names.Add("Bob");
// ...
```
# Dictionaries(System.Collections.Generic.Dictionaries)
- A dictionary is a collection of key-value pairs.
- Each key is unique, and it maps to a specific value.
- Dictionaries are often used for fast data retrieval based on keys
```cs
Dictionary<string, int> scores = new Dictionary<string, int>();
scores["Alice"] = 95;
scores["Bob"] = 85;
// ...
```
# ArrayList(System.Collections.ArryaList)
- An `ArrayList` is a non-generic collection that can hold elements of different data types.
- It's less type-safe compared to generic collections like lists.
```cs
ArrayList list = new ArrayList();
list.Add(42);
list.Add("Hello");
// ...
```
>**Array vs Lists:** Arrays have a fixed size, while lists can grow or shrink dynamically.
 Lists provide more flexibility and functionality (e.g., adding, removing, searching) compared to arrays.
# Enumerators(foreach Loop)
You can iterate through collections using the `foreach` loop, which is based on enumerators.
```cs
foreach (var item in names)
{
    Console.WriteLine(item);
}
```
# LINQ(Language Integrated Query)
- LINQ allows you to query and manipulate data in collections using a SQL-like syntax.
- It's a powerful tool for filtering, sorting, and transforming data.
```cs
var query = from name in names
            where name.StartsWith("A")
            select name;
```
# Common Collection Interfaces
C# includes common collection interfaces like `IEnumerable`, `ICollection`, and `IList` that provide a standardized way to work with collections.

