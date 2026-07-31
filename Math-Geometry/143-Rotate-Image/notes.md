# Rotate Image Notes

## Pattern

- Matrix
- In-place Transformation
- Reverse + Transpose

---

# Core Idea

Instead of moving every element directly to its rotated position:

```
(row, col)

↓

(col, n-1-row)
```

break the rotation into two simpler operations:

1. Reverse vertically.
2. Transpose.

---

# Step 1 — Reverse Vertically

Swap rows:

```
top

↓

bottom
```

Example:

Before:

```text
1 2 3
4 5 6
7 8 9
```

After:

```text
7 8 9
4 5 6
1 2 3
```

Implementation:

```java
for (int row = 0; row < n / 2; row++) {

    int[] temp = matrix[row];

    matrix[row] = matrix[n - row - 1];

    matrix[n - row - 1] = temp;
}
```

Only half the rows need to be swapped.

---

# Step 2 — Transpose

Swap:

```
matrix[row][col]

↓

matrix[col][row]
```

Example:

Before:

```text
7 8 9
4 5 6
1 2 3
```

After:

```text
7 4 1
8 5 2
9 6 3
```

---

# Why Only Upper Triangle?

If every pair were swapped twice:

```
(a,b)

↓

(b,a)

↓

(a,b)
```

the matrix would return to its original state.

Therefore iterate only:

```java
for (col = row + 1; col < n; col++)
```

This visits every pair exactly once.

---

# Example

Input:

```text
1 2 3
4 5 6
7 8 9
```

Reverse:

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

---

# Why Reverse First?

Clockwise rotation is equivalent to:

```
Vertical Flip

+

Transpose
```

Counter-clockwise rotation would instead use:

```
Horizontal Flip

+

Transpose
```

---

# Common Mistakes

## Swapping Entire Matrix During Transpose

Wrong:

```java
for(row=0...)

    for(col=0...)
```

Each pair gets swapped twice.

Only iterate over the upper triangle.

---

## Allocating Another Matrix

The problem explicitly requires:

```
In-place
```

No extra matrix should be created.

---

## Forgetting Matrix Must Be Square

The reverse + transpose trick only works for:

```
n × n
```

matrices.

---

# Interview Explanation

"I rotate the matrix in-place by performing two transformations. First, I reverse the matrix vertically, swapping the top and bottom rows. Then I transpose the matrix by swapping elements across the main diagonal. These two operations together produce a 90-degree clockwise rotation without requiring any additional matrix."

---

# Complexity

Time:

```
O(n²)
```

Space:

```
O(1)
```

---

# Key Takeaway

Remember the identity:

```
90° Clockwise Rotation

=

Vertical Reverse

+

Transpose
```

This is the standard in-place solution expected in interviews for matrix rotation problems.