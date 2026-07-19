# Redundant Connection - Notes

## Problem Pattern

Given an undirected graph:

- Started as a tree
- One extra edge added
- Find the edge creating the cycle

---

# Key Insight

The redundant edge is:

```
An edge connecting two nodes already connected
```

Two approaches:

1. Incremental DFS
2. Union Find

---

# Approach 1: Incremental DFS

## Idea

Process edges one by one.

Before adding:

```
u --- v
```

check:

```
Can I already reach v from u?
```

---

If yes:

```
Cycle created
Return edge
```

If no:

```
Add edge
```

---

## DFS Purpose

Normal DFS:

```
Find cycles
```

Here:

```
Find path between two nodes
```

Function:

```
dfs(current, target)
```

---

## DFS Base Cases

If:

```
current == target
```

return:

```
true
```

If already visited:

```
false
```

Otherwise:

```
mark visited

search neighbours
```

---

## Complexity

For every edge:

```
DFS
```

Time:

```
O(E(V+E))
```

Space:

```
O(V+E)
```

---

# Approach 2: Union Find

## Main Idea

Maintain connected groups.

Operations:

```
find()
union()
```

---

# Parent Array

Stores the leader of each group.

Initially:

```
parent[i] = i
```

Everyone is their own group.

---

# Find

Returns the representative of a group.

Example:

```
1
|
2
|
3
```

find(3):

```
1
```

---

## Path Compression

Optimization:

```java
parent[x] = find(parent[x]);
```

Flattens the tree.

---

# Union

Combines two groups.

Steps:

```
rootA = find(a)

rootB = find(b)
```

If:

```
rootA == rootB
```

they are already connected.

Cycle.

---

Otherwise:

```
parent[rootA] = rootB
```

Merge groups.

---

# Union Find Template

```java
int[] parent;


find(x):

    if(parent[x] != x)
        parent[x] = find(parent[x])

    return parent[x]



union(a,b):

    rootA = find(a)

    rootB = find(b)

    if(rootA == rootB)
        return false

    parent[rootA] = rootB

    return true
```

---

# Recognition

Use Union Find when:

```
Edges are being added
+
Need to know if components are already connected
```

---

Use DFS/BFS when:

```
Need to explore paths
+
Traverse graph
```

---

# Comparison

DFS:

```
"Can I travel from A to B?"
```

Union Find:

```
"Are A and B already in the same group?"
```

---

# Complexity

DFS:

```
O(E(V+E))
```

Union Find:

```
O(E α(V))
```

Almost:

```
O(E)
```

---

# Interview Takeaway

For Redundant Connection:

The intended solution is usually:

```
Union Find
```

because the problem is about continuously merging components.

DFS is still valid and useful for understanding the graph idea.