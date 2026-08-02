# Unique Paths Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization

---

# Core Idea

Define:

```java
dfs(row, col)
```

as:

```
Number of paths from this cell to the destination.
```

Every state depends only on:

```
Right

+

Down
```

---

# DP Recurrence

For every interior cell:

```java
paths(row, col)

=

paths(row + 1, col)

+

paths(row, col + 1)
```

Every path must start by moving either right or down.

---

# Base Cases

## Outside the Grid

```java
row > m - 1

or

col > n - 1
```

Return:

```text
0
```

No path exists.

---

## Last Row or Last Column

```java
row == m - 1

or

col == n - 1
```

Return:

```text
1
```

Only one straight path remains.

This is a nice optimisation over checking only the destination cell.

---

# Memoization

The recursive state is uniquely determined by:

```text
(row, col)
```

Store:

```java
Map<String, Integer>
```

Example key:

```text
"2,4"
```

Before solving a state:

```java
if(cache.containsKey(key))
```

return the stored answer immediately.

---

# Why Memoization Helps

Without caching:

```
dfs(2,2)
```

may be computed from multiple parents.

Example:

```text
dfs(1,2)

↓

dfs(2,2)
```

and

```text
dfs(2,1)

↓

dfs(2,2)
```

Memoization ensures:

```
Each state is solved exactly once.
```

---

# Example

Grid:

```text
3 × 3
```

```
(0,0)

↓

right

↓

(0,1)

↓

down

↓

(1,1)
```

Another branch also reaches:

```text
(1,1)
```

Instead of solving it twice:

```
Read from cache.
```

---

# State Representation

Current implementation:

```java
String key = row + "," + col;
```

Alternative (more efficient):

```java
Integer[][] memo
```

Both represent the same DP state.

---

# Common Mistakes

## No Memoization

Pure recursion explores identical states repeatedly.

Time becomes exponential.

---

## Incorrect Base Case

Returning `1` only at the destination works.

Returning `1` for the entire last row or last column is even better because only one path remains from those positions.

---

## Wrong DP State

The state must include both:

```text
row

col
```

Using only one coordinate is insufficient.

---

# Interview Explanation

"I define a recursive function that returns the number of unique paths from the current cell to the destination. Since every path must begin by moving either right or down, the answer is the sum of those two recursive calls. Many cells are reached from multiple paths, so I cache each `(row, col)` result in a HashMap to avoid recomputation. This reduces the exponential recursion to a linear number of grid states."

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

for the memoization cache, plus up to:

```text
O(m + n)
```

recursive call stack.

---

# Key Takeaway

The key insight is defining the recursive state:

```text
paths(row, col)
```

Once that state is identified, the recurrence becomes:

```java
paths(row, col) =
paths(row + 1, col)
+
paths(row, col + 1)
```

Memoization transforms the exponential recursive solution into an optimal **O(mn)** dynamic programming solution by ensuring every cell is computed only once.