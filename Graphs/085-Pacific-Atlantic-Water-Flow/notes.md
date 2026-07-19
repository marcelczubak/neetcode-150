# Pacific Atlantic Water Flow Notes

## Pattern

```
Reverse DFS
```

Run DFS from the destinations instead of every starting point.

---

# Main Insight

Naive approach:

```
Every cell

↓

DFS to Pacific

↓

DFS to Atlantic
```

Time:

```
O((M×N)²)
```

Too slow.

---

Instead:

```
Pacific

↓

DFS outward

↓

Mark reachable cells
```

Do the same for Atlantic.

---

# Why Reverse?

Water normally flows:

```
High

↓

Low
```

Reverse DFS travels:

```
Low

↑

High
```

Therefore:

```
nextHeight >= currentHeight
```

must hold.

---

# DFS Parameters

```java
dfs(row, col, visited, previousHeight)
```

Base case:

```java
if (
    out of bounds ||
    visited ||
    currentHeight < previousHeight
)
return;
```

---

# Visited Arrays

Two independent traversals.

```java
boolean[][] pacific;

boolean[][] atlantic;
```

After DFS:

```
pacific[r][c]

=

can reach Pacific
```

```
atlantic[r][c]

=

can reach Atlantic
```

---

# Final Answer

A cell belongs in the result if:

```java
pacific[r][c] &&
atlantic[r][c]
```

---

# Complexity

Time:

```
O(M×N)
```

Each DFS visits every cell once.

Space:

```
O(M×N)
```

Visited arrays + recursion stack.

---

# Interview Recognition

Keywords:

```
Reach destination

Flow

Can reach both

Multiple borders
```

↓

Think:

```
Reverse DFS/BFS
```

---

# General Reverse Search Pattern

Instead of:

```
Every source

↓

Find destination
```

Do:

```
Destination

↓

Find every source
```

Often reduces:

```
Many DFS

↓

One DFS
```

---

# Similar Problems

- Walls and Gates
- Rotting Oranges
- Number of Islands
- Surrounded Regions
- Flood Fill