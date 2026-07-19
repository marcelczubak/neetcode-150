# Pacific Atlantic Water Flow

## Problem

You are given an `m x n` grid of heights.

Water can flow from a cell to another if the neighbouring cell has a **height less than or equal to** the current cell.

There are two oceans:

- **Pacific Ocean** touches the **top** and **left** borders.
- **Atlantic Ocean** touches the **bottom** and **right** borders.

Return every cell from which water can flow to **both** oceans.

---

# Example

Input:

```
1 2 2 3 5
3 2 3 4 4
2 4 5 3 1
6 7 1 4 5
5 1 1 2 4
```

Output:

```
[
 [0,4],
 [1,3],
 [1,4],
 [2,2],
 [3,0],
 [3,1],
 [4,0]
]
```

---

# Key Observation

The obvious solution would be:

For every cell:

```
Run DFS

Can it reach Pacific?

Can it reach Atlantic?
```

This would be:

```
O((M×N)²)
```

which is far too slow.

Instead, reverse the problem.

---

# Reverse the Water Flow

Normally:

```
High -> Low
```

Water flows downhill.

Instead of asking:

> Can this cell reach the ocean?

Ask:

> Which cells can the ocean reach if water flowed backwards?

Reverse the direction:

```
Low -> High
```

Now we start DFS from the oceans.

---

# Multi-Source DFS

Run two DFS traversals.

## Pacific DFS

Start from:

- Top row
- Left column

Mark every reachable cell.

Store results in:

```java
boolean[][] pacific;
```

---

## Atlantic DFS

Start from:

- Bottom row
- Right column

Mark every reachable cell.

Store results in:

```java
boolean[][] atlantic;
```

---

# DFS Rule

When exploring neighbours:

Only continue if:

```
nextHeight >= currentHeight
```

Why?

Because we're travelling backwards.

If water normally flows:

```
5 -> 3
```

Reverse DFS travels:

```
3 -> 5
```

---

# Final Step

Traverse every cell.

If:

```java
pacific[r][c] &&
atlantic[r][c]
```

then this cell can reach both oceans.

Add it to the answer.

---

# Complexity

Let:

- M = rows
- N = columns

Each DFS visits every cell at most once.

Pacific DFS:

```
O(M×N)
```

Atlantic DFS:

```
O(M×N)
```

Total:

```
O(M×N)
```

Space:

```
O(M×N)
```

for the visited arrays.

---

# Why This Works

Every DFS answers:

> Which cells can flow into this ocean?

The intersection of the two visited arrays gives:

> Cells that can reach **both** oceans.

---

# Key Pattern

Whenever you see:

```
Can every node reach a destination?
```

consider reversing the search:

```
Start from the destination

Traverse backwards
```

This often turns many expensive searches into one efficient traversal.

---

# Related Problems

- Number of Islands
- Max Area of Island
- Surrounded Regions
- Rotting Oranges
- Walls and Gates