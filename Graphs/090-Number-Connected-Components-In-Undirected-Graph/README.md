# Number of Connected Components in an Undirected Graph

## Problem

You are given:

- `n` nodes labelled from `0` to `n - 1`
- An array of undirected edges

Return the number of connected components in the graph.

A connected component is a group of vertices where every vertex can be reached from every other vertex in the group.

---

# Example 1

Input:

```
n = 5

edges =
[
 [0,1],
 [1,2],
 [3,4]
]
```

Graph:

```
0 --- 1 --- 2

3 --- 4
```

Output:

```
2
```

There are two separate connected components.

---

# Example 2

Input:

```
n = 5

edges =
[
 [0,1],
 [1,2],
 [2,3],
 [3,4]
]
```

Graph:

```
0 --- 1 --- 2 --- 3 --- 4
```

Output:

```
1
```

All nodes belong to one connected component.

---

# Key Observation

A connected component is simply one complete DFS traversal.

Whenever DFS starts from an unvisited node, a brand new connected component has been found.

---

# Approach

## 1. Build an Adjacency List

Because the graph is undirected, every edge is stored in both directions.

Example:

```
edges =

[
 [0,1],
 [1,2]
]
```

Adjacency list:

```
0 -> {1}

1 -> {0,2}

2 -> {1}
```

---

## 2. Traverse Every Node

Loop through every node.

If the node has not been visited:

- Run DFS
- Mark every reachable node as visited
- Increment the component count

Every DFS completely explores one connected component.

---

## 3. DFS

DFS performs a standard graph traversal.

For each node:

- Skip if already visited
- Mark as visited
- Visit every neighbour recursively

Eventually the entire connected component becomes visited.

---

# Example Walkthrough

Graph:

```
0 --- 1 --- 2

3 --- 4
```

Start:

```
visited = {}

components = 0
```

Visit node 0:

DFS visits:

```
0

↓

1

↓

2
```

Visited:

```
{0,1,2}
```

Components:

```
1
```

Continue scanning.

Node 3 is unvisited.

DFS visits:

```
3

↓

4
```

Visited:

```
{0,1,2,3,4}
```

Components:

```
2
```

Answer:

```
2
```

---

# Complexity Analysis

Let

```
V = number of vertices

E = number of edges
```

## Time Complexity

Building adjacency list:

```
O(E)
```

DFS traversal:

```
O(V + E)
```

Overall:

```
O(V + E)
```

---

## Space Complexity

Adjacency list:

```
O(V + E)
```

Visited set:

```
O(V)
```

DFS recursion stack:

```
O(V)
```

Overall:

```
O(V + E)
```

---

# Common Mistakes

## Forgetting isolated nodes

Example:

```
n = 5

edges = [[0,1]]
```

Nodes:

```
2
3
4
```

are each their own connected component.

The simplest solution is to iterate:

```java
for (int i = 0; i < n; i++)
```

instead of iterating only over nodes in the adjacency list.

---

## Forgetting visited

Without a visited set:

```
0 ↔ 1
```

DFS repeatedly revisits nodes.

---

## Incrementing components inside DFS

Only increment once before starting a new DFS.

Each DFS explores exactly one connected component.

---

# Pattern Recognition

When you see:

- Connected components
- Groups of connected nodes
- Count disconnected graphs

Think:

```
DFS/BFS

+

Visited Set
```

---

# Related Problems

- Number of Islands
- Graph Valid Tree
- Clone Graph
- Course Schedule
- Max Area of Island
- Redundant Connection