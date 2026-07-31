# Spiral Matrix Notes

## Pattern

- Matrix
- Simulation
- Layer Traversal
- Boundary Management

---

# Core Idea

Treat the matrix as concentric layers.

Each iteration processes one complete layer before moving inward.

---

# Layer Boundaries

Maintain:

```java
topRow
leftCol
```

Compute:

```java
bottomRow = rows - topRow - 1;
rightCol = cols - leftCol - 1;
```

These four boundaries define the current rectangle.

---

# Traversal Order

Always process in the same order:

```
Top Row

↓

Right Column

↓

Bottom Row

↓

Left Column
```

Then shrink the layer.

---

# Top Row

Traverse:

```text
left → right
```

Every element is added.

---

# Right Column

Traverse:

```text
top + 1 → bottom
```

Skip the top-right corner because it was already visited.

---

# Bottom Row

Traverse:

```text
right - 1 → left
```

Only if:

```java
bottomRow > topRow
```

Otherwise a single remaining row would be visited twice.

---

# Left Column

Traverse:

```text
bottom - 1 → top
```

Only if:

```java
rightCol > leftCol
```

Otherwise a single remaining column would be duplicated.

---

# Shrink the Layer

After completing one layer:

```java
topRow++;
leftCol++;
```

The next iteration processes the inner rectangle.

---

# Example

Matrix:

```text
1 2 3
4 5 6
7 8 9
```

Layer 1:

```text
Top:
1 2 3

Right:
6 9

Bottom:
8 7

Left:
4
```

Result:

```text
1 2 3 6 9 8 7 4
```

Next layer:

```text
5
```

Finished.

---

# Why Boundary Checks Matter

Without:

```java
if (bottomRow > topRow)
```

Example:

```text
1 2 3
```

The bottom row is the same as the top row and would be traversed twice.

---

Without:

```java
if (rightCol > leftCol)
```

Example:

```text
1
2
3
```

The left column is also the right column and would be duplicated.

---

# Common Mistakes

## Visiting Corners Twice

Each direction should skip the corner already visited by the previous direction.

Example:

Right column starts at:

```java
topRow + 1
```

instead of:

```java
topRow
```

---

## Forgetting Single Row/Column Cases

Always guard the bottom row and left column traversals.

---

## Incorrect Loop Condition

This implementation uses:

```java
result.size() < total
```

where:

```java
total = (long) rows * cols;
```

Using `long` avoids potential integer overflow during multiplication.

---

# Interview Explanation

"I process the matrix one layer at a time. For each layer I traverse the top row, right column, bottom row, and left column. After completing the outer layer, I move inward by updating the boundaries. Additional boundary checks prevent revisiting elements when only a single row or column remains."

---

# Complexity

Time:

```
O(m × n)
```

Space:

```
O(1)
```

excluding the output list.

---

# Key Takeaway

Think of the matrix as a sequence of shrinking rectangles.

Each iteration completely removes one outer layer before continuing inward, ensuring every element is visited exactly once.