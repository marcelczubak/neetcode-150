# Word Search

## Problem

Given an `m x n` board of characters and a string `word`, determine if the word exists in the grid.

The word must be constructed from letters of sequentially adjacent cells.

Rules:

- Cells can only be used once per word.
- Movement is allowed up, down, left, and right.
- Diagonal movement is not allowed.

Example:

Input:

board =
[
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
]

word = "ABCCED"

Output:

true

Explanation:

A → B → C → C → E → D forms the word.

---

# Approach

## Backtracking DFS

The problem is solved by treating each cell as a possible starting position.

For every cell:

1. Check if it matches the first character.
2. Start a DFS search.
3. Explore all 4 possible directions.
4. Backtrack if the current path fails.

---

# Recursive State

The DFS keeps track of:

## Row

Current row position.

## Column

Current column position.

## Index

Current character of the word we are matching.

Example:

word = "APPLE"

index = 2 means we are currently looking for:

'P'

---

# Backtracking Process

At each cell:

## 1. Validate

Check:

- Is the position inside the board?
- Has the cell already been visited?
- Does the character match?

If any fail:

return false

---

## 2. Choose

Mark the cell as visited:

visited[row][col] = true

This prevents using the same cell twice in one path.

---

## 3. Explore

Search all four directions:

Up

Down

Left

Right

---

## 4. Undo Choice

After exploring:

visited[row][col] = false

This allows the cell to be used in a different path.

This is the key backtracking step.

---

# Base Case

If:

index == word.length() - 1

and the current character matches:

return true

The entire word has been found.

---

# Example

Board:

[
A B C
D E F
G H I
]

Word:

"ABE"

Start:

A

↓

Choose B

↓

Choose E

Word complete.

If a path fails:

Undo:

visited[row][col] = false

and try another direction.

---

# Why Backtracking Is Needed

A cell can only be used once in the current path.

Example:

A → B → C

C cannot go back to B.

However, after this path fails, B can be reused in another possible path.

Therefore we must undo visited states.

---

# Alternative Approach

Instead of using a visited array, the board itself can be modified:

Store:

char temp = board[row][col]

Mark:

board[row][col] = '#'

After recursion:

board[row][col] = temp

This saves O(R*C) extra memory.

---

# Complexity Analysis

Let:

R = number of rows

C = number of columns

L = length of word

## Time Complexity

Each cell can be a starting point:

O(R * C)

From each cell, explore up to 4 directions:

O(4^L)

Total:

O(R * C * 4^L)

---

## Space Complexity

Visited array:

O(R * C)

Recursion depth:

O(L)

Total:

O(R * C)

---

# Common Mistakes

## Forgetting to unmark visited

Wrong:

visited[row][col] = true

and never reset.

This blocks future paths.

Correct:

visited[row][col] = true

DFS

visited[row][col] = false

---

## Allowing diagonal movement

Only explore:

row + 1

row - 1

col + 1

col - 1

---

## Checking completion too late

If the current character matches the final character:

return true immediately.

---

# Pattern Recognition

When you see:

- Search for a path in a grid.
- Cells cannot be reused.
- Need to try all possibilities.

Think:

DFS + Backtracking

Template:

Choose cell

↓

Mark visited

↓

Explore neighbours

↓

Undo visited
