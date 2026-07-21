# Partition Equal Subset Sum

## Problem

Given an integer array `nums`, determine whether the array can be split into two subsets such that the sum of elements in both subsets is equal.

---

## Example 1

### Input

```
nums = [1,5,11,5]
```

### Output

```
true
```

### Explanation

Total sum:

```
1 + 5 + 11 + 5 = 22
```

Each subset must have:

```
22 / 2 = 11
```

A valid partition exists:

```
[11]

[1,5,5]
```

Both subsets sum to:

```
11
```

---

## Example 2

### Input

```
nums = [1,2,3,5]
```

### Output

```
false
```

### Explanation

Total sum:

```
1 + 2 + 3 + 5 = 11
```

Since the sum is odd, it is impossible to split into two equal subsets.

---

# Key Observation

A valid partition means:

```
subset1 sum = subset2 sum
```

Therefore:

```
total sum = subset1 + subset2
```

If the total sum is `S`, each subset must have:

```
S / 2
```

So the problem becomes:

> Can we find a subset of numbers that adds up to `S / 2`?

This is a classic:

```
Subset Sum / 0-1 Knapsack
```

problem.

---

# Approach: DFS + Memoization

## Idea

At every index, we have two choices:

1. Include the current number.
2. Skip the current number.

The recursion explores all possible subsets.

Example:

```
nums = [1,5,11]
```

Decision tree:

```
                 1
              /     \
           take     skip
            /         \
          5            5
        /   \        /   \
      take skip   take skip
```

---

# Recursive State

The helper function:

```java
partition(nums, i, curSum, target)
```

represents:

> Starting at index `i`, can we create a subset that reaches the target sum?

State variables:

```
i
```

Current position in the array.

```
curSum
```

Current subset sum.

```
target
```

Required subset sum.

---

# Base Cases

## Target reached

```java
curSum == target
```

A valid subset has been found.

Return:

```
true
```

---

## Out of bounds

```java
i >= nums.length
```

No more numbers available.

Return:

```
false
```

---

## Exceeded target

```java
curSum > target
```

All numbers are positive, so this path cannot recover.

Return:

```
false
```

---

# Memoization

## Problem

Without memoization, the same states are recalculated many times.

Example:

```
(index = 4, sum = 10)
```

could be reached through multiple different subsets.

However, the result only depends on:

```
(index, current sum)
```

---

## Memo Key

The solution stores:

```java
String key = i + "." + curSum;
```

Meaning:

```
Have we already calculated this state?
```

If yes:

```java
return memo.get(key);
```

---

# Algorithm

1. Calculate the total sum.
2. If total sum is odd:
    - return false.
3. Target becomes:

```
total sum / 2
```

4. Run DFS.
5. At every number:
    - Try including it.
    - Try skipping it.
6. Store the result for `(index, current sum)`.

---

# Complexity

Let:

```
n = number of elements
target = total sum / 2
```

Number of states:

```
n * target
```

Each state explores two decisions.

## Time Complexity

```
O(n * target)
```

---

## Space Complexity

Memoization:

```
O(n * target)
```

Recursion stack:

```
O(n)
```

Overall:

```
O(n * target)
```

---

# Key Takeaway

This problem demonstrates the progression:

```
Brute Force Recursion
        |
        v
Identify overlapping states
        |
        v
Memoization
        |
        v
Dynamic Programming
```

The important insight is recognising that the state is:

```
(index, current sum)
```

not the entire subset path.

---

# Related Problems

- Target Sum
- Coin Change
- Combination Sum
- Last Stone Weight II
- 0/1 Knapsack
- Subset Sum