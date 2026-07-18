# Course Schedule - Notes

## Core Idea

Treat courses as nodes in a directed graph.

```
course

↓

prerequisite
```

The question becomes:

```
Does the graph contain a cycle?
```

If yes:

```
Cannot finish all courses.
```

---

# Approach

Use:

```
DFS + Cycle Detection
```

---

# Graph Representation

Use an adjacency list.

Example:

```
[
 [3,1],
 [3,2],
 [2,0]
]
```

Store:

```
3 -> {1,2}

2 -> {0}
```

---

# DFS Meaning

```
DFS(course)
```

means:

```
Can every prerequisite needed for this course be completed?
```

---

# Visited Set

The visited set represents:

```
Current recursion stack
```

NOT

```
Nodes visited forever
```

Before recursion:

```java
visited.add(course);
```

After recursion:

```java
visited.remove(course);
```

---

# Cycle Detection

If DFS reaches:

```java
visited.contains(course)
```

Then:

```
A prerequisite depends on itself.

Cycle found.
```

Return:

```
false
```

---

# Memoization

After a course is fully processed:

```java
adjacencyList.put(course, new HashSet<>());
```

Meaning:

```
Already verified.

Skip future DFS.
```

This avoids exploring the same prerequisite chain multiple times.

---

# Example

Graph:

```
0

↓

1

↓

2
```

DFS:

```
0

↓

1

↓

2

✓
```

Backtracking:

```
remove(2)

remove(1)

remove(0)
```

Memoize:

```
2 -> {}

1 -> {}

0 -> {}
```

Future DFS immediately returns.

---

# Why Removing From Visited Matters

Suppose:

```
0 → 1

2 → 1
```

After DFS from `0`:

```
visited = {}
```

Now DFS from `2` should still be allowed to visit `1`.

If `1` stayed in visited forever:

```
False cycle detected.
```

---

# Complexity

Let

```
V = courses

E = prerequisites
```

Time:

```
O(V + E)
```

Space:

```
O(V + E)
```

---

# DFS Template

```java
if(node in recursion stack)

    cycle

mark node

visit neighbours

remove node

memoize

return true
```

---

# Pattern Recognition

Whenever you see:

- Circular dependencies
- Scheduling
- Can everything be completed?
- Directed graph cycle detection

Think:

```
DFS

+

Recursion Stack

+

Memoization
```

---

# Related Problems

- Course Schedule II
- Clone Graph
- Graph Valid Tree
- Redundant Connection
- Number of Connected Components
```