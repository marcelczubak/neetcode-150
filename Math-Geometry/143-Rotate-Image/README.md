# Rotate Image

## Problem

You are given an `n × n` matrix representing an image.

Rotate the image **90° clockwise** **in-place**.

You may not allocate another matrix.

---

## Example

### Input

```text
[
 [1,2,3],
 [4,5,6],
 [7,8,9]
]
```

### Output

```text
[
 [7,4,1],
 [8,5,2],
 [9,6,3]
]
```

---

# Approach

## Reverse + Transpose

Instead of rotating every element individually, perform two simple matrix operations:

1. Reverse the matrix vertically.
2. Transpose the matrix.

Together, these transformations produce a **90° clockwise rotation**.

---

# Step 1 — Reverse Vertically

Swap the first row with the last row, the second row with the second-last row, and so on.

Example:

Before:

```text
1 2 3
4 5 6
7 8 9
```

After reversing vertically:

```text
7 8 9
4 5 6
1 2 3
```

This flips the matrix upside down.

---

# Step 2 — Transpose

Transpose swaps:

```
(row, col)

↓

(col, row)
```

Only iterate over the **upper triangular** portion of the matrix to avoid swapping elements twice.

Example:

Before transpose:

```text
7 8 9
4 5 6
1 2 3
```

After transpose:

```text
7 4 1
8 5 2
9 6 3
```

The matrix is now rotated 90° clockwise.

---

# Algorithm

1. Reverse the rows of the matrix.
2. Transpose the matrix by swapping:
   ```
   matrix[row][col]
   ```
   with:
   ```
   matrix[col][row]
   ```
3. Return the modified matrix.

---

# Example Walkthrough

Initial matrix:

```text
1 2 3
4 5 6
7 8 9
```

Reverse vertically:

```text
7 8 9
4 5 6
1 2 3
```

Transpose:

```text
7 4 1
8 5 2
9 6 3
```

Final answer:

```text
[
 [7,4,1],
 [8,5,2],
 [9,6,3]
]
```

---

# Why This Works

A 90° clockwise rotation maps every element:

```
(row, col)

↓

(col, n - 1 - row)
```

Rather than computing this mapping directly, reversing vertically followed by transposing produces the exact same result.

Both operations are performed in-place.

---

# Complexity

Let:

```
n = matrix dimension
```

## Time Complexity

Vertical reverse:

```
O(n²)
```

Transpose:

```
O(n²)
```

Overall:

```
O(n²)
```

Every element is visited a constant number of times.

---

## Space Complexity

```
O(1)
```

The rotation is performed entirely in-place.

---

# Pattern Recognition

When you see:

- rotate matrix
- in-place
- square matrix

Think:

```
Reverse

+

Transpose
```

---

# Related Problems

- Spiral Matrix
- Set Matrix Zeroes
- Game of Life
- Matrix Diagonal Traverse