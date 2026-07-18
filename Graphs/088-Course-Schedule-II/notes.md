# Course Schedule II - Notes

## Problem Type

Graph + Topological Sort

Need to:

1. Detect cycles
2. Return a valid ordering

---

# Graph Representation

Store:

```
course -> prerequisites
```

Example:

```
1 -> 0

2 -> 0,1
```

---

# DFS Idea

`dfs(course)` means:

```
Can this course be completed?
```

Check all prerequisites recursively.

---

# Cycle Detection

Use:

```java
Set<Integer> visited
```

The set represents:

```
Current recursion path
```

Example:

```
0 -> 1 -> 2 -> 0
```

When reaching 0 again:

```
visited contains 0
```

Cycle found.

---

# DFS Steps

For every course:

```
1. Check if already in recursion stack

2. Mark as visited

3. DFS all prerequisites

4. Remove from visited

5. Add course to result
```

---

# Why Add After DFS?

A course depends on its prerequisites.

Therefore:

```
prerequisites first
course afterwards
```

Example:

```
2 -> 1 -> 0
```

DFS returns:

```
0
1
2
```

This is the correct ordering.

---

# Memoization

After processing:

```java
adjacencyList.put(course, new HashSet<>());
```

means:

```
Course already checked successfully.
```

No need to explore again.

---

# Backtracking Concept

During recursion:

```java
visited.add(course);
```

Explore.

Then:

```java
visited.remove(course);
```

Undo the choice.

The set always represents the current DFS path.

---

# Complexity

```
Time:  O(V + E)

Space: O(V + E)
```

---

# Template

```java
boolean dfs(node) {

    if(node in current path)
        cycle

    mark node

    for(neighbour)
        dfs(neighbour)

    remove node from path

    add node to answer

    return true
}
```

---

# Difference From Course Schedule I

Course Schedule I:

```
Return true/false
```

Course Schedule II:

```
Return the topological ordering
```

The DFS logic is almost identical.

The only addition:

```java
result.add(course);
```

after all prerequisites are complete.

---

# Pattern

Dependencies?

Think:

```
Graph

↓

DFS

↓

Cycle Detection

↓

Topological Sort
```

---

# Related Problems

- Course Schedule
- Clone Graph
- Alien Dictionary
- Graph Valid Tree