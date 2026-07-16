# Word Search - Notes

## Pattern

DFS + Backtracking

Grid traversal problem where we must explore possible paths while preventing cell reuse.

---

# Core Idea

Treat every cell as a possible starting point.

For each cell:

1. Match character.
2. Mark visited.
3. Explore 4 directions.
4. Undo visited state.

---

# Recursive State

Need:

row

Current row.

col

Current column.

index

Current character in word.

visited

Tracks cells already used in current path.

---

# DFS Flow

1. Check boundaries.

Invalid:

row < 0

col < 0

row >= rows

col >= columns


2. Check visited.

If already used:

return false


3. Check character.

If:

board[row][col] != word.charAt(index)

return false


4. If final character reached:

return true


5. Mark visited.

visited[row][col] = true


6. Explore:

Down

Up

Right

Left


7. Undo.

visited[row][col] = false

---

# Backtracking Pattern

Choose

↓

Explore

↓

Undo


For Word Search:

Choose:

visit cell


Explore:

DFS neighbours


Undo:

unvisit cell

---

# Why Undo?

A failed path should not permanently block cells.

Example:

Path 1:

A → B → C

fails.

Reset:

A,B,C = available again.

Try:

A → D → E

---

# Example

Board:

A B C

D E F

G H I


Word:

ABE


Start:

A

↓

Mark A visited

↓

Move to B

↓

Move to E

↓

Complete.

---

# Common Bug

## Missing:

visited[row][col] = false

after recursion.


Without it:

The first DFS path permanently locks cells.

---

# Optimisation

Instead of:

boolean[][] visited

modify the board directly:

Save character.

Replace with '#'.

DFS.

Restore character.

This reduces memory usage.

---

# Complexity

R = rows

C = columns

L = word length


Time:

O(R * C * 4^L)


Space:

O(R * C)

Visited array.

Recursion depth:

O(L)

---

# Mental Model

Imagine physically walking through the grid.

Every step:

- Mark where you have been.
- Try every possible direction.
- If lost, go back and erase your footprints.

Those erased footprints are the backtracking step.

---

# Recognition

If the problem asks:

- Find a path in a grid.
- Cannot revisit cells.
- Need all possible routes.

Think:

DFS + Backtracking

Template:

for every starting cell:

    dfs()

inside dfs:

    validate

    mark visited

    explore neighbours

    unmark visited