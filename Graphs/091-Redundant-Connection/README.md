# Redundant Connection

## Problem

You are given an undirected graph that started as a tree with `n` nodes.

One additional edge was added, creating a cycle.

Return the edge that can be removed to restore the graph back into a valid tree.

---

# Example

Input:

```
edges =
[
 [1,2],
 [1,3],
 [2,3]
]
```

Graph progression:

Add:

```
1 --- 2
```

No cycle.

Add:

```
1 --- 3
```

No cycle.

Add:

```
2 --- 3
```

Creates:

```
    1
   / \
  2---3
```

The redundant edge is:

```
[2,3]
```

Output:

```
[2,3]
```

---

# Key Observation

A redundant connection is an edge where:

```
Both endpoints already belong to the same connected component
```

Adding that edge creates a cycle.

There are two main approaches:

1. Incremental DFS
2. Union Find (Disjoint Set Union)

---

# Approach 1: Incremental DFS

## Idea

Process edges one at a time.

Do not immediately add an edge.

Before adding:

```
[u,v]
```

ask:

> Is there already a path between u and v?

If yes:

```
Adding this edge creates a cycle
```

Return the edge.

If no:

```
Safely add the edge
```

---

# Example

Edges:

```
[1,2]
[1,3]
[2,3]
```

Start:

```
Graph = empty
```

---

## Edge [1,2]

Check:

```
Can we reach 2 from 1?
```

No.

Add:

```
1 --- 2
```

---

## Edge [1,3]

Check:

```
Can we reach 3 from 1?
```

No.

Add:

```
    1
   / \
  2   3
```

---

## Edge [2,3]

Check:

```
Can we reach 3 from 2?
```

Yes:

```
2 -> 1 -> 3
```

Therefore:

```
[2,3] creates a cycle
```

Return it.

---

# DFS Logic

DFS does not detect a cycle here.

Instead it answers:

```
Can I reach target?
```

Function:

```java
dfs(current, target)
```

Returns:

```
true  -> path exists

false -> no path
```

---

# Incremental DFS Complexity

For every edge:

```
Run DFS
```

DFS:

```
O(V + E)
```

For all edges:

```
Time: O(E(V + E))
```

Space:

```
O(V + E)
```

---

# Approach 2: Union Find (Disjoint Set Union)

## Idea

Instead of storing the graph, maintain groups of connected nodes.

Union Find supports two operations:

---

## Find

Question:

```
Which group does this node belong to?
```

Example:

```
1
|
2
|
3
```

All belong to the same group.

Therefore:

```
find(1)
find(2)
find(3)
```

return the same representative.

---

## Union

Question:

```
Merge these two groups together
```

Example:

Before:

```
1      4
|
2      5
```

After:

```
union(2,5)
```

Everything becomes one connected group.

---

# Union Find Algorithm

Initially:

```
Every node is its own group
```

Example:

```
1

2

3
```

Parent array:

```
parent[1] = 1
parent[2] = 2
parent[3] = 3
```

---

For every edge:

```
[u,v]
```

Find their leaders:

```
rootU = find(u)

rootV = find(v)
```

---

If:

```
rootU == rootV
```

They are already connected.

Adding the edge creates a cycle.

Return:

```
[u,v]
```

---

Otherwise:

Merge:

```
parent[rootU] = rootV
```

---

# Union Find Example

Edges:

```
[1,2]
[1,3]
[2,3]
```

Initial:

```
1   2   3
```

---

Process:

```
[1,2]
```

Different groups:

```
union(1,2)
```

Now:

```
1
|
2
```

---

Process:

```
[1,3]
```

Different groups:

```
union(1,3)
```

Now:

```
    1
   / \
  2   3
```

---

Process:

```
[2,3]
```

Check:

```
find(2)

find(3)
```

Both return:

```
1
```

Already connected.

Therefore:

```
[2,3]
```

is redundant.

---

# Union Find Optimizations

## Path Compression

Without optimization:

```
1
|
2
|
3
|
4
```

Finding 4 requires walking upwards.

With path compression:

```java
parent[x] = find(parent[x]);
```

future lookups become faster.

---

# Java Implementation Structure

## Parent Array

```java
int[] parent;
```

Stores each node's parent.

---

## Initialization

```java
for(int i = 1; i < parent.length; i++) {
    parent[i] = i;
}
```

Each node starts as its own group.

---

## Find

```java
private int find(int x) {

    if(parent[x] != x) {
        parent[x] = find(parent[x]);
    }

    return parent[x];
}
```

---

## Union

```java
private boolean union(int a, int b) {

    int rootA = find(a);
    int rootB = find(b);

    if(rootA == rootB)
        return false;

    parent[rootA] = rootB;

    return true;
}
```

---

# Complexity Comparison

| Approach | Time | Space |
|---|---|---|
| Incremental DFS | O(E(V+E)) | O(V+E) |
| Union Find | O(E α(V)) | O(V) |

`α(V)` is the inverse Ackermann function and is practically constant.

---

# When To Use Which

## DFS

Use when:

- You already have a graph
- You need traversal
- You need to explore paths

Examples:

- Number of Islands
- Graph Valid Tree
- Clone Graph

---

## Union Find

Use when:

- Edges are added one-by-one
- You repeatedly ask if nodes are connected
- You need to merge components

Examples:

- Redundant Connection
- Accounts Merge
- Kruskal's Algorithm

---

# Pattern Recognition

If you see:

```
Adding edges
+
Detect if cycle forms
```

Think:

```
Union Find
```

If you see:

```
Explore graph
+
Find paths
```

Think:

```
DFS/BFS
```

---

# Related Problems

- Graph Valid Tree
- Number of Connected Components
- Accounts Merge
- Kruskal's Minimum Spanning Tree
- Number of Islands