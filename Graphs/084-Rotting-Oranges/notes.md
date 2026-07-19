# Rotting Oranges Notes

## Pattern

```
Multi-Source BFS
```

All rotten oranges begin spreading simultaneously.

---

# Core Idea

Instead of starting BFS from one node:

```
Queue

A
```

Start from every rotten orange:

```
Queue

A
B
C
```

Each is a source.

---

# BFS Levels

One BFS level represents:

```
1 minute
```

Pattern:

```java
while (!queue.isEmpty()) {

    int size = queue.size();

    for (int i = 0; i < size; i++) {

        // Process one level

    }

    minutes++;
}
```

Only increment minutes after processing the entire level.

---

# Visiting Cells

Fresh orange:

```
1
```

↓

Immediately change to:

```
2
```

before adding to the queue.

This prevents duplicate processing.

No separate visited array is required.

---

# Neighbours

For every rotten orange:

Check:

```
Down

Up

Right

Left
```

Only process:

```
grid[row][col] == 1
```

---

# Final Check

After BFS:

Traverse the grid.

If any fresh orange remains:

```java
return -1;
```

Otherwise:

```java
return minutes;
```

---

# Complexity

Time:

```
O(M × N)
```

Every cell is visited once.

Space:

```
O(M × N)
```

Queue worst case.

---

# Interview Recognition

Keywords:

```
Spread

Infection

Propagation

Every minute

Simultaneously
```

↓

Think:

```
Multi-Source BFS
```

---

# Similar Problems

- Walls and Gates
- 01 Matrix
- Word Ladder
- Open the Lock
- Shortest Path in Binary Matrix