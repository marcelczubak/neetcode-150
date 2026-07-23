# Jump Game

## Problem

You are given an integer array `nums`, where each element represents your maximum jump length from that position.

Starting at index `0`, determine whether you can reach the last index.

---

## Example

### Input

```text
nums = [2,3,1,1,4]
```

### Output

```text
true
```

### Explanation

- Start at index `0`
- Jump to index `1`
- From index `1`, jump directly to the last index

---

## Approach

### Reverse Greedy

Instead of trying to determine how far we can reach from the beginning, work backwards from the destination.

Maintain a variable called `goalIndex`, representing the **leftmost index currently known to be able to reach the end**.

Initially:

```
goalIndex = last index
```

Move backwards through the array.

If an index can reach the current goal:

```
i + nums[i] >= goalIndex
```

then that index also becomes a valid goal.

Eventually, if the goal reaches index `0`, then the first position can reach the end.

---

## Algorithm

1. Initialise the goal as the last index.
2. Traverse the array from right to left.
3. If the current position can reach the goal:
   - Update the goal to the current index.
4. After processing every index:
   - If `goalIndex == 0`, return `true`.
   - Otherwise return `false`.

---

## Example Walkthrough

Input:

```text
[2,3,1,1,4]
```

Initial goal:

```text
goal = 4
```

Process backwards:

```text
i = 3

3 + 1 >= 4

goal = 3
```

```text
i = 2

2 + 1 >= 3

goal = 2
```

```text
i = 1

1 + 3 >= 2

goal = 1
```

```text
i = 0

0 + 2 >= 1

goal = 0
```

Since the goal moved back to index `0`, the answer is:

```text
true
```

---

## Complexity

### Time Complexity

```
O(n)
```

Each index is visited exactly once.

### Space Complexity

```
O(1)
```

Only one extra variable is maintained.

---

## Key Insight

Think of the problem as repeatedly asking:

> "Can this position reach the current goal?"

Rather than computing every possible jump, continuously move the goal backwards whenever another index can reach it.

---

## Pattern Recognition

This problem is a classic **Greedy** problem.

Look for:

- Reachability
- Jumps
- Need for a boolean answer
- Single pass solution

---

## Related Problems

- Jump Game II
- Gas Station
- Partition Labels
- Hand of Straights