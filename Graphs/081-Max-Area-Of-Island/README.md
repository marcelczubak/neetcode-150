# Max Area of Island

## Problem

Given an `m x n` binary grid:

- `1` represents land
- `0` represents water

Find the maximum area of an island.

An island is a group of connected land cells.

Cells are connected only horizontally and vertically:

```
up
down
left
right
```

---

# Example

Input:

```
[
[0,0,1,0],
[1,1,1,0],
[0,1,0,0],
[0,0,0,0]
]
```

Output:

```
5
```

Explanation:

The largest island contains:

```
    1
1 1 1
  1
```

Total area:

```
5 cells
```

---

# Approach

## DFS Flood Fill

This problem is an extension of **Number of Islands**.

Instead of counting islands, we calculate the size of each island.

The idea:

> When we find land, run DFS to calculate the total connected area. Track the maximum area found.

---

# Algorithm

1. Traverse every cell in the grid.
2. When a land cell (`1`) is found:
    - Run DFS.
    - Calculate the size of that island.
    - Update the maximum area.
3. Continue until the entire grid is explored.

---

# DFS Area Calculation

The DFS function returns the area of the island starting from a cell.

Example:

```
1 1
1 0
```

Starting at the top-left:

```
area =
current cell
+
right cell
+
down cell
```

Result:

```
3
```

---

# DFS Function

```java
getArea(row, col, grid)
```

Meaning:

> Return the number of connected land cells from this position.

---

# DFS Steps

## 1. Base Case

Stop if:

- Outside the grid
- Water
- Already visited

```java
if(
    i < 0 ||
    j < 0 ||
    i >= grid.length ||
    j >= grid[0].length ||
    grid[i][j] == 0
)
return 0;
```

Returning `0` means:

> This path contributes no area.

---

## 2. Mark Visited

```java
grid[i][j] = 0;
```

Instead of maintaining a visited array, we modify the grid.

This prevents revisiting cells.

---

## 3. Count Current Cell

Every valid land cell contributes:

```java
1
```

---

## 4. Explore Neighbours

```java
return 1
    + getArea(i+1,j)
    + getArea(i-1,j)
    + getArea(i,j+1)
    + getArea(i,j-1);
```

The result is:

```
current cell
+
all connected cells
```

---

# Why Does This Work?

Each DFS completely removes one island.

Example:

Before DFS:

```
1 1 0
1 0 1
0 1 1
```

After exploring first island:

```
0 0 0
0 0 1
0 1 1
```

The next DFS can only find a different island.

---

# Difference From Number Of Islands

## Number of Islands

Question:

> How many groups exist?

Return:

```
count++
```

---

## Max Area of Island

Question:

> How large is each group?

Return:

```
DFS area
```

Then:

```java
maxArea = Math.max(area, maxArea);
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
O(m*n)
```

Every cell is visited at most once.

---

## Space Complexity

```
O(m*n)
```

Worst case:

The entire grid is one island.

The DFS recursion stack can contain every cell.

---

# Common Mistakes

## 1. Forgetting to return area

Incorrect:

```java
dfs(neighbour);
```

The recursive calls do not contribute.

Correct:

```java
return 1 + dfs(neighbours);
```

---

## 2. Not marking visited

Incorrect:

```java
dfs(neighbour);
```

without:

```java
grid[i][j] = 0;
```

Causes infinite recursion.

---

## 3. Updating max incorrectly

Correct:

```java
int area = getArea(i,j,grid);

maxArea = Math.max(maxArea, area);
```

---

# Pattern Recognition

This is a DFS grid traversal problem.

Template:

```java
for(each cell)

    if(starting condition)

        answer = dfs(cell)
```

---

# Related Problems

- Number of Islands
- Flood Fill
- Surrounded Regions
- Word Search
- Pacific Atlantic Water Flow