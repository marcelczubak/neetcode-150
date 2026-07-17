# Max Area of Island - Notes

## Core Idea

Find the largest connected group of land cells.

Grid:

```
1 = land
0 = water
```

Connected:

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

For every land cell:

1. Calculate the island area.
2. Mark all visited cells.
3. Compare with current maximum.

---

# Main Algorithm

Traverse the grid:

```java
for every cell
```

If:

```java
grid[i][j] == 1
```

Run:

```java
int area = getArea(i,j,grid);
```

Update:

```java
maxArea = Math.max(maxArea, area);
```

---

# DFS Function

```java
getArea(row, col, grid)
```

Returns:

```
size of island connected to this cell
```

---

# DFS Steps

## 1. Check Invalid Cells

Return `0` when:

- Outside bounds
- Water
- Already visited

```java
if invalid:
    return 0;
```

Why `0`?

Because this path contributes no land.

---

## 2. Mark Visited

```java
grid[i][j] = 0;
```

The grid acts as the visited array.

---

## 3. Add Current Cell

Every land cell contributes:

```
1
```

---

## 4. Add Neighbours

Formula:

```
area =
1
+ up
+ down
+ left
+ right
```

Implementation:

```java
return 1
    + dfs(up)
    + dfs(down)
    + dfs(left)
    + dfs(right);
```

---

# Example

Grid:

```
1 1 0
1 0 0
0 1 1
```

First DFS:

```
1 1
1
```

Area:

```
3
```

Second DFS:

```
1 1
```

Area:

```
2
```

Answer:

```
max(3,2)

= 3
```

---

# Important Difference

Number of Islands:

```
count how many DFS calls happen
```

Max Area:

```
return the size of each DFS
```

---

# Why Modify The Grid?

Alternative:

```java
boolean[][] visited;
```

But changing:

```java
1 -> 0
```

is simpler.

A visited land cell becomes water.

---

# Complexity

Let:

```
m = rows
n = columns
```

## Time

```
O(m*n)
```

Each cell visited once.

---

## Space

```
O(m*n)
```

Worst case recursion depth.

---

# DFS Grid Template

Remember:

```java
dfs(row,col)

    if invalid:
        return 0

    mark visited

    return value + dfs(neighbours)
```

---

# Recognition Pattern

If the problem asks:

- Largest connected area
- Count connected regions
- Find groups
- Flood fill

Think:

```
DFS / BFS on grid
```

---

# Related Problems

- Number of Islands
- Flood Fill
- Surrounded Regions
- Pacific Atlantic Water Flow
- Word Search
```