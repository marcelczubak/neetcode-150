# N Queens

## Problem

Given an integer `n`, place `n` queens on an `n x n` chessboard such that no two queens attack each other.

A queen can attack another queen if they share:

- The same row
- The same column
- The same diagonal

Return all possible board configurations.

---

## Example

### Input

```
n = 4
```

### Output

```
[
 [
  ".Q..",
  "...Q",
  "Q...",
  "..Q."
 ],
 [
  "..Q.",
  "Q...",
  "...Q",
  ".Q.."
 ]
]
```

Each string represents a row of the chessboard.

`Q` represents a queen.

`.` represents an empty square.

---

# Approach

## Backtracking

This problem is solved using backtracking.

The main idea:

> Try placing one queen in each row. If a placement creates a conflict, undo it and try another position.

We process the board row by row.

At each row:

1. Try every possible column.
2. Check if placing a queen is valid.
3. Place the queen.
4. Recursively solve the next row.
5. Remove the queen and try the next column.

---

# Backtracking Template

The general structure:

```
Choose
↓
Explore
↓
Undo
```

For N Queens:

```
Choose:
    Place queen

Explore:
    Solve next row

Undo:
    Remove queen
```

---

# Tracking Constraints

Instead of checking the entire board every time, we store attacked positions.

We use three sets:

```java
Set<Integer> cols;
Set<Integer> posDiag;
Set<Integer> negDiag;
```

---

## Columns

A queen attacks vertically.

Example:

```
. Q .
. . .
. . .
```

Column `1` is occupied.

Store:

```
cols = {1}
```

---

## Positive Diagonal

Diagonal:

```
\ \ \
```

The value:

```
row + col
```

is constant.

Example:

```
Q . .
. Q .
. . Q
```

Coordinates:

```
(0,0)
(1,1)
(2,2)
```

Values:

```
0+0 = 0
1+1 = 2
2+2 = 4
```

---

## Negative Diagonal

Diagonal:

```
/ / /
```

The value:

```
row - col
```

is constant.

Example:

```
. . Q
. Q .
Q . .
```

Coordinates:

```
(0,2)
(1,1)
(2,0)
```

Values:

```
0-2 = -2
1-1 = 0
2-0 = 2
```

---

# Algorithm

1. Create an empty board.
2. Start backtracking from row `0`.
3. For every column:
    - Check if the column or diagonals are occupied.
    - If safe:
        - Place queen.
        - Add positions to sets.
        - Recurse to the next row.
        - Remove queen.
        - Remove positions from sets.
4. When `row == n`, a valid solution is found.

---

# Why We Do Not Call Backtrack After Removing The Queen

The undo step:

```java
board[row][col] = '.';
```

does not need another recursive call.

The `for` loop already handles trying other possibilities.

Example:

```
Try column 0
    place queen
    recurse
    remove queen

Try column 1
    place queen
    recurse
    remove queen

Try column 2
    place queen
    recurse
    remove queen
```

The loop generates sibling branches.

The recursive call only moves deeper.

---

# Complexity Analysis

## Time Complexity

```
O(n!)
```

At each row we can attempt multiple columns.

The search space is approximately:

```
n * (n-1) * (n-2) * ... * 1
```

---

## Space Complexity

```
O(n)
```

Used for:

- Recursion depth
- Column set
- Diagonal sets

The board itself requires:

```
O(n^2)
```

space for storing the final board.

---

# Common Mistakes

## Forgetting to undo state

Incorrect:

```java
board[row][col] = 'Q';

backtrack(...);
```

The next branch still sees the queen.

Correct:

```java
board[row][col] = 'Q';

backtrack(...);

board[row][col] = '.';
```

---

## Forgetting to remove from sets

Incorrect:

```java
cols.add(col);

backtrack(...);
```

The next branch thinks the column is still occupied.

Correct:

```java
cols.add(col);

backtrack(...);

cols.remove(col);
```

---

## Missing return after finding a solution

Incorrect:

```java
if (row == n) {
    result.add(solution);
}
```

Correct:

```java
if (row == n) {
    result.add(solution);
    return;
}
```

---

# Backtracking Recognition

Use this pattern for problems asking:

- Generate all valid configurations
- Try all possible arrangements
- Find all paths
- Place objects with constraints

Questions to ask:

1. What are my choices?
2. What constraints make a choice invalid?
3. What state do I need to remember?
4. What do I undo after exploring?

---

# Related Problems

Similar backtracking problems:

- Subsets
- Permutations
- Combination Sum
- Generate Parentheses
- Palindrome Partitioning
- Word Search

N Queens is the classic example of:

```
Choose
↓
Validate
↓
Explore
↓
Undo
```