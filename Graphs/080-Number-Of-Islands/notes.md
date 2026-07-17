# Number of Islands - Notes

## Core Idea

Count connected groups of land in a grid.

The grid contains:

```
1 = land
0 = water
```

An island is a group of connected land cells.

Connections:

```
up
down
left
right
```

---

# Approach

Use:

```
DFS Flood Fill
```

When we find a land cell:

1. Increase island count.
2. Explore all connected land.
3. Mark visited cells as water.

---

# Main Algorithm

Loop through every cell:

```java
for each grid cell
```

If:

```java
grid[i][j] == '1'
```

then:

```java
count++;
dfs(i,j);
```

The DFS removes the entire island.

---

# DFS Function

```java
dfs(i,j,grid)
```

Meaning:

> Explore all land connected to this position.

---

# Base Case

Stop if:

- Outside bounds
- Water
- Already visited

```java
if (
    i < 0 ||
    j < 0 ||
    i >= grid.length ||
    j >= grid[0].length ||
    grid[i][j] == '0'
)
return;
```

---

# Mark Visited

Instead of a visited array:

```java
boolean[][] visited;
```

modify the grid:

```java
grid[i][j] = '0';
```

This prevents revisiting.

---

# Recursive Exploration

Each cell explores four directions:

```java
dfs(i+1,j)
dfs(i-1,j)
dfs(i,j+1)
dfs(i,j-1)
```

Meaning:

```
down
up
right
left
```

---

# Example Walkthrough

Grid:

```
1 1 0
1 0 0
0 1 1
```

Start scanning:

Find:

```
(0,0)
```

Increase:

```
count = 1
```

DFS:

```
1 1
1
```

becomes:

```
0 0
0
```

Remaining:

```
0 0 0
0 0 0
0 1 1
```

Find another land cell.

Increase:

```
count = 2
```

---

# Why Does This Work?

Every island is discovered exactly once.

When DFS starts:

```
1 island found
```

All connected cells are removed.

Therefore:

The next land cell must belong to a different island.

---

# Complexity

Let:

```
m = number of rows
n = number of columns
```

## Time Complexity

```
O(m*n)
```

Every cell is visited once.

---

## Space Complexity

```
O(m*n)
```

Worst case:

The entire grid is one island.

DFS recursion depth can reach every cell.

---

# DFS Grid Template

Remember:

```java
void dfs(row, col)

    if invalid:
        return

    mark visited

    dfs(neighbours)
```

---

# Flood Fill Pattern

Many grid problems follow:

```
Find starting cell
        |
        v
Explore connected cells
        |
        v
Mark visited
```

---

# Related Problems

- Max Area of Island
- Flood Fill
- Surrounded Regions
- Word Search
- Pacific Atlantic Water Flow
- Clone Graph