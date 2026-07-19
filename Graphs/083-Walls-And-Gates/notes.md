# Islands and Treasure Notes

## Pattern

```
Multi-Source BFS
```

Multiple starting nodes.

---

# Core Idea

Instead of asking:

```
For every land cell,
find the closest treasure.
```

Reverse the problem:

```
Start from every treasure.

Spread outward.

Record the distance.
```

This computes every shortest distance in one BFS.

---

# Queue Initialization

Traverse the grid.

Whenever:

```
grid[row][col] == 0
```

Add:

```java
queue.offer(new int[]{row, col});
```

Mark visited.

---

# BFS Levels

Each BFS level equals one distance.

Template:

```java
while (!queue.isEmpty()) {

    int size = queue.size();

    for (int i = 0; i < size; i++) {

        // process one distance level

    }

    distance++;
}
```

---

# Updating Distance

Every time a cell is removed:

```java
grid[row][col] = distance;
```

The first visit is always the shortest path because BFS expands uniformly.

---

# Visiting Neighbours

For each processed cell:

```
Down

Up

Right

Left
```

Only enqueue cells that:

- are inside the grid
- are not walls
- have not already been visited

---

# Visited Array

Unlike Rotting Oranges, we cannot simply overwrite every cell immediately to mark it visited because we still need to distinguish walls and treasures cleanly.

A separate:

```java
boolean[][] visited;
```

prevents revisiting cells.

*(Note: An alternative implementation avoids `visited` entirely by checking whether a neighbour is still `INF` before enqueueing it. This reduces the extra space from `O(M×N)` to `O(1)` beyond the queue.)*

---

# Complexity

Time:

```
O(M × N)
```

Every cell processed once.

Space:

```
O(M × N)
```

Queue + visited array.

---

# Interview Recognition

Keywords:

```
Nearest gate

Nearest treasure

Minimum distance

Multiple starting points
```

↓

Think:

```
Multi-Source BFS
```

---

# Difference from Rotting Oranges

**Rotting Oranges**

- Spread infection
- Count minutes

**Islands and Treasure**

- Spread distance
- Fill shortest distances

The BFS pattern is identical.

---

# Similar Problems

- Rotting Oranges
- Walls and Gates
- 01 Matrix
- Word Ladder
- Open the Lock
```