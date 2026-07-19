# Rotting Oranges

## Problem

You are given an `m x n` grid where:

- `0` = empty cell
- `1` = fresh orange
- `2` = rotten orange

Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange also becomes rotten.

Return:

- The **minimum number of minutes** required for all oranges to become rotten.
- `-1` if it is impossible.

---

# Example

Input:

```
2 1 1
1 1 0
0 1 1
```

Minute 0

```
2 1 1
1 1 0
0 1 1
```

Minute 1

```
2 2 1
2 1 0
0 1 1
```

Minute 2

```
2 2 2
2 2 0
0 1 1
```

Minute 3

```
2 2 2
2 2 0
0 2 1
```

Minute 4

```
2 2 2
2 2 0
0 2 2
```

Output:

```
4
```

---

# Key Observation

All rotten oranges spread **simultaneously** every minute.

This means we cannot perform a normal DFS from one orange at a time.

Instead, we need to process all currently rotten oranges together before moving to the next minute.

This is exactly a **multi-source Breadth-First Search (BFS)**.

---

# Approach

## Step 1: Add all rotten oranges to the queue

Initially, every rotten orange acts as a starting point.

```
Queue:

(0,0)
(2,3)
(4,1)
...
```

These oranges all begin spreading at minute 0.

---

## Step 2: Perform BFS level-by-level

Each BFS level represents **one minute**.

```
Minute 0

Queue:
A B C
```

Process every orange currently in the queue.

Each one rots its neighbouring fresh oranges.

Those newly rotten oranges are added to the queue.

---

```
Minute 1

Queue:
D E F
```

Process the next level.

Repeat until the queue is empty.

---

## Step 3: Rot neighbouring oranges

For each rotten orange:

Check:

- Up
- Down
- Left
- Right

If a neighbour is fresh:

- Change it to rotten
- Add it to the queue

Immediately changing it to rotten also marks it as visited.

---

## Step 4: Verify the grid

After BFS finishes:

Traverse the grid.

If any fresh orange remains:

```
return -1;
```

Otherwise:

```
return minutes;
```

---

# Why BFS?

DFS explores one path deeply.

However, all rotten oranges spread simultaneously.

Example:

```
2 . . 2
```

Both rotten oranges spread at the same time.

BFS naturally models this behaviour because every level represents one minute.

---

# Complexity

Let:

- M = number of rows
- N = number of columns

Each cell is processed at most once.

Time:

```
O(M × N)
```

Space:

```
O(M × N)
```

in the worst case when every orange is placed into the queue.

---

# Key Pattern

This is a classic **multi-source BFS**.

Instead of one starting node:

```
Queue:
[start]
```

we begin with multiple sources:

```
Queue:
[source1, source2, source3]
```

Each BFS level represents one unit of time.

---

# Related Problems

- Walls and Gates
- 01 Matrix
- Shortest Path in Binary Matrix
- Word Ladder
- Open the Lock