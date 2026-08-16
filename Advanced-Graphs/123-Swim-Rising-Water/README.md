# Swim in Rising Water

## Problem

Given an `n × n` grid where:

```text
grid[row][col]
```

represents the elevation of a cell, determine the minimum time required to travel from:

```text
(0, 0)
```

to:

```text
(n - 1, n - 1)
```

You can move up, down, left, or right.

At time `t`, you can only enter cells with:

```text
grid[row][col] <= t
```

Therefore, for any particular path, the required time is the **maximum elevation encountered along that path**.

The goal is to minimize this maximum.

---

# Key Insight

This is a shortest-path problem, but the path cost is unusual.

For a normal weighted graph:

```text
path cost = sum of edge weights
```

Here:

```text
path cost = maximum cell elevation along the path
```

Therefore, we can use a modified form of **Dijkstra's algorithm**.

---

# Dijkstra State

Each priority queue entry stores:

```text
{maxPathHeight, row, col}
```

where:

```text
maxPathHeight
```

means:

> The highest elevation encountered on the path from `(0,0)` to this cell.

The priority queue is ordered by:

```text
maxPathHeight
```

so the cell with the smallest required water level is processed first.

---

# Initial State

Start at:

```text
(0, 0)
```

The maximum elevation encountered is simply:

```text
grid[0][0]
```

Therefore:

```java
minHeap.offer(new int[]{grid[0][0], 0, 0});
```

---

# Main Dijkstra Loop

While the priority queue isn't empty:

```text
1. Remove the cell with the smallest maxPathHeight.
2. If it is the destination, return maxPathHeight.
3. If already visited, skip it.
4. Mark it visited.
5. Examine its four neighbours.
6. Calculate each neighbour's new path cost.
7. Add valid neighbours to the priority queue.
```

---

# Path Cost

Suppose the current path has encountered:

```text
5 → 8 → 3 → 6
```

The required water level is:

```text
8
```

If we move into a cell with elevation `10`:

```text
newPathMax = max(8, 10)
           = 10
```

If we move into a cell with elevation `7`:

```text
newPathMax = max(8, 7)
           = 8
```

Therefore:

```java
int newPathMax =
    Math.max(maxPathHeight, grid[newRow][newCol]);
```

This is the key difference from normal Dijkstra.

---

# Why a Min Heap?

We always want to process the currently reachable cell requiring the smallest water level.

For example:

```text
Heap:

{5, 1, 2}
{7, 2, 1}
{10, 0, 3}
```

We process:

```text
{5, 1, 2}
```

first.

This is analogous to Dijkstra selecting the node with the smallest tentative distance.

---

# Visited Array

Use:

```java
boolean[][] visited
```

to ensure each cell is processed once.

Once:

```java
visited[row][col] = true;
```

the cell has been permanently processed.

Because the priority queue always gives us the smallest current path cost, we can safely finalize the cell when we process it.

---

# Neighbours

There are four possible directions:

```text
right
left
down
up
```

Represent them as:

```java
int[][] directions = {
    {0, 1},
    {0, -1},
    {1, 0},
    {-1, 0}
};
```

For each direction:

```text
newRow = row + direction[0]
newCol = col + direction[1]
```

Then check:

```text
0 <= newRow < rows
0 <= newCol < cols
```

and:

```text
!visited[newRow][newCol]
```

---

# Why Can We Return Immediately at the Destination?

When the destination is removed from the min heap, it has the smallest `maxPathHeight` among all currently available cells.

Therefore, no other unprocessed path can reach the destination with a smaller required water level.

This is the same fundamental greedy property that allows Dijkstra to stop once the destination is extracted from the priority queue.

Therefore:

```java
if (row == grid.length - 1 &&
    col == grid[0].length - 1) {

    return maxPathHeight;
}
```

is safe.

---

# Example

Suppose:

```text
0  2
1  3
```

Possible paths:

### Path 1

```text
0 → 2 → 3
```

Maximum:

```text
3
```

### Path 2

```text
0 → 1 → 3
```

Maximum:

```text
3
```

Therefore:

```text
answer = 3
```

The algorithm explores cells based on the smallest maximum elevation encountered so far.

---

# Why This Is Dijkstra

Normal Dijkstra:

```text
newDistance =
    currentDistance + edgeWeight
```

This problem:

```text
newPathMax =
    max(currentPathMax, neighbourHeight)
```

Everything else is conceptually similar:

```text
Priority Queue
      ↓
Take cheapest state
      ↓
Relax neighbours
      ↓
Repeat
```

The only major difference is how the path cost is calculated.

---

# Algorithm

```text
Create visited[][]

Create min heap ordered by maxPathHeight

Add:
    {grid[0][0], 0, 0}

while heap isn't empty:

    current = remove minimum

    extract:
        maxPathHeight
        row
        col

    if destination:
        return maxPathHeight

    if visited:
        continue

    mark visited

    for each of 4 directions:

        calculate neighbour coordinates

        if valid and unvisited:

            newPathMax =
                max(current maxPathHeight,
                    neighbour elevation)

            add neighbour to heap

return -1
```

---

# Complexity

There are:

```text
n²
```

cells.

Each cell can be inserted into the priority queue multiple times in the straightforward implementation.

With a binary heap, the overall complexity is commonly expressed as:

```text
O(n² log(n²))
```

which simplifies to:

```text
O(n² log n)
```

Space:

```text
O(n²)
```

for:

- `visited`
- priority queue

---

# Pattern Recognition

When you see:

- Grid
- Move between neighbouring cells
- Need to minimize a path's maximum value
- Four-directional movement

Think:

```text
Modified Dijkstra
```

Also consider:

```text
Binary Search + BFS/DFS
```

as an alternative approach.

---

# Key Takeaway

The most important idea is:

```text
Normal shortest path:
    minimize SUM

Swim in Rising Water:
    minimize MAX
```

So instead of:

```text
newDistance = currentDistance + weight
```

we use:

```text
newPathMax =
    max(currentPathMax, grid[newRow][newCol])
```

The priority queue then always explores the path requiring the lowest possible water level next.