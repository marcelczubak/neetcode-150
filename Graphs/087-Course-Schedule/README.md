# Course Schedule

## Problem

There are `numCourses` courses labelled from `0` to `numCourses - 1`.

You are given an array:

```
prerequisites[i] = [a, b]
```

Meaning:

> To take course `a`, you must first complete course `b`.

Determine whether it is possible to finish every course.

---

# Example 1

Input:

```
numCourses = 2

prerequisites =

[
 [1,0]
]
```

Graph:

```
0 → 1
```

Output:

```
true
```

---

# Example 2

Input:

```
numCourses = 2

[
 [1,0],
 [0,1]
]
```

Graph:

```
0 → 1
↑     |
|_____|
```

Output:

```
false
```

Explanation:

There is a cycle.

---

# Key Observation

This problem asks:

> Does the directed graph contain a cycle?

If **any cycle exists**, at least one course depends on itself indirectly.

Therefore:

```
Impossible to finish all courses.
```

---

# Approach

## DFS + Cycle Detection

Treat every course as a graph node.

Each prerequisite is a directed edge:

```
course
   ↓
prerequisite
```

Example:

```
[3,1]
```

means

```
3 → 1
```

---

# Build the Graph

Use an adjacency list.

Example:

```
[
 [3,1],
 [3,2],
 [2,0]
]
```

Becomes:

```
3 -> {1,2}

2 -> {0}

1 -> {}

0 -> {}
```

---

# DFS

For every course:

```
DFS(course)
```

DFS explores every prerequisite recursively.

---

# Cycle Detection

Maintain a set:

```java
visited
```

This does **not** mean:

```
already explored forever
```

It means:

```
currently on this DFS path
```

If DFS reaches a node already in `visited`:

```
cycle detected
```

Return:

```
false
```

---

# Backtracking

Before exploring:

```java
visited.add(course);
```

After finishing:

```java
visited.remove(course);
```

This is exactly like recursive backtracking.

The set always represents the current recursion stack.

---

# Memoization

After successfully exploring a course:

```java
adjacencyList.put(course, new HashSet<>());
```

Meaning:

```
This course has already been verified.

No need to DFS again.
```

Future DFS calls immediately return.

This prevents repeated work.

---

# Example Walkthrough

Graph:

```
3 → 2 → 1

      ↓

      0
```

DFS:

```
3

↓

2

↓

1

✓
```

Backtrack:

```
remove(1)

remove(2)

remove(3)
```

Now:

```
2 -> {}

3 -> {}
```

Future DFS calls terminate immediately.

---

# Why It Works

A course can only be completed if every prerequisite can also be completed.

DFS recursively checks every dependency.

If a cycle exists:

```
A depends on B

↓

B depends on C

↓

C depends on A
```

Eventually DFS revisits a node already in the recursion stack.

Cycle detected.

---

# Complexity Analysis

Let

```
V = courses

E = prerequisites
```

## Time Complexity

```
O(V + E)
```

Each course is explored once.

Each edge is explored once.

Memoization prevents repeated DFS.

---

## Space Complexity

```
O(V + E)
```

Adjacency list:

```
O(V + E)
```

Recursion stack:

```
O(V)
```

Visited set:

```
O(V)
```

---

# Common Mistakes

## Using one visited set

Many beginners write:

```java
visited.add(node);

...

if(visited.contains(node))
```

without removing it.

This incorrectly marks nodes forever.

You need the set to represent:

```
Current recursion path
```

not

```
Ever visited
```

---

## Forgetting memoization

Without clearing completed prerequisite lists:

```java
adjacencyList.put(course, new HashSet<>());
```

The same subgraphs are explored repeatedly.

---

## Thinking this is BFS

Although the graph is directed, this solution is naturally DFS because recursion follows prerequisite chains.

---

# Pattern Recognition

This is a classic:

```
Graph

↓

Cycle Detection

↓

DFS + Recursion Stack
```

Whenever a problem asks:

- Can everything be completed?
- Is there a circular dependency?
- Is the graph acyclic?

Think:

```
DFS + Cycle Detection
```

---

# Related Problems

- Clone Graph
- Graph Valid Tree
- Course Schedule II
- Redundant Connection
- Number of Connected Components