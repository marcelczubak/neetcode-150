# Longest Increasing Path in Matrix Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Matrix / Grid

---

# Core Idea

Treat every cell as a possible starting point.

Define:

```java
dfs(row, col)
```

as:

```text
Longest increasing path starting from this cell.
```

---

# DP State

State:

```text
(row, col)
```

Cache:

```java
cache[row][col]
```

Meaning:

```text
Longest increasing path beginning at matrix[row][col].
```

---

# Four Directions

From every cell, check:

```text
Up
Down
Left
Right
```

A move is valid only if:

```java
matrix[nextRow][nextCol] > matrix[row][col]
```

---

# Recurrence

For a cell:

```text
current
```

calculate:

```text
up
down
left
right
```

Then:

```text
1 + max(up, down, left, right)
```

The `1` represents the current cell.

---

# Invalid Direction

If a direction:

- Goes out of bounds
- Does not contain a larger value

treat it as:

```text
0
```

Example:

```java
int up =
    row > 0 && matrix[row-1][col] > cell
    ? dfs(...)
    : 0;
```

This is why an explicit out-of-bounds base case isn't necessary.

---

# Implicit Base Case

If there are no larger neighbours:

```text
up    = 0
down  = 0
left  = 0
right = 0
```

Then:

```text
result = 1
```

The path consists only of the current cell.

---

# Memoization

Before doing any work:

```java
if (cache[row][col] != null)
    return cache[row][col];
```

After calculating:

```java
cache[row][col] = result;
```

Each cell is therefore solved only once.

---

# Why Start DFS From Every Cell?

The longest path can begin anywhere.

Therefore:

```java
for every cell:
    result = max(result, dfs(cell))
```

The DFS itself finds the longest path **from that cell**, while the outer loop finds the best starting cell.

---

# Why No Visited Set?

Unlike normal graph DFS, a visited set is unnecessary.

Every valid move satisfies:

```text
nextValue > currentValue
```

Therefore:

```text
1 → 2 → 4 → 7
```

can only move toward larger values.

A cycle would require eventually returning to a smaller value, which violates the increasing condition.

---

# Example

```text
[
    [9, 9, 4],
    [6, 6, 8],
    [2, 1, 1]
]
```

One longest path:

```text
1 → 2 → 6 → 9
```

Length:

```text
4
```

The DFS discovers this by recursively following only increasing neighbours.

---

# Common Mistakes

## Forgetting Bounds

This is unsafe:

```java
matrix[row-1][col]
```

when:

```text
row == 0
```

Always check bounds before accessing the neighbour.

---

## Allowing Equal Values

The condition must be:

```java
next > current
```

not:

```java
next >= current
```

The path must be **strictly increasing**.

---

## Using a Visited Set

A visited set is unnecessary and can actually complicate the solution.

The increasing condition already prevents cycles.

---

## Forgetting to Try Every Starting Cell

Don't only run DFS from:

```text
(0,0)
```

The longest path can begin anywhere in the matrix.

---

## Recomputing Cells

Without memoization, the same cell can be explored many times.

Use:

```java
Integer[][] cache
```

to store the answer for each cell.

---

# Interview Explanation

"I treat every matrix cell as a DP state. `dfs(row, col)` returns the longest increasing path starting from that cell. I check the four neighbouring cells and only recurse into a neighbour if its value is strictly greater. The answer for a cell is one plus the maximum result from its valid neighbours. I memoize each cell because multiple paths can reach the same state. Finally, I run DFS from every cell and take the maximum result."

---

# Complexity

Time:

```text
O(mn)
```

Space:

```text
O(mn)
```

for the cache and recursion stack in the worst case.

---

# Key Takeaway

The important insight is:

```text
dfs(row, col)
```

does **not** mean:

```text
"Have I visited this cell?"
```

It means:

```text
"What is the longest increasing path starting from this cell?"
```

Once you define the state this way, the problem becomes a straightforward:

```text
DFS + Memoization
```

grid DP problem.
```