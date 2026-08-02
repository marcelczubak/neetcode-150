# Unique Paths

## Problem

A robot starts at the **top-left** corner of an `m × n` grid.

The robot may only move:

- Right
- Down

Determine the total number of unique paths to reach the **bottom-right** corner.

---

## Example

### Input

```text
m = 3
n = 7
```

### Output

```text
28
```

---

### Input

```text
m = 3
n = 2
```

### Output

```text
3
```

Possible paths:

```text
R → R → D

R → D → R

D → R → R
```

---

# Approach

## Top-Down Dynamic Programming (Memoization)

At every cell there are only two possible moves:

- Move right
- Move down

Therefore:

```
paths(current)

=

paths(right)

+

paths(down)
```

Instead of recomputing the same subproblems many times, store previously computed answers in a cache.

---

# Recursive State

The recursive function is defined as:

```java
dfs(row, col)
```

which returns:

```
The number of unique paths from (row, col) to the destination.
```

Each state is uniquely identified by:

```
(row, col)
```

which is stored as a cache key.

---

# Algorithm

### Step 1

Start DFS from:

```text
(0, 0)
```

---

### Step 2

If the current cell has already been computed:

```java
cache.containsKey(key)
```

return the cached answer immediately.

---

### Step 3

Base cases.

If the robot reaches the last row or last column:

```java
row == m - 1 || col == n - 1
```

there is exactly one remaining path.

Return:

```
1
```

If the robot leaves the grid:

```
0
```

paths exist.

---

### Step 4

Explore both possible moves.

```java
right = dfs(row + 1, col);

down = dfs(row, col + 1);
```

---

### Step 5

The total number of paths is:

```java
right + down
```

Store the result in the cache before returning.

---

# Example Walkthrough

Grid:

```text
3 × 3
```

Starting from:

```text
(0,0)
```

```
        (0,0)
       /     \
  (1,0)     (0,1)
   /  \       /  \
 ...  ...   ...  ...
```

Eventually every branch reaches either:

- the last row
- the last column

which each contribute exactly:

```
1 path
```

Memoization ensures each cell is solved only once.

---

# Why This Works

Every valid path from a cell must begin by moving:

- right
- or down

Therefore the total number of paths equals the sum of both recursive choices.

Caching guarantees each grid cell is evaluated only once.

---

# Complexity

Let:

```
m = rows

n = columns
```

## Time Complexity

There are:

```
m × n
```

unique states.

Each state is computed once.

```
O(mn)
```

---

## Space Complexity

Cache:

```
O(mn)
```

Recursion stack:

```
O(m + n)
```

Worst-case total:

```
O(mn)
```

---

# Pattern Recognition

When you see:

- count all paths
- move in fixed directions
- repeated subproblems

Think:

```
DFS

+

Memoization

=

Top-Down Dynamic Programming
```

---

# Related Problems

- Unique Paths II
- Minimum Path Sum
- Climbing Stairs
- House Robber