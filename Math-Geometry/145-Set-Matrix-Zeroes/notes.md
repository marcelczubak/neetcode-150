# Set Matrix Zeroes Notes

## Pattern

- Matrix
- Two-Pass Traversal
- HashSet

---

# Core Insight

Do **not** modify the matrix while discovering zeros.

Example:

```text
1 0
1 1
```

If the first row is immediately zeroed:

```text
0 0
1 1
```

the new zero would incorrectly cause the first column to be zeroed as well.

Therefore:

```
Discover first.

Modify second.
```

---

# Data Structures

Maintain:

```java
Set<Integer> zeroRows;
Set<Integer> zeroCols;
```

These record:

- every row containing an original zero
- every column containing an original zero

---

# Phase 1 — Discover

Traverse every cell.

Whenever:

```java
matrix[i][j] == 0
```

record:

```java
zeroRows.add(i);

zeroCols.add(j);
```

Do **not** modify the matrix.

---

# Phase 2 — Zero Rows

For every row:

```java
for (int row : zeroRows)
```

set:

```java
matrix[row][col] = 0;
```

for every column.

---

# Phase 3 — Zero Columns

For every column:

```java
for (int col : zeroCols)
```

set:

```java
matrix[row][col] = 0;
```

for every row.

---

# Example

Input:

```text
1 1 1
1 0 1
1 1 1
```

Discovery:

```
Rows:

{1}

Columns:

{1}
```

After zeroing rows:

```text
1 1 1
0 0 0
1 1 1
```

After zeroing columns:

```text
1 0 1
0 0 0
1 0 1
```

---

# Why Two Passes?

Suppose:

```text
1 0
1 1
```

If the matrix is modified immediately:

```text
0 0
1 1
```

The new zero at:

```
(0,0)
```

was not part of the original matrix.

It should **not** cause column 0 to become zero.

Separating discovery from modification prevents this chain reaction.

---

# Common Mistakes

## Modifying During Traversal

Wrong:

```java
if(matrix[i][j]==0)
```

Immediately zero row and column.

This creates incorrect cascading zeros.

---

## Forgetting Duplicate Rows

A row may contain several zeros.

Using a `HashSet` naturally prevents duplicate work.

---

## Extra Matrix Copy

Some solutions create another matrix.

This works but uses:

```
O(R × C)
```

extra space.

Using two sets only requires:

```
O(R + C)
```

---

# Interview Explanation

"I first scan the matrix to record every row and column containing an original zero. I intentionally avoid modifying the matrix during this pass to prevent newly written zeros from affecting future decisions. Once all zero locations have been recorded, I zero the stored rows followed by the stored columns."

---

# Complexity

Time:

```
O(R × C)
```

Space:

```
O(R + C)
```

---

# Optimisation

This solution uses additional storage for the row and column sets.

The optimal interview solution reduces the extra space to:

```
O(1)
```

by using the first row and first column of the matrix itself as markers, while separately tracking whether the first row or first column originally contained a zero.

---

# Key Takeaway

The important idea is not the HashSets.

The important idea is the **two-phase process**:

```
Phase 1

Record information.

↓

Phase 2

Modify the matrix.
```

Separating these phases prevents newly written values from changing future decisions.