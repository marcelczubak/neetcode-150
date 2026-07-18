# Graph Valid Tree

## Problem

Given:

- `n` nodes labelled from `0` to `n - 1`
- An array of undirected edges

Determine whether the graph forms a valid tree.

A valid tree must satisfy two conditions:

1. It is **connected**
2. It contains **no cycles**

---

# Example 1

Input:

```
n = 5

edges =
[
 [0,1],
 [0,2],
 [0,3],
 [1,4]
]
```

Graph:

```
      0
    / | \
   1  2  3
   |
   4
```

Output:

```
true
```

The graph is connected and contains no cycles.

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
 [1,3],
 [1,4]
]
```

Graph:

```
0 - 1 - 2
    \   /
      3

    |
    4
```

Output:

```
false
```

There is a cycle:

```
1 -> 2 -> 3 -> 1
```

---

# Key Observation

A tree is:

```
Undirected Graph

+

Connected

+

Acyclic
```

Therefore:

```
Valid Tree = DFS + Cycle Detection + Connectivity Check
```

---

# Approach

## 1. Build an Adjacency List

Because the graph is undirected, every edge is stored in both directions.

For:

```
[0,1]
```

Store:

```
0 -> 1

1 -> 0
```

Example:

Edges:

```
[
 [0,1],
 [0,2]
]
```

Adjacency list:

```
0 -> {1,2}

1 -> {0}

2 -> {0}
```

---

# 2. DFS Traversal

Start DFS from node `0`.

Maintain:

```java
visited
```

The set stores nodes that have already been explored in the current traversal.

---

# 3. Detect Cycles

In an undirected graph, every node points back to its parent.

Example:

```
0 ---- 1
```

Adjacency list:

```
0 -> {1}

1 -> {0}
```

When DFS reaches `1`, seeing `0` again is not a cycle.

It is just the edge we came from.

Therefore DFS also tracks:

```java
parent
```

---

Cycle condition:

```
Neighbor is already visited
AND
Neighbor is not the parent
```

means:

```
Cycle found
```

---

# DFS Logic

For each node:

1. If already visited:
   - cycle detected

2. Mark visited

3. Visit all neighbours

4. Ignore the edge back to parent

5. Continue recursively

---

# Connectivity Check

DFS starting from node `0` only explores one component.

Example:

```
0 --- 1


2 --- 3
```

No cycle exists.

However:

```
visited.size() != n
```

so it is not a tree.

After DFS:

```java
visited.size() == n
```

must be true.

---

# Why Parent Tracking?

Unlike directed graphs, undirected graphs have duplicate edges.

Example:

```
A ---- B
```

becomes:

```
A -> B

B -> A
```

Without parent tracking:

```
A -> B -> A
```

would incorrectly appear as a cycle.

The parent tells DFS:

> Ignore the node we came from.

---

# Complexity Analysis

Let:

```
V = number of vertices

E = number of edges
```

## Time Complexity

Building adjacency list:

```
O(E)
```

DFS:

```
O(V + E)
```

Each node and edge is processed once.

Total:

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

Total:

```
O(V + E)
```

---

# Common Mistakes

## Forgetting the parent

Incorrect:

```java
if (visited.contains(neighbor))
    return false;
```

This treats the edge back to the parent as a cycle.

---

## Not checking connectivity

Only checking:

```
No cycles
```

is not enough.

A graph with multiple components is not a tree.

---

## Not propagating DFS failures

Incorrect:

```java
dfs(neighbor);
```

Correct:

```java
if (!dfs(neighbor))
    return false;
```

---

# Pattern Recognition

When you see:

- Undirected graph
- Determine if it is a tree
- Detect cycles

Think:

```
DFS(node, parent)
```

with:

```
visited set
+
parent tracking
+
connectivity check
```

---

# Related Problems

- Number of Connected Components
- Redundant Connection
- Course Schedule
- Clone Graph
- Pacific Atlantic Water Flow