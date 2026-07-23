# Jump Game II

## Problem

You are given an integer array `nums`, where each element represents the maximum jump length from that position.

Starting from index `0`, return the **minimum number of jumps** required to reach the last index.

It is guaranteed that the last index is always reachable.

---

## Example

### Input

```text
nums = [2,3,1,1,4]
```

### Output

```text
2
```

### Explanation

One optimal path is:

```text
0 -> 1 -> 4
```

Only **2 jumps** are required.

---

## Approach

### Greedy + BFS Window

Instead of deciding where to jump next immediately, think of every jump as exploring an entire **window of reachable indices**.

Maintain two pointers:

- `left` = start of the current window
- `right` = end of the current window

Every index inside this window is reachable using the current number of jumps.

Scan every position in the current window and compute the furthest position that can be reached.

That furthest position becomes the next window.

Increase the jump count and repeat until the last index is included.

---

## Algorithm

1. If the array contains one element, return `0`.
2. Initialise:
   - `left = 0`
   - `right = nums[0]`
   - `numJumps = 1`
3. While the current window does not reach the last index:
   - Scan every index in the window.
   - Compute the furthest reachable position.
   - Move the window to the newly discovered range.
   - Increment the jump count.
4. Return the number of jumps.

---

## Example Walkthrough

Input:

```text
[2,3,1,1,4]
```

Initial window:

```text
Reachable after 1 jump:

[0 ... 2]
```

Scan:

```text
Index 0 -> reach 2

Index 1 -> reach 4

Index 2 -> reach 3
```

Furthest reach:

```text
4
```

The destination is now inside the next window.

Answer:

```text
2 jumps
```

---

## Why This Works

Every jump explores **all positions** reachable with the current number of jumps.

Choosing the furthest reachable position from that window guarantees the next jump covers the largest possible range.

This is identical to performing a level-order traversal (BFS) without using a queue.

---

## Complexity

### Time Complexity

```
O(n)
```

Although there is a nested loop, each index belongs to exactly one window and is processed only once.

### Space Complexity

```
O(1)
```

Only a few integer variables are used.

---

## Key Insight

Think of each jump as exploring one **level**.

```
Jump 0:

[0]

Jump 1:

[1,2]

Jump 2:

[3,4]
```

Instead of deciding one jump at a time, process an entire reachable level before moving to the next.

---

## Pattern Recognition

When you see:

- minimum jumps
- minimum moves
- shortest path on an array
- guaranteed reachable

Think:

```
Greedy + BFS Window
```

---

## Related Problems

- Jump Game
- Gas Station
- Minimum Number of Refueling Stops
- Word Ladder (BFS concept)