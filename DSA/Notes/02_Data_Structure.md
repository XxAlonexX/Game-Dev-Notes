>  A data structure is a way of organizing and storing data in a computer so that it can be accessed and modified efficiently. Data structures are essential for managing and manipulating data in software development and are used in various applications and algorithms. Here are some commonly used data structures:

# Array
 An array is a collection of elements of the same data type stored in contiguous memory locations. Elements can be accessed by their index, making it fast for random access.
 - Arrays can store game assets like textures, models, or sounds.
```cpp
Texture textures[10]; // An array of 10 textures
```
# Linked List
 A linked list is a linear data structure in which elements are stored in nodes, and each node points to the next node in the sequence. Linked lists are flexible for inserting and deleting elements but slower for random access.
 - Linked lists can manage game entities or components in a scene graph.
```cpp
class GameObject {
public:
    // Game object properties and methods
};

class LinkedListNode {
public:
    GameObject* data;
    LinkedListNode* next;
};

LinkedListNode* head = nullptr; // Initialize a linked list of game objects
```
# Stack 
A stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. It's used for managing function calls, undo functionality, and more.
- Stacks can manage game state or handle function calls.
```cpp
#include <stack>
std::stack<GameState> gameStateStack;
```
# Queue
A queue is a linear data structure that follows the First-In-First-Out (FIFO) principle. It's used for tasks like managing tasks in a printer queue or breadth-first search in graphs.
**Tree**: A tree is a hierarchical data structure with a root node and child nodes. Common types include binary trees, binary search trees, and AVL trees. Trees are used in various applications, including searching, sorting, and representing hierarchical relationships.   
- Queues can manage tasks or actions in a game.
```cpp
#include <queue>
std::queue<Action> actionQueue;
```
# Graph 
A graph is a collection of nodes (vertices) and edges that connect these nodes. Graphs can be used to represent complex relationships, such as social networks, road networks, and more.
- Graphs are used for pathfinding and navigation in game worlds.
```cpp
class NavNode {
public:
    std::vector<NavNode*> neighbors;
    // Navigation properties and methods
};

std::vector<NavNode*> navigationMesh; // The navigation mesh for pathfinding

```
# Tree
(Scene Graph for Game Objects):
- Trees can represent scene hierarchies in games, allowing efficient rendering and transformations of game objects.
```cpp
class SceneNode {
public:
    std::vector<SceneNode*> children;
    // Game object properties and methods
};

SceneNode* rootNode = new SceneNode(); // Root node of the scene graph

```
# Hash Table
A hash table is a data structure that stores key-value pairs and provides efficient lookup and insertion operations. It uses a hash function to map keys to indices in an array.
- Hash tables can implement an entity-component system (ECS) for managing game entity components efficiently.
```cpp
std::unordered_map<EntityID, Component*> componentMap;
```
# Heap
A heap is a specialized tree-based data structure that satisfies the heap property. Heaps are often used for priority queues and heap sort.
- Heaps can be used in AI decision-making for selecting actions based on priorities.
```cpp
#include <queue>
std::priority_queue<AIAction, std::vector<AIAction>, AIActionComparator> actionQueue;
```
# Trie
A trie (pronounced "try") is a tree-like data structure used for storing a dynamic set of strings. It's commonly used in applications involving strings and text, such as autocomplete systems.
- Tries can provide efficient word lookup or autocomplete features in text-based games.
```cpp
class TrieNode {
public:
    std::unordered_map<char, TrieNode*> children;
    bool isWord;
};

TrieNode* dictionary = new TrieNode(); // Initialize a dictionary trie
```
# Sparse Matrix
A sparse matrix is a two-dimensional array where most of the elements are zero. Special data structures like the compressed sparse row (CSR) or compressed sparse column (CSC) are used to efficiently store and manipulate sparse matrices.
- Sparse matrices can represent large terrain maps efficiently.
```cpp
std::vector<std::vector<TerrainCell>> terrainGrid; // Sparse terrain grid
```
# Bloom Filter
A Bloom filter is a probabilistic data structure used to test whether an element is a member of a set. It uses a bit array and multiple hash functions.
- Used for fast membership testing, e.g., checking if an item exists in a collection:
```cpp
#include "bloom_filter.hpp"
BloomFilter<GameObject> objectFilter;
```
# Skip List
A skip list is a data structure that provides fast search, insertion, and deletion of elements in a sorted collection. It's often used as an alternative to balanced trees.
```cpp
#include "skip_list.hpp"
SkipList<Enemy> enemySkipList;
```

# Sparse Matrix
Sparse terrain data storage for optimized rendering and collision detection.
```cpp
#include "sparse_matrix.hpp"
SparseMatrix<TerrainCell> terrainMap;
```