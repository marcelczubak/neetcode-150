# Number of Connected Components in an Undirected Graph - Notes

## Core Idea

Each DFS traversal discovers exactly one connected component.

```
New DFS

↓

New Component
```

---

# Graph Representation

Store the graph as an adjacency list.

Because the graph is undirected:

```
A ↔ B
```

becomes

```
A -> B

B -> A
```

---

# Algorithm

For every node:

```
if not visited

    DFS(node)

    components++
```

DFS marks the entire connected component.

---

# DFS

```java
if (visited.contains(node))
    return;

visited.add(node);

for (neighbor)

    dfs(neighbor);
```

Simple graph traversal.

---

# Why It Works

DFS explores every node reachable from the starting node.

Therefore:

One DFS

=

One connected component.

---

# Example

Graph:

```
0 --- 1 --- 2

3 --- 4
```

Traversal:

```
DFS(0)

↓

0,1,2
```

Component count:

```
1
```

Next unvisited node:

```
3
```

DFS:

```
3,4
```

Component count:

```
2
```

---

# Complexity

```
Time: O(V + E)

Space: O(V + E)
```

---

# Interview Tips

If asked:

> "How do you count connected components?"

Think:

```
Every new DFS/BFS

=

One component
```

---

# Common Pitfalls

❌ Forgetting isolated nodes

Always iterate:

```java
for (int i = 0; i < n; i++)
```

instead of only iterating over nodes that appear in the adjacency list.

---

❌ Forgetting the visited set

Without it:

```
0 ↔ 1
```

causes infinite recursion.

---

❌ Incrementing the answer inside DFS

Increment only once when starting DFS.

---

# Pattern Recognition

Keywords:

- Connected components
- Groups
- Reachable nodes
- Undirected graph

Usually indicate:

```
DFS/BFS + Visited
```

---

# Related Problems

- Number of Islands
- Max Area of Island
- Graph Valid Tree
- Clone Graph
- Course Schedule
```