# Course Schedule II

## Problem

There are `numCourses` courses labelled from:

```
0 -> numCourses - 1
```

You are given prerequisites where:

```
prerequisites[i] = [a, b]
```

means:

> To take course `a`, you must first complete course `b`.

Return a valid ordering of courses that allows all courses to be completed.

If no valid ordering exists because of a cycle, return an empty array.

---

# Example 1

Input:

```
numCourses = 2

prerequisites = [[1,0]]
```

Graph:

```
1 -> 0
```

Output:

```
[0,1]
```

Explanation:

Course 0 must be completed before course 1.

---

# Example 2

Input:

```
numCourses = 2

prerequisites = [[1,0],[0,1]]
```

Graph:

```
0 -> 1
↑    |
|____|
```

Output:

```
[]
```

Explanation:

There is a cycle, so completion is impossible.

---

# Key Observation

This problem is a **topological sorting** problem.

A valid course order exists only if the directed graph has:

```
No cycles
```

Therefore:

```
DFS + Cycle Detection + Topological Ordering
```

---

# Approach

## 1. Build an adjacency list

Store:

```
course -> prerequisites
```

Example:

```
[
 [1,0],
 [2,0],
 [2,1]
]
```

becomes:

```
1 -> {0}

2 -> {0,1}
```

---

# 2. DFS Traversal

For each course:

```
DFS(course)
```

The DFS checks:

> Can all prerequisites required by this course be completed?

---

# 3. Detect Cycles

Maintain:

```java
visited
```

The visited set represents:

```
Courses currently in the recursion stack
```

NOT:

```
All courses ever visited
```

---

Example cycle:

```
0 -> 1 -> 2 -> 0
```

DFS:

```
visit 0

visit 1

visit 2

visit 0 again
```

Since `0` is already in the current path:

```
cycle detected
```

Return:

```
false
```

---

# 4. Add Course After DFS

A course can only be completed after all prerequisites are completed.

Therefore:

```java
result.add(course);
```

happens after visiting all neighbours.

This is called:

```
postorder DFS
```

---

Example:

Graph:

```
3 -> 2 -> 1 -> 0
```

DFS order:

```
3
 |
 2
 |
 1
 |
 0
```

Return order:

```
0
1
2
3
```

The return order is the valid course schedule.

---

# 5. Memoization

After a course is successfully processed:

```java
adjacencyList.put(course, new HashSet<>());
```

This marks:

```
Course is already verified
```

Future DFS calls immediately skip it.

This avoids repeating work.

---

# Why Backtracking?

During DFS:

```java
visited.add(course);
```

Explore prerequisites.

After completion:

```java
visited.remove(course);
```

This removes the course from the current recursion path.

The visited set acts like a recursion stack.

---

# Complexity Analysis

Let:

```
V = number of courses

E = number of prerequisite relationships
```

## Time Complexity

```
O(V + E)
```

Each course is processed once.

Each prerequisite edge is explored once.

---

## Space Complexity

```
O(V + E)
```

Adjacency list:

```
O(V + E)
```

Visited set:

```
O(V)
```

Recursion stack:

```
O(V)
```

---

# Common Mistakes

## Adding courses before prerequisites

Wrong:

```java
result.add(course);

dfs(prerequisites);
```

The course appears before dependencies.

---

## Using visited incorrectly

Wrong:

```java
visited.add(course);
```

and never removing it.

This incorrectly detects cycles.

Correct:

```java
visited.add(course);

// DFS

visited.remove(course);
```

---

## Forgetting cycle detection

A graph can contain:

```
A -> B -> C -> A
```

Without checking cycles, DFS will never finish.

---

# Pattern Recognition

When you see:

- Ordering dependencies
- Prerequisites
- Build systems
- Task scheduling

Think:

```
Directed Graph

+

Topological Sort

+

Cycle Detection
```

---

# Related Problems

- Course Schedule
- Clone Graph
- Graph Valid Tree
- Alien Dictionary
- Parallel Courses