# Surrounded Regions

## Problem

Given an `m x n` board containing:

- `'X'` = blocked cell
- `'O'` = open region

Capture all regions of `'O'` that are **completely surrounded by `'X'`**.

Any `'O'` connected to the border cannot be captured.

The board should be modified in-place.

---

# Example

Input:

```
X X X X
X O O X
X X O X
X O X X
```

Output:

```
X X X X
X X X X
X X X X
X O X X
```

Explanation:

The top `'O'` region is surrounded by `'X'`, so it becomes captured.

The bottom `'O'` touches the border, so it remains unchanged.

---

# Key Observation

The problem is asking:

> Which O regions should NOT be captured?

Instead of searching for surrounded regions, find the regions that are safe.

A region is safe if:

```
It can reach the border
```

---

# Reverse Thinking Approach

Naive approach:

For every `'O'`:

```
Run DFS

Does it reach the border?
```

This repeats work and is inefficient.

---

Instead:

Start DFS from every border `'O'`.

Why?

Any `'O'` connected to the border is guaranteed to survive.

---

# Algorithm

## Step 1: DFS from Border Cells

Traverse the entire board.

For every border cell:

```
if board[row][col] == 'O'
```

run DFS.

During DFS:

Mark reachable `'O'` cells as:

```
'M'
```

Meaning:

```
This cell is connected to the border
```

---

## Step 2: Flip Remaining Cells

After DFS:

There are three possibilities:

### Remaining O

```
'O'
```

These were never connected to the border.

They are surrounded.

Convert:

```
O -> X
```

---

### Marked M

```
'M'
```

These are safe border-connected cells.

Restore:

```
M -> O
```

---

# Why DFS Works

DFS explores an entire connected region.

Starting from the border means:

```
Every visited O is guaranteed safe
```

Any unvisited O must be enclosed.

---

# Complexity

Let:

- M = rows
- N = columns

Each cell is visited at most once.

Time:

```
O(M × N)
```

Space:

```
O(M × N)
```

Worst case recursion depth.

---

# Key Pattern

When a problem asks:

```
Capture surrounded regions

Remove enclosed areas

Find cells not connected to boundary
```

Think:

```
Start from the boundary

Mark the safe cells

Process everything else
```

---

# Related Problems

- Number of Islands
- Pacific Atlantic Water Flow
- Flood Fill
- Walls and Gates
- Max Area of Island