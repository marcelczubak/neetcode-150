# Islands and Treasure

## Problem

You are given an `m x n` grid where:

- `0` = Treasure chest (gate)
- `-1` = Water / Wall (cannot pass)
- `INF` (`2147483647`) = Empty land

For every empty land cell, fill it with the **distance to its nearest treasure chest**.

If a cell cannot reach any treasure, it should remain `INF`.

The grid must be modified **in-place**.

---

# Example

Input:

```
INF  -1   0   INF
INF INF INF  -1
INF  -1 INF  -1
 0   -1 INF INF
```

Output:

```
 3  -1  0  1
 2   2  1 -1
 1  -1  2 -1
 0  -1  3  4
```

---

# Key Observation

Every treasure chest spreads outward at the same time.

Instead of running a BFS from every empty land cell (which would be expensive), we reverse the thinking:

> Start BFS from every treasure chest simultaneously.

This is a **Multi-Source BFS** problem.

---

# Approach

## Step 1: Add all treasure chests to the queue

Traverse the grid once.

Whenever a treasure chest (`0`) is found:

- Add its coordinates to the queue
- Mark it as visited

Initially:

```
Queue:

Treasure A
Treasure B
Treasure C
```

These are all BFS starting points.

---

## Step 2: Perform BFS level-by-level

Each BFS level represents one unit of distance.

```
Distance = 0

Queue:
All treasure chests
```

Process every treasure.

---

Next level:

```
Distance = 1

Queue:
Every cell one step away
```

Continue until the queue is empty.

---

## Step 3: Update distances

Whenever a cell is removed from the queue:

```
grid[row][col] = currentDistance;
```

Because BFS guarantees the first visit is the shortest path, this is always the minimum distance to a treasure.

---

## Step 4: Expand to neighbours

For every processed cell:

Check:

- Up
- Down
- Left
- Right

If the neighbour:

- Is inside the grid
- Is not water (`-1`)
- Has not been visited

Then:

- Mark visited
- Add to the queue

---

# Why BFS?

Suppose two treasure chests exist:

```
T . . . T
```

A land cell should use the **closest** treasure.

BFS explores outward evenly from every treasure simultaneously.

The first time a cell is reached is guaranteed to be its shortest distance.

DFS cannot guarantee this.

---

# Complexity

Let:

- M = rows
- N = columns

Every cell enters the queue at most once.

Time:

```
O(M × N)
```

Space:

```
O(M × N)
```

for the queue and visited array.

---

# Pattern

This is another classic **Multi-Source BFS**.

General pattern:

```
Collect every source

↓

Push every source into queue

↓

Run BFS level-by-level

↓

Each level represents distance
```

---

# Related Problems

- Rotting Oranges
- 01 Matrix
- Walls and Gates
- Shortest Path in Binary Matrix
- Word Ladder