# Number of Islands

## Problem

Given an `m x n` grid of:

- `'1'` representing land
- `'0'` representing water

Return the number of islands in the grid.

An island is formed by connected pieces of land.

Connections are only horizontal and vertical:

```
up
down
left
right
```

Diagonal connections do not count.

---

# Example

Input:

```
[
["1","1","0","0"],
["1","0","0","1"],
["0","0","1","1"]
]
```

Output:

```
2
```

Explanation:

Island 1:

```
1 1
1
```

Island 2:

```
    1
  1 1
```

---

# Approach

## DFS Flood Fill

This problem is solved using Depth First Search.

The idea:

> Every time we find unvisited land, we have discovered a new island. Use DFS to mark the entire island as visited.

Algorithm:

1. Traverse every cell in the grid.
2. When a land cell (`'1'`) is found:
    - Increment island count.
    - Run DFS to explore the entire island.
3. DFS changes all connected land cells into water (`'0'`).
4. Continue scanning the grid.

---

# Why Modify The Grid?

Instead of using a separate `visited` array:

```java
boolean[][] visited;
```

we reuse the grid.

When we visit land:

```java
grid[i][j] = '0';
```

This means:

> This cell has already been explored.

Benefits:

- Saves memory
- Simpler implementation

---

# DFS Process

Example:

Starting grid:

```
1 1 0
1 0 0
0 1 1
```

Find:

```
(0,0)
```

Count:

```
islands = 1
```

Run DFS:

```
1 1 0
1 0 0
0 1 1
```

Convert connected land:

```
0 0 0
0 0 0
0 1 1
```

The first island has been removed.

Continue scanning.

---

# DFS Function

```java
dfs(row, col, grid)
```

Meaning:

> Visit all land connected to this position.

---

# DFS Steps

## 1. Check Invalid Cells

Return if:

- Outside grid
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

## 2. Mark Visited

```java
grid[i][j] = '0';
```

Prevent revisiting.

---

## 3. Explore Neighbours

Check:

```java
up
down
left
right
```

```java
dfs(i+1,j,grid);
dfs(i-1,j,grid);
dfs(i,j+1,grid);
dfs(i,j-1,grid);
```

---

# Complexity Analysis

Let:

```
m = rows
n = columns
```

## Time Complexity

```
O(m * n)
```

Every cell is visited at most once.

---

## Space Complexity

```
O(m * n)
```

Worst case:

The entire grid is land.

The DFS recursion stack can contain every cell.

---

# Common Mistakes

## 1. Forgetting to mark visited

Incorrect:

```java
dfs(neighbor);
```

without:

```java
grid[i][j] = '0';
```

This creates infinite recursion.

---

## 2. Counting every land cell

Incorrect:

```
Every '1' = island
```

Example:

```
1 1
1 1
```

is only one island.

DFS groups connected land together.

---

## 3. Counting after DFS

The correct order:

```java
if(grid[i][j]=='1') {

    count++;

    dfs(i,j,grid);

}
```

First discover island, then remove it.

---

# Pattern Recognition

This is a classic DFS flood-fill problem.

Use this pattern for:

- Counting connected regions
- Finding groups
- Marking visited areas

General template:

```java
for(each cell)

    if(valid starting point)

        count++;

        dfs(cell);
```

---

# Related Problems

- Max Area of Island
- Clone Graph
- Surrounded Regions
- Pacific Atlantic Water Flow
- Word Search
- Flood Fill