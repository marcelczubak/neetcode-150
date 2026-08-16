# Swim in Rising Water — Notes

## Pattern

- Graph
- Grid Graph
- Dijkstra
- Priority Queue
- Greedy
- Minimax Path

---

# Core Idea

The grid can be viewed as a graph.

Each cell:

```text
node
```

Each adjacent cell:

```text
edge
```

The unusual part is the definition of path cost.

---

# Path Cost

For a path:

```text
0 → 4 → 2 → 7 → 5
```

the cost isn't:

```text
0 + 4 + 2 + 7 + 5
```

Instead:

```text
max(0, 4, 2, 7, 5)
=
7
```

We need to find the path whose maximum elevation is as small as possible.

This is a **minimax path** problem.

---

# Dijkstra State

Priority queue entry:

```text
{maxPathHeight, row, col}
```

Meaning:

```text
maxPathHeight =
highest elevation encountered
to reach this cell
```

---

# Initial State

```text
{grid[0][0], 0, 0}
```

because the starting cell is already part of the path.

---

# Transition

For neighbour:

```text
(newRow, newCol)
```

calculate:

```text
newPathMax =
max(currentPathMax, grid[newRow][newCol])
```

Then:

```text
offer {
    newPathMax,
    newRow,
    newCol
}
```

---

# Dijkstra Comparison

### Normal Dijkstra

```text
newDistance =
currentDistance + edgeWeight
```

### Swim in Rising Water

```text
newPathMax =
max(currentPathMax, cellHeight)
```

The priority queue still chooses the smallest value.

---

# Visited

Use:

```java
boolean[][] visited
```

When a cell is removed from the priority queue:

```text
if visited:
    skip
```

otherwise:

```text
visited = true
```

This finalizes the cell.

---

# Why We Can Finalize It

The priority queue is ordered by:

```text
maxPathHeight
```

Therefore, when a cell is popped, it has the smallest possible known path cost among all unprocessed cells.

This gives us the same greedy property that Dijkstra relies upon.

---

# Destination

As soon as:

```text
(row, col) == destination
```

when popped from the heap:

```text
return maxPathHeight
```

This is the optimal answer.

---

# Directions

Use:

```java
int[][] directions = {
    {0, 1},
    {0, -1},
    {1, 0},
    {-1, 0}
};
```

For each:

```text
newRow = row + dr
newCol = col + dc
```

Check:

```text
newRow >= 0
newCol >= 0
newRow < rows
newCol < cols
```

and:

```text
!visited[newRow][newCol]
```

---

# Example Mental Model

Suppose current path requires:

```text
water level = 8
```

Neighbour heights:

```text
5
7
10
```

Their new costs are:

```text
max(8, 5)  = 8
max(8, 7)  = 8
max(8, 10) = 10
```

So the heap receives:

```text
8
8
10
```

The first two are preferable because they require no increase in water level.

---

# Why the Priority Queue Is Necessary

A normal BFS would explore cells by:

```text
number of moves
```

But we don't care about the shortest number of moves.

We care about:

```text
minimum maximum elevation
```

The priority queue lets us process cells according to this value.

---

# Common Mistakes

## Mistake 1 — Summing elevations

Don't do:

```text
current + neighbour
```

The cost is the maximum:

```text
max(current, neighbour)
```

---

## Mistake 2 — Returning when destination is added

The first time the destination is **added** to the heap isn't necessarily optimal.

Return when it is:

```text
popped
```

from the min heap.

---

## Mistake 3 — Marking visited when adding

The safest Dijkstra pattern here is:

```text
poll
 ↓
if visited → continue
 ↓
mark visited
```

rather than immediately finalizing when pushing.

---

## Mistake 4 — Using DFS as the final solution

A brute-force DFS can enumerate paths, but there can be exponentially many paths.

Dijkstra avoids exploring all possible paths by always expanding the currently cheapest minimax state.

---

# Alternative Approach

Another valid solution is:

```text
Binary Search + BFS/DFS
```

Binary search a candidate water level `T`.

Ask:

> Can I reach the destination using only cells with elevation `<= T`?

If yes:

```text
T is possible
```

If no:

```text
T is too small
```

Then binary search the minimum valid `T`.

---

# Complexity

For the Dijkstra approach:

```text
V = n²
```

cells.

Using a binary heap:

```text
Time:  O(n² log n)
Space: O(n²)
```

---

# Interview Explanation

"I treat each grid cell as a graph node and use Dijkstra's algorithm, but with a modified path cost. Instead of adding edge weights, the cost of a path is the maximum elevation encountered along it. Each heap entry stores the maximum elevation required to reach a cell. When exploring a neighbour, its new cost is the maximum of the current path cost and that neighbour's elevation. The priority queue processes the cell with the smallest required water level first, so when the destination is removed from the heap, that value is optimal."

---

# Key Takeaway

Remember:

```text
Grid
 ↓
Graph
 ↓
Minimax path
 ↓
Dijkstra
 ↓
Priority Queue
```

And the critical formula:

```text
newPathMax =
max(currentPathMax, neighbourHeight)
```

The problem is essentially:

> **Find the path from top-left to bottom-right that minimizes the maximum elevation encountered.**
```