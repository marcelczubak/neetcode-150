# Surrounded Regions Notes

## Pattern

```
Reverse DFS from boundary
```

---

# Main Insight

Do not search for:

```
Which O's are surrounded?
```

Instead find:

```
Which O's are safe?
```

Safe means:

```
Connected to the border
```

---

# Algorithm

1. Find all border cells.

2. DFS from every border `O`.

3. Mark reachable cells.

```
O -> M
```

4. Traverse board:

```
O -> X

M -> O
```

---

# Why Mark Instead of Using Visited?

The board itself can store visited information.

Instead of:

```java
boolean[][] visited;
```

use:

```java
'M'
```

as a temporary marker.

This saves space.

---

# DFS Rules

Only continue if:

```java
board[row][col] == 'O'
```

Base case:

```java
out of bounds
OR
not O
```

Stop.

---

# Example

Before:

```
X X X
X O X
X O O
```

Border DFS reaches:

```
X X X
X O X
X M M
```

Remaining:

```
O
```

is trapped.

Convert:

```
O -> X
```

Restore:

```
M -> O
```

---

# Complexity

Time:

```
O(M×N)
```

Every cell processed once.

Space:

```
O(M×N)
```

Recursion stack.

---

# Interview Recognition

Keywords:

```
Surrounded

Enclosed

Capture regions

Border connected
```

↓

Think:

```
DFS/BFS from boundaries
```

---

# Similar Problems

## Pacific Atlantic Water Flow

Both use:

```
Reverse traversal
```

Instead of:

```
Cell -> destination
```

do:

```
Destination -> cells
```

---

## Number of Islands

Same DFS traversal pattern:

```
Visit connected cells
```

Difference:

Surrounded Regions:

```
Only care about border-connected islands
```

---

# Common Mistake

Starting DFS from every O.

This works but repeats work.

Better:

```
Start from all borders once
```

---

# General Pattern

For grid problems:

If the question asks:

```
Which cells are trapped?

Which cells cannot escape?

Which regions are enclosed?
```

Try:

```
Find the escape cells first
```

Then process the remaining cells.