# Set Matrix Zeroes

## Problem

Given an `m × n` matrix, if an element is `0`, set its **entire row** and **entire column** to `0`.

The transformation must be performed in-place.

---

## Example

### Input

```text
[
 [1,1,1],
 [1,0,1],
 [1,1,1]
]
```

### Output

```text
[
 [1,0,1],
 [0,0,0],
 [1,0,1]
]
```

---

# Approach

## Two-Pass Traversal

Directly zeroing rows and columns while traversing the matrix is incorrect because newly written zeros would affect future decisions.

Instead:

1. Record which rows contain an original zero.
2. Record which columns contain an original zero.
3. Zero the recorded rows.
4. Zero the recorded columns.

Separating the discovery phase from the modification phase ensures that only the original zeros influence the result.

---

# Algorithm

### Step 1

Maintain two sets:

```java
Set<Integer> zeroRows;
Set<Integer> zeroCols;
```

These store the indices of rows and columns that must eventually become zero.

---

### Step 2

Traverse the matrix once.

Whenever:

```java
matrix[i][j] == 0
```

record:

```java
zeroRows.add(i);
zeroCols.add(j);
```

No modifications are made during this pass.

---

### Step 3

For every row stored in:

```java
zeroRows
```

set every element in that row to zero.

---

### Step 4

For every column stored in:

```java
zeroCols
```

set every element in that column to zero.

---

# Example Walkthrough

Input:

```text
1 1 1
1 0 1
1 1 1
```

First pass:

```
zeroRows = {1}

zeroCols = {1}
```

Zero row:

```text
1 1 1
0 0 0
1 1 1
```

Zero column:

```text
1 0 1
0 0 0
1 0 1
```

Final answer:

```text
[
 [1,0,1],
 [0,0,0],
 [1,0,1]
]
```

---

# Why This Works

The important observation is that the matrix should only be modified **after** all original zero positions have been identified.

Otherwise, newly written zeros would incorrectly trigger additional rows and columns to be zeroed.

Using two sets preserves the original information until all decisions have been made.

---

# Complexity

Let:

```
R = number of rows

C = number of columns
```

## Time Complexity

Scan matrix:

```
O(R × C)
```

Zero selected rows:

```
O(R × C)
```

Zero selected columns:

```
O(R × C)
```

Overall:

```
O(R × C)
```

Each cell is written at most a constant number of times.

---

## Space Complexity

Two sets store row and column indices.

```
O(R + C)
```

---

# Pattern Recognition

When you see:

- matrix modification
- updates depending on original values
- avoid modifying during traversal

Think:

```
Two-Pass Traversal

+

Auxiliary Storage
```

---

# Related Problems

- Rotate Image
- Spiral Matrix
- Game of Life
- Matrix Diagonal Traverse