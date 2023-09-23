# Advance Graph Algorithms
Advanced graph algorithms are specialized algorithms designed to solve complex problems on graphs. These algorithms often involve traversing or analyzing the structure of graphs in more intricate ways than basic graph algorithms like BFS and DFS. Here are examples of some advanced graph algorithms implemented in C++.
### Kruskal's Algorithm (Minimum Spanning Tree):
Kruskal's algorithm finds the minimum spanning tree (MST) of a weighted graph, which is a subgraph that includes all vertices with the minimum possible total edge weight.
```cpp
#include <iostream>
#include <vector>
#include <algorithm>

struct Edge {
    int src, dest, weight;
};

class Graph {
public:
    int V, E;
    std::vector<Edge> edges;

    Graph(int vertices, int edgesCount);
    void addEdge(int src, int dest, int weight);
    void kruskalMST();
};

Graph::Graph(int vertices, int edgesCount) : V(vertices), E(edgesCount) {}

void Graph::addEdge(int src, int dest, int weight) {
    edges.push_back({src, dest, weight});
}

bool compareEdges(const Edge& a, const Edge& b) {
    return a.weight < b.weight;
}

void Graph::kruskalMST() {
    std::vector<Edge> result;
    std::sort(edges.begin(), edges.end(), compareEdges);

    std::vector<int> parent(V);

    for (int i = 0; i < V; ++i) {
        parent[i] = i;
    }

    int edgeCount = 0, i = 0;

    while (edgeCount < V - 1 && i < E) {
        Edge nextEdge = edges[i++];

        int x = parent[nextEdge.src];
        int y = parent[nextEdge.dest];

        if (x != y) {
            result.push_back(nextEdge);
            ++edgeCount;

            for (int j = 0; j < V; ++j) {
                if (parent[j] == y) {
                    parent[j] = x;
                }
            }
        }
    }

    std::cout << "Minimum Spanning Tree:\n";
    for (const Edge& edge : result) {
        std::cout << edge.src << " - " << edge.dest << " : " << edge.weight << "\n";
    }
}

int main() {
    int V = 4;
    int E = 5;
    Graph graph(V, E);

    graph.addEdge(0, 1, 10);
    graph.addEdge(0, 2, 6);
    graph.addEdge(0, 3, 5);
    graph.addEdge(1, 3, 15);
    graph.addEdge(2, 3, 4);

    graph.kruskalMST();

    return 0;
}

```
### Bellman-Ford Algorithm (Single-Source Shortest Path with Negative Weights)
Bellman-Ford is used to find the shortest paths from a single source vertex to all other vertices, even when there are negative weight edges.
```cpp
#include <iostream>
#include <vector>

struct Edge {
    int src, dest, weight;
};

class Graph {
public:
    int V, E;
    std::vector<Edge> edges;

    Graph(int vertices, int edgesCount);
    void addEdge(int src, int dest, int weight);
    void bellmanFord(int source);
};

Graph::Graph(int vertices, int edgesCount) : V(vertices), E(edgesCount) {}

void Graph::addEdge(int src, int dest, int weight) {
    edges.push_back({src, dest, weight});
}

void Graph::bellmanFord(int source) {
    std::vector<int> dist(V, INT_MAX);
    dist[source] = 0;

    for (int i = 0; i < V - 1; ++i) {
        for (const Edge& edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
            }
        }
    }

    for (const Edge& edge : edges) {
        int u = edge.src;
        int v = edge.dest;
        int w = edge.weight;

        if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
            std::cout << "Negative cycle detected!\n";
            return;
        }
    }

    std::cout << "Shortest distances from source vertex:\n";
    for (int i = 0; i < V; ++i) {
        std::cout << "Vertex " << i << ": " << dist[i] << "\n";
    }
}

int main() {
    int V = 5;
    int E = 8;
    Graph graph(V, E);

    graph.addEdge(0, 1, -1);
    graph.addEdge(0, 2, 4);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(1, 4, 2);
    graph.addEdge(3, 2, 5);
    graph.addEdge(3, 1, 1);
    graph.addEdge(4, 3, -3);

    graph.bellmanFord(0);

    return 0;
}

```
### Floyd-Warshall Algorithm (All Pairs Shortest Path)
Floyd-Warshall finds the shortest paths between all pairs of vertices in a weighted graph.
```cpp
#include <iostream>
#include <vector>

const int INF = INT_MAX;

class Graph {
public:
    int V;
    std::vector<std::vector<int>> adjMatrix;

    Graph(int vertices);
    void addEdge(int src, int dest, int weight);
    void floydWarshall();
};

Graph::Graph(int vertices) : V(vertices) {
    adjMatrix.assign(V, std::vector<int>(V, INF));

    for (int i = 0; i < V; ++i) {
        adjMatrix[i][i] = 0;
    }
}

void Graph::addEdge(int src, int dest, int weight) {
    adjMatrix[src][dest] = weight;
}

void Graph::floydWarshall() {
    std::vector<std::vector<int>> dist = adjMatrix;

    for (int k = 0; k < V; ++k) {
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][k] != INF && dist[k][j] != INF &&
                    dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    std::cout << "Shortest path distances between all pairs of vertices:\n";
    for (int i = 0; i < V; ++i) {
        for (int j = 0; j < V; ++j) {
            if (dist[i][j] == INF) {
                std::cout << "INF ";
            } else {
                std::cout << dist[i][j] << " ";
            }
        }
        std::cout << "\n";
    }
}

int main() {
    int V = 4;
    Graph graph(V);

    graph.addEdge(0, 1, 3);
    graph.addEdge(0, 2, 6);
    graph.addEdge(1, 2, 2);
    graph.addEdge(1, 3, 1);
    graph.addEdge(2, 1, 1);
    graph.addEdge(2, 3, 4);
    graph.addEdge(3, 0, 2);
    graph.addEdge(3, 2, 1);

    graph.floydWarshall();

    return 0;
}
```
# Advanced Data Structure
Advanced data structures are specialized data structures designed to efficiently solve specific types of problems or provide advanced functionality beyond what basic data structures like arrays and linked lists offer. Here are some examples of advanced data structures implemented in C++
### B-Trees
B-Trees are self-balancing tree structures that maintain sorted data and are commonly used in databases and file systems to store and manage large amounts of data efficiently.
```cpp
#include <iostream>
#include <set>

int main() {
    std::set<int> btree;
    btree.insert(10);
    btree.insert(20);
    btree.insert(5);

    std::cout << "B-Tree elements: ";
    for (int elem : btree) {
        std::cout << elem << " ";
    }

    return 0;
}

```
### Red-Black Trees
Red-Black Trees are self-balancing binary search trees that guarantee logarithmic time complexity for insertion, deletion, and search operations.
```cpp
#include <iostream>
#include <map>

int main() {
    std::map<int, std::string> redBlackTree;
    redBlackTree[1] = "One";
    redBlackTree[3] = "Three";
    redBlackTree[2] = "Two";

    std::cout << "Red-Black Tree elements: ";
    for (const auto& pair : redBlackTree) {
        std::cout << "(" << pair.first << ", " << pair.second << ") ";
    }

    return 0;
}
```
### Segment Trees
Segment Trees are used for various range query operations, such as finding the sum, minimum, or maximum of elements within a specified range in an array.
```cpp
#include <iostream>
#include <vector>

class SegmentTree {
public:
    SegmentTree(const std::vector<int>& arr);
    int getSum(int queryLeft, int queryRight);

private:
    int buildTree(int node, int start, int end);
    int getSumUtil(int node, int start, int end, int queryLeft, int queryRight);

    std::vector<int> tree;
    std::vector<int> data;
};

int main() {
    std::vector<int> arr = {1, 3, 5, 7, 9, 11};
    SegmentTree segmentTree(arr);

    int sum = segmentTree.getSum(1, 3);
    std::cout << "Sum of elements in range [1, 3]: " << sum << std::endl;

    return 0;
}
```
# String Algorithms
String algorithms are essential in computer science and are used to manipulate, search, and analyze strings efficiently. Here are some commonly used string algorithms implemented in C++
### **String Concatenation**
Concatenating two strings is a basic operation in string manipulation.
```cpp
#include <iostream>
#include <string>

int main() {
    std::string str1 = "Hello, ";
    std::string str2 = "world!";
    std::string result = str1 + str2;

    std::cout << "Concatenated string: " << result << std::endl;

    return 0;
}
```
### String Length
Find the length of the string.
```cpp
#include <iostream>
#include <string>

int main() {
    std::string str = "Hello, world!";
    int length = str.length();

    std::cout << "String length: " << length << std::endl;

    return 0;
}
```
### Substring Search
Searching for a substring within a string.
```cpp
#include <iostream>
#include <string>

int main() {
    std::string text = "The quick brown fox jumps over the lazy dog.";
    std::string pattern = "fox";

    if (text.find(pattern) != std::string::npos) {
        std::cout << "Substring found!" << std::endl;
    } else {
        std::cout << "Substring not found." << std::endl;
    }

    return 0;
}

```
### String Reversal 
Reversing a String.
```cpp
#include <iostream>
#include <string>
#include <algorithm>

int main() {
    std::string str = "Hello, world!";
    std::reverse(str.begin(), str.end());

    std::cout << "Reversed string: " << str << std::endl;

    return 0;
}
```
### String Tokenization
Splitting a string into tokens based on a delimiter.
```cpp
#include <iostream>
#include <string>
#include <sstream>
#include <vector>

int main() {
    std::string input = "apple,banana,cherry,date";
    char delimiter = ',';

    std::vector<std::string> tokens;
    std::istringstream tokenStream(input);
    std::string token;

    while (std::getline(tokenStream, token, delimiter)) {
        tokens.push_back(token);
    }

    std::cout << "Tokens:";
    for (const std::string& t : tokens) {
        std::cout << " " << t;
    }
    std::cout << std::endl;

    return 0;
}
```
### String Comparison
Compare two strings.
```cpp
#include <iostream>
#include <string>

int main() {
    std::string str1 = "apple";
    std::string str2 = "banana";

    if (str1 == str2) {
        std::cout << "Strings are equal." << std::endl;
    } else {
        std::cout << "Strings are not equal." << std::endl;
    }

    return 0;
}
```
### String Matching Algorithms
Advanced string matching algorithms like the Knuth-Morris-Pratt (KMP) algorithm or the Boyer-Moore algorithm are used to find occurrences of a pattern within a text efficiently.

