# Min Cost to Connect All Points — Notes

## Pattern

- Graph
- Minimum Spanning Tree
- Prim's Algorithm
- Greedy
- Manhattan Distance

---

# Graph Interpretation

Each point:

```text
(x, y)
```

is a node.

Every pair of points can be connected.

Edge cost:

```text
|x1 - x2| + |y1 - y2|
```

Therefore the graph is effectively a **complete weighted graph**.

---

# What Are We Looking For?

We need to:

```text
Connect ALL points
```

while minimizing:

```text
Total edge cost
```

This is exactly a:

```text
Minimum Spanning Tree
```

---

# Prim's Algorithm

Prim grows one connected component.

Start with:

```text
Point 0
```

Then repeatedly add the cheapest possible new point.

---

# State

## `visited[]`

```java
boolean[] visited
```

Meaning:

```text
Is this point already in the MST?
```

---

## `minCost[]`

```java
int[] minCost
```

Meaning:

```text
Cheapest known cost to connect point i
to ANY point currently in the MST.
```

This is the key state.

---

# Initial State

Choose point `0`.

```text
minCost[0] = 0
```

Everything else:

```text
minCost[i] = ∞
```

---

# Main Loop

Repeat `n` times.

### 1. Select

Find:

```text
unvisited point
with smallest minCost
```

Example:

```text
minCost:

0   7   3   10   5
✓       ↑
        cheapest
```

Choose point `2`.

---

### 2. Add

```text
result += minCost[cheapestPoint]
```

Then:

```java
visited[cheapestPoint] = true;
```

---

### 3. Update

For every unvisited point:

```text
calculate distance from newly added point
```

Manhattan distance:

```text
|x1-x2| + |y1-y2|
```

Then:

```text
minCost[i] =
    min(old minCost[i], new distance)
```

---

# Why Update?

Suppose:

```text
Current minCost[B] = 10
```

because the cheapest connection currently known is:

```text
A → B = 10
```

You then add `C` to the MST.

If:

```text
C → B = 4
```

then:

```text
minCost[B] = 4
```

because `C` provides a cheaper connection.

---

# Mental Model

```text
             MST
              │
       ┌──────┼──────┐
       ↓      ↓      ↓
      A       B      C
                     │
                     │ cheapest edge
                     ↓
                     D
```

At every step:

> Find the cheapest edge leaving the MST.

---

# Important: Select vs Update

Keep these as **two separate phases**.

### Selection

Only use:

```text
minCost[]
```

to decide which point to add.

```text
Find minimum minCost among unvisited points.
```

### Update

After selecting the point:

```text
calculate Manhattan distances
```

from the newly added point to all remaining points.

This separation prevents mixing up the iteration counter with the actual newly selected point.

---

# Why `point` Isn't the New MST Point

If your outer loop is:

```java
for (int point = 0; point < n; point++)
```

then `point` means:

```text
iteration number
```

It does **not** necessarily mean:

```text
newly selected point
```

The actual selected point is:

```text
cheapestPoint
```

This distinction is important when calculating the update distances.

---

# Prim vs Dijkstra

Both use a greedy strategy and can use similar data structures, but they solve different problems.

### Dijkstra

```text
Shortest path from source
```

State:

```text
dist[i] = shortest path from source to i
```

### Prim

```text
Minimum cost to connect everything
```

State:

```text
minCost[i] =
cheapest edge from MST to i
```

---

# Why No Priority Queue?

You can implement Prim with a priority queue, but it isn't necessary here.

The simple approach:

```text
Find minimum by scanning array
```

takes:

```text
O(n)
```

per iteration.

There are `n` iterations:

```text
O(n²)
```

The problem constraints make this approach appropriate.

---

# Common Mistakes

## Mistake 1 — Don't use the outer loop variable as the selected point

The selected point is:

```text
cheapestPoint
```

not:

```text
point
```

---

## Mistake 2 — Don't calculate distances while selecting

Selection asks:

```text
Which minCost is smallest?
```

Update asks:

```text
Does the new point give better minCost values?
```

Keep these separate.

---

## Mistake 3 — Forgetting to update

After adding a new point, you must update:

```text
minCost[]
```

Otherwise future selections won't know about the new edges.

---

## Mistake 4 — Using the maximum instead of minimum

For each point:

```text
minCost[i] =
min(minCost[i], distance)
```

You want the cheapest connection.

---

## Mistake 5 — Thinking in terms of shortest paths

You don't need:

```text
shortest path from point 0 to every point
```

You need:

```text
cheapest collection of edges connecting everything
```

That's MST.

---

# Interview Explanation

"I recognize this as a minimum spanning tree problem because I need to connect every point while minimizing the total edge cost. I use Prim's algorithm. I maintain a visited array and a `minCost` array, where `minCost[i]` is the cheapest edge currently connecting point `i` to the MST. Each iteration I select the unvisited point with the smallest `minCost`, add that cost to the result, mark it visited, and then update the `minCost` values using Manhattan distances from the newly added point."

---

# Complexity

```text
Time:  O(n²)
Space: O(n)
```

---

# Key Takeaway

Remember the three steps:

```text
SELECT
cheapest unvisited point

ADD
its cost to MST

UPDATE
cheapest connection for remaining points
```

And the key state:

```text
visited[i]
→ Is i in the MST?

minCost[i]
→ Cheapest way to connect i to the MST?
```