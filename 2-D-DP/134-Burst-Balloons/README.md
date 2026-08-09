# Burst Balloons

## Problem

Given an array of balloons, where each balloon has a number, burst all balloons to maximize the number of coins collected.

When bursting balloon `i`, the coins gained are:

```text
leftNeighbour × nums[i] × rightNeighbour
```

After a balloon is burst, it disappears and its neighbouring balloons become adjacent.

Return the maximum number of coins that can be collected.

---

## Example

### Input

```text
nums = [3,1,5,8]
```

### Output

```text
167
```

One optimal order is:

```text
1 → 5 → 3 → 8
```

giving:

```text
3*1*5 = 15
3*5*8 = 120
1*3*8 = 24
1*8*1 = 8

Total = 167
```

---

# Approach

## Interval DP + DFS + Memoization

The main difficulty is that the neighbours of a balloon change as other balloons are burst.

Trying to decide which balloon to burst **first** makes the state difficult to represent.

Instead, consider:

> Which balloon is burst **last** in the current interval?

This makes the problem much easier.

---

# Padding the Array

Add `1` to both ends of the array.

For example:

```text
nums:

[3, 1, 5, 8]
```

becomes:

```text
[1, 3, 1, 5, 8, 1]
```

The `1`s represent permanent boundary balloons.

This allows us to safely access:

```java
nums[left - 1]
nums[right + 1]
```

without special cases.

---

# DP State

Define:

```java
popBalloons(left, right)
```

as:

```text
Maximum coins obtainable by bursting every balloon
between left and right, inclusive.
```

The state is:

```text
(left, right)
```

The cache stores:

```java
cache[left][right]
```

---

# Key Insight: Burst Last

Suppose the current interval is:

```text
[left ............. right]
```

Choose some:

```text
i
```

and assume `i` is the **last balloon burst** in this interval.

By the time `i` is burst:

```text
all balloons between left and i-1
```

and:

```text
all balloons between i+1 and right
```

have already disappeared.

Therefore, the balloons immediately surrounding `i` are:

```text
nums[left - 1]

nums[i]

nums[right + 1]
```

So the coins gained from the final burst are:

```text
nums[left - 1] * nums[i] * nums[right + 1]
```

---

# Splitting the Problem

If `i` is the last balloon burst:

```text
[left ... i-1]   i   [i+1 ... right]
```

The two sides can be solved independently.

Therefore:

```text
maximum coins =
    left subproblem
    +
    final burst
    +
    right subproblem
```

In code:

```java
popBalloons(left, i-1)
+
nums[left-1] * nums[i] * nums[right+1]
+
popBalloons(i+1, right)
```

Try every possible `i` and take the maximum.

---

# Base Case

If:

```java
left > right
```

there are no balloons remaining.

Therefore:

```java
return 0;
```

This occurs when a subproblem is empty.

For example:

```text
popBalloons(3, 2)
```

has nothing to burst.

---

# Algorithm

1. Create a padded array with `1` on both ends.
2. Create a 2D memoization cache.
3. Start with the interval containing all original balloons.
4. For every possible `i` in the interval:
   - Assume `i` is the last balloon burst.
   - Solve the left interval.
   - Calculate the coins from bursting `i`.
   - Solve the right interval.
   - Add the three results.
5. Take the maximum over all choices of `i`.
6. Cache the result for the interval.

---

# Example

Consider:

```text
[1, 3, 1, 5, 8, 1]
```

For:

```text
left = 1
right = 4
```

suppose:

```text
i = 2
```

is the last balloon burst.

Then:

```text
left interval:
[1, 1]
```

and:

```text
right interval:
[5, 8]
```

are solved first.

The final burst of `i` gives:

```text
nums[0] * nums[2] * nums[5]
```

which is:

```text
1 * 1 * 1
```

The total is therefore:

```text
leftCoins
+
1
+
rightCoins
```

The algorithm tries every possible final balloon.

---

# Why Memoization Works

There are many overlapping intervals.

For example, different choices of the last balloon can lead to the same:

```text
(left, right)
```

state.

The maximum coins obtainable from an interval are always the same regardless of how we reached it.

Therefore:

```java
cache[left][right]
```

can store the answer.

Each interval is solved only once.

---

# Why "Burst Last" Works

If we choose a balloon to burst first, its neighbours depend on what has already been removed.

This makes the state difficult to describe.

If we choose a balloon to burst last:

```text
all other balloons in the interval are already gone
```

so its neighbours are fixed:

```text
left - 1
right + 1
```

This is what allows the problem to split into two independent subproblems.

---

# Complexity

There are approximately:

```text
O(n²)
```

possible intervals.

For each interval, we try every possible balloon as the final balloon:

```text
O(n)
```

Therefore:

```text
Time: O(n³)
```

The memoization table contains:

```text
O(n²)
```

intervals.

Therefore:

```text
Space: O(n²)
```

---

# Pattern Recognition

When you see:

- An array
- A range/interval
- A choice of an element inside the interval
- The choice changes the surrounding elements
- Need to maximize/minimize a result

Think:

```text
Interval DP
```

A particularly useful trick is:

```text
Choose the LAST operation
```

rather than the first.

---

# Related Problems

- Matrix Chain Multiplication
- Minimum Cost to Cut a Stick
- Palindrome Partitioning
- Strange Printer
- Remove Boxes