>Example: Knuth-Morris-Pratt (KMP) Algorithm
```cpp
#include <iostream>
#include <vector>

void computeLPS(const std::string& pattern, std::vector<int>& lps) {
    int length = 0;
    int i = 1;
    lps[0] = 0;

    while (i < pattern.length()) {
        if (pattern[i] == pattern[length]) {
            ++length;
            lps[i] = length;
            ++i;
        } else {
            if (length != 0) {
                length = lps[length - 1];
            } else {
                lps[i] = 0;
                ++i;
            }
        }
    }
}

void KMPSearch(const std::string& text, const std::string& pattern) {
    std::vector<int> lps(pattern.length());
    computeLPS(pattern, lps);

    int i = 0, j = 0;
    while (i < text.length()) {
        if (pattern[j] == text[i]) {
            ++i;
            ++j;
        }
        if (j == pattern.length()) {
            std::cout << "Pattern found at index " << i - j << std::endl;
            j = lps[j - 1];
        } else if (i < text.length() && pattern[j] != text[i]) {
            if (j != 0) {
                j = lps[j - 1];
            } else {
                ++i;
            }
        }
    }
}

int main() {
    std::string text = "ABABDABACDABABCABAB";
    std::string pattern = "ABABCABAB";

    KMPSearch(text, pattern);

    return 0;
}

```