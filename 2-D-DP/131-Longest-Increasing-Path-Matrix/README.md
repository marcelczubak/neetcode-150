# Longest Increasing Path in a Matrix

## Problem

Given an `m x n` integer matrix, return the length of the **longest strictly increasing path**.

From each cell, you may move:

- Up
- Down
- Left
- Right

You cannot move diagonally.

A move is valid only when the next cell contains a **larger value** than the current cell.

---

## Example

### Input

```text
matrix =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
```

### Output

```text
4
```

One longest increasing path is:

```text
1 → 2 → 6 → 9
```

---

# Approach

## DFS + Memoization

Treat every cell as a possible starting point.

Define:

```java
dfs(row, col)
```

as:

```text
The longest increasing path starting from matrix[row][col].
```

From each cell, explore its four neighbours.

A neighbour can only be visited if:

```text
neighbour > current cell
```

The answer for the current cell is:

```text
1 + longest valid neighbouring path
```

The `1` represents the current cell.

---

# DP State

The state is simply:

```text
(row, col)
```

The cache stores:

```java
cache[row][col]
```

which represents:

```text
Longest increasing path starting at (row, col)
```

---

# Algorithm

### Step 1

Create a memoization table:

```java
Integer[][] cache = new Integer[m][n];
```

---

### Step 2

Try every cell as a starting point.

```java
for every (row, col):
    result = max(result, dfs(row, col))
```

This is necessary because the longest path can start anywhere in the matrix.

---

### Step 3

Inside `dfs`, first check the cache.

```java
if (cache[row][col] != null)
    return cache[row][col];
```

If this cell has already been solved, return the stored result.

---

### Step 4

Check the four possible directions.

For each neighbour:

1. Make sure it is inside the matrix.
2. Check that its value is strictly greater.
3. Recursively calculate its longest path.

---

### Step 5

Take the best neighbouring path.

```text
1 + max(up, down, left, right)
```

Store the result in the cache.

---

# Why the Base Case Is Implicit

There is no explicit recursive base case required.

If a cell has no valid increasing neighbours:

```text
up = 0
down = 0
left = 0
right = 0
```

Then:

```text
1 + max(0,0,0,0)
=
1
```

So the longest increasing path starting at that cell is simply the cell itself.

---

# Why There Are No Cycles

A visited set is **not required**.

Every recursive move must satisfy:

```text
nextValue > currentValue
```

Therefore values strictly increase along a path.

For example:

```text
1 → 3 → 5 → 8
```

You can never return to:

```text
1
```

because:

```text
1 < 8
```

and therefore `1` cannot be a valid next step from `8`.

The strictly increasing condition makes cycles impossible.

---

# Example Walkthrough

Consider:

```text
[
  [3,4,5],
  [3,2,6],
  [2,2,7]
]
```

Starting at `3`:

```text
3 → 4 → 5
```

gives length:

```text
3
```

Starting at `2`:

```text
2 → 6 → 7
```

gives length:

```text
3
```

The DFS checks every possible starting cell and returns the maximum.

---

# Why Memoization Is Important

Without memoization, the same cell may be explored repeatedly.

For example, several paths may reach:

```text
(row = 1, col = 2)
```

The longest increasing path starting from that cell is always the same.

So calculate it once:

```text
cache[1][2]
```

and reuse it.

---

# Complexity

Let:

```text
m = number of rows

n = number of columns
```

There are:

```text
m × n
```

possible states.

Each state examines at most four neighbours.

## Time Complexity

```text
O(mn)
```

---

## Space Complexity

Memoization:

```text
O(mn)
```

Recursive call stack:

```text
O(mn)
```

in the worst case.

Overall:

```text
O(mn)
```

---

# Pattern Recognition

When you see:

- A grid/matrix
- Movement between neighbouring cells
- A monotonic condition such as increasing/decreasing
- The longest/shortest path
- Repeated states

Think:

```text
DFS

+

Memoization

+

Grid DP
```

---

# Related Problems

- Number of Islands
- Pacific Atlantic Water Flow
- Word Search
- Unique Paths
- Longest Increasing Subsequence