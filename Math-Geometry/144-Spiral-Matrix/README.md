# Spiral Matrix

## Problem

Given an `m × n` matrix, return all elements of the matrix in **spiral order**.

The traversal begins at the top-left corner and proceeds:

1. Left → Right
2. Top → Bottom
3. Right → Left
4. Bottom → Top

Continue moving inward until every element has been visited.

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
[1,2,3,6,9,8,7,4,5]
```

---

# Approach

## Layer-by-Layer Traversal

Think of the matrix as a series of nested rectangles (layers).

For each layer:

1. Traverse the top row.
2. Traverse the right column.
3. Traverse the bottom row.
4. Traverse the left column.

After completing a layer, move inward by incrementing the top row and left column.

The bottom row and right column are recomputed for each layer.

---

# Algorithm

Maintain:

```
topRow
leftCol
```

representing the top-left corner of the current layer.

For every iteration:

Compute:

```text
bottomRow = rows - topRow - 1
rightCol = cols - leftCol - 1
```

These define the current layer.

---

Traverse in four directions:

### Top Row

Move:

```
left → right
```

---

### Right Column

Move:

```
top → bottom
```

excluding the top-right corner since it has already been visited.

---

### Bottom Row

Move:

```
right → left
```

Only perform this traversal if another row exists:

```java
bottomRow > topRow
```

to avoid revisiting a single remaining row.

---

### Left Column

Move:

```
bottom → top
```

Only perform this traversal if another column exists:

```java
rightCol > leftCol
```

to avoid revisiting a single remaining column.

---

Finally:

```java
topRow++;
leftCol++;
```

Move into the next inner layer.

Repeat until every element has been added.

---

# Example Walkthrough

Input:

```text
1 2 3
4 5 6
7 8 9
```

Layer 1:

Top:

```text
1 2 3
```

Right:

```text
6 9
```

Bottom:

```text
8 7
```

Left:

```text
4
```

Current result:

```text
1 2 3 6 9 8 7 4
```

Move inward.

Layer 2:

```text
5
```

Final result:

```text
[1,2,3,6,9,8,7,4,5]
```

---

# Why This Works

Each iteration completely processes one outer layer.

After finishing a layer:

- the outer boundary is no longer needed
- the next layer becomes the new problem

The boundary checks ensure that:

- a single remaining row is not traversed twice
- a single remaining column is not traversed twice

Thus every element is visited exactly once.

---

# Complexity

Let:

```
m = rows
n = columns
```

## Time Complexity

Every element is added exactly once.

```
O(m × n)
```

---

## Space Complexity

Ignoring the output list:

```
O(1)
```

The result list itself stores every matrix element.

---

# Pattern Recognition

When you see:

- spiral traversal
- shrinking boundaries
- matrix layers

Think:

```
Layer-by-Layer Traversal
```

or

```
Boundary Simulation
```

---

# Related Problems

- Rotate Image
- Set Matrix Zeroes
- Game of Life
- Diagonal Traverse