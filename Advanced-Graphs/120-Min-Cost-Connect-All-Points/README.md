# Min Cost to Connect All Points

## Problem

Given an array of points on a 2D plane, connect all points with the minimum possible total cost.

The cost of connecting two points is their Manhattan distance:

```text
|x1 - x2| + |y1 - y2|
```

Every pair of points can be connected.

---

## Example

### Input

```text
points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
```

### Output

```text
20
```

The goal is to select connections that connect every point while minimizing the total cost.

---

# Key Insight

This is a **Minimum Spanning Tree (MST)** problem.

Each point is a graph node.

Every possible connection between two points is an edge.

The edge weight is:

```text
Manhattan distance
```

We need to find the minimum-cost set of edges that connects every node.

---

# Approach

Use **Prim's Algorithm**.

Prim's algorithm grows the MST one node at a time.

At every step:

1. Find the cheapest unconnected point.
2. Add it to the MST.
3. Update the cheapest connection for every remaining point.

---

# Data Structures

## `visited[]`

```java
boolean[] visited
```

Tracks whether a point is already part of the MST.

```text
visited[i] = true
```

means point `i` has already been connected.

---

## `minCost[]`

```java
int[] minCost
```

Stores:

> The cheapest known edge connecting point `i` to any point already in the MST.

For example:

```text
Point:      0   1   2   3   4
minCost:    0   7   3   9   5
```

The next point selected would be point `2`, because its cheapest connection costs `3`.

---

# Initialisation

Choose point `0` as the starting point.

Therefore:

```text
minCost[0] = 0
```

All other points initially have:

```text
Integer.MAX_VALUE
```

because we haven't established a connection to them yet.

---

# Prim's Algorithm

Repeat `n` times.

## Step 1 — Select

Search through all unvisited points.

Find the point with the smallest:

```text
minCost[i]
```

This is the cheapest point to add to the current MST.

---

## Step 2 — Add

Add its connection cost to the total:

```text
result += cheapestCost
```

Then mark it as connected:

```text
visited[cheapestPoint] = true
```

---

## Step 3 — Update

Now that the new point has joined the MST, it may provide cheaper connections to other points.

For every unvisited point:

```text
distance =
    |newPoint.x - point.x|
    +
    |newPoint.y - point.y|
```

Then update:

```text
minCost[i] =
    min(minCost[i], distance)
```

This means:

> Keep whichever is cheaper: the old connection or the connection through the newly added point.

---

# Example

Suppose the current MST contains:

```text
A
```

and the remaining points are:

```text
B   C   D
```

Their cheapest connections might be:

```text
B → 5
C → 2
D → 8
```

Choose `C`:

```text
total += 2
```

Now:

```text
MST = {A, C}
```

Suppose `C` provides these distances:

```text
C → B = 3
C → D = 4
```

Update:

```text
B: min(5, 3) = 3
D: min(8, 4) = 4
```

Now the next cheapest point is `B`.

---

# Why This Works

At every step, Prim's algorithm chooses the cheapest edge connecting the current MST to an unconnected point.

This greedy choice is guaranteed to produce a minimum spanning tree.

The important invariant is:

```text
minCost[i]
```

always represents the cheapest known way to connect `i` to the current MST.

---

# Important Distinction

This is **not Dijkstra**.

### Dijkstra

Asks:

> What is the shortest path from a source to each node?

### Prim

Asks:

> What is the cheapest edge that expands my current connected component?

For this problem:

```text
Connect everything
        ↓
Minimum Spanning Tree
        ↓
Prim's Algorithm
```

---

# Why We Don't Need Sets

You could use Sets, but they aren't necessary.

Use:

```java
boolean[] visited
```

because every point has an integer index.

There are only two possibilities:

```text
visited[i] = true
```

or:

```text
visited[i] = false
```

The `minCost[]` array stores the additional information needed for Prim's algorithm.

---

# Complexity

There are `n` points.

Each iteration scans all `n` points to find the cheapest unvisited point.

Then it scans all `n` points again to update costs.

Therefore:

```text
Time: O(n²)
```

The arrays contain `n` elements:

```text
Space: O(n)
```

This is an excellent solution for the problem.

---

# Pattern Recognition

When you see:

- Connect all nodes
- Minimize total connection cost
- No requirement for shortest paths from a particular source

Think:

```text
Minimum Spanning Tree
```

Then consider:

```text
Prim
Kruskal
```

For this problem, Prim's algorithm with arrays is particularly clean.

---

# Key Takeaway

The entire algorithm can be remembered as:

```text
SELECT
↓
Find cheapest unvisited point

ADD
↓
Add its cost to answer
Mark it visited

UPDATE
↓
Use the new point to improve
connections to remaining points

REPEAT
```

The most important array is:

```text
minCost[i]
```

which means:

> **Cheapest edge currently available to connect point `i` to the MST.**