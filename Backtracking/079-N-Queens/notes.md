# N Queens - Notes

## Core Idea

Place `n` queens on an `n x n` board so that no queens attack each other.

A queen attacks:

- Same row
- Same column
- Same diagonal

The solution uses backtracking.

---

# Key Observation

Instead of placing queens randomly:

We place exactly one queen per row.

Why?

Because two queens can never share a row.

Therefore:

```
row = current decision level
column = current choice
```

---

# Recursive Function

```java
backtrack(
    result,
    board,
    n,
    row,
    cols,
    posDiag,
    negDiag
)
```

The state represents:

```
"We have already placed queens in rows before this one.
Now decide where to place the queen in this row."
```

---

# Backtracking Flow

For every row:

```
Try every column

    If invalid:
        skip

    If valid:

        Place queen

        Add constraints

        Solve next row

        Remove queen

        Remove constraints

Try next column
```

---

# The Three Backtracking Steps

## 1. Choose

Place the queen:

```java
board[row][col] = 'Q';
```

Update state:

```java
cols.add(col);
posDiag.add(row + col);
negDiag.add(row - col);
```

---

## 2. Explore

Move to the next row:

```java
backtrack(
    result,
    board,
    n,
    row + 1,
    cols,
    posDiag,
    negDiag
);
```

---

## 3. Undo

Remove the choice:

```java
cols.remove(col);
posDiag.remove(row + col);
negDiag.remove(row - col);

board[row][col] = '.';
```

This allows another column choice to be tested.

---

# Important Concept

The recursive call goes deeper.

The loop explores alternatives.

Example:

```
             row 0

       col0   col1   col2
        |      |      |
      row1   row1   row1
```

After:

```
place queen
recurse
remove queen
```

the loop automatically moves to the next column.

You do NOT call backtrack again after undoing.

---

# Why Use Sets?

Checking every square on the board would be expensive.

Instead, store occupied:

## Columns

```java
col
```

Example:

```
cols = {2}
```

---

## Positive Diagonals

Formula:

```
row + col
```

Represents:

```
\
```

---

## Negative Diagonals

Formula:

```
row - col
```

Represents:

```
/
```

---

# Validity Check

Before placing:

```java
if (
    cols.contains(col)
    ||
    posDiag.contains(row + col)
    ||
    negDiag.contains(row - col)
)
continue;
```

If any set contains the position, the queen would attack another queen.

---

# Base Case

When every row has a queen:

```java
if (row == n)
```

A valid solution has been created.

Copy the board and add it.

---

# Example

For:

```
n = 4
```

Start:

```
....
....
....
....
```

Place:

```
Q...
....
....
....
```

Try next row.

If no valid positions remain:

Undo:

```
....
....
....
....
```

Try the next column.

---

# Complexity

## Time

```
O(n!)
```

The algorithm explores possible queen placements.

---

## Space

```
O(n)
```

For:

- Recursion stack
- Column tracking
- Diagonal tracking

Board storage:

```
O(n^2)
```

---

# Pattern Recognition

N Queens is the classic constraint backtracking problem.

Template:

```java
for (choice : choices) {

    if (invalid)
        continue;

    make choice;

    recurse;

    undo choice;
}
```

Remember:

```
Choose
↓
Explore
↓
Undo
```

---

# Similar Problems

- Sudoku Solver
- Word Search
- Combination Sum
- Permutations
- Generate Parentheses
- Palindrome Partitioning
```