# Graph Valid Tree - Notes

## Core Idea

A valid tree requires:

```
Connected
+
No Cycles
```

This is an undirected graph problem.

---

# Approach

Use:

```
DFS + Parent Tracking
```

---

# Build Graph

Since edges are undirected:

For:

```
[0,1]
```

add:

```
0 -> 1

1 -> 0
```

---

# DFS Function

Think of:

```java
dfs(node, parent)
```

meaning:

> Explore this node and check if this component contains a cycle.

---

# Cycle Detection

A node is a cycle if:

```
Already visited

AND

Not the parent
```

Example:

```
0 ---- 1
```

DFS:

```
0
 |
 1
```

At node 1:

```
neighbor = 0
```

Ignore because:

```
0 is parent
```

---

# Why Parent Is Needed

Undirected edges exist twice.

Example:

```
0 -> 1

1 -> 0
```

The reverse edge is not a cycle.

Parent tracking avoids false positives.

---

# DFS Steps

For node:

```text
1. Check if visited
      -> cycle

2. Add to visited

3. Explore neighbours

4. Ignore parent

5. Return true
```

---

# Connectivity

After DFS:

```java
visited.size() == n
```

must be true.

Why?

Because DFS from node 0 only explores one connected component.

---

# Example

Graph:

```
0 --- 1 --- 2
```

DFS:

```
0
|
1
|
2
```

Visited:

```
{0,1,2}
```

If:

```
n = 3
```

Connected.

---

# Invalid Example

Graph:

```
0 --- 1


2 --- 3
```

DFS from 0:

```
visited = {0,1}
```

But:

```
n = 4
```

Not a tree.

---

# Complexity

```
Time: O(V + E)

Space: O(V + E)
```

---

# Template

```java
boolean dfs(node, parent) {

    if(node already visited)
        return false;

    mark visited;

    for(neighbor):

        if(neighbor == parent)
            continue;

        if(!dfs(neighbor, node))
            return false;

    return true;
}
```

---

# Pattern Recognition

Undirected graph:

```
Cycle detection?
```

Use:

```
DFS(node, parent)
```

Tree validation:

```
DFS + visited.size() == n
```

---

# Related Problems

- Number of Connected Components
- Redundant Connection
- Course Schedule
- Clone Graph