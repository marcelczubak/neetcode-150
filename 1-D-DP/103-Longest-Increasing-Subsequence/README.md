# Longest Increasing Subsequence (LIS)

## Problem

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence:
- Maintains the relative order of elements.
- Does not need to be contiguous.
- Can skip elements.

---

## Example

### Input

```
nums = [10,9,2,5,3,7,101,18]
```

### Output

```
4
```

### Explanation

The longest increasing subsequence is:

```
[2,3,7,101]
```

Length:

```
4
```

---

# Approach 1: Recursion (Brute Force)

## Idea

For every index, ask:

> "What is the longest increasing subsequence starting from this element?"

Define:

```
dfs(i) = length of LIS starting at index i
```

At every index:

1. The element itself forms a subsequence:

```
length = 1
```

2. Try every future element.

If:

```
nums[i] < nums[j]
```

then `nums[j]` can extend the subsequence.

Transition:

```
dfs(i) = max(dfs(i), 1 + dfs(j))
```

---

## Recursive Structure

Example:

```
nums = [1,3,4]
```

Starting at index 0:

```
1
|
+-- 3
|   |
|   +-- 4
|
+-- 4
```

The recursion explores all possible increasing subsequences.

---

## Complexity

Time:

```
O(2^n)
```

because many possible subsequences are explored.

Space:

```
O(n)
```

due to recursion depth.

---

# Approach 2: Recursion + Memoization

## Problem with recursion

The same states are calculated repeatedly.

Example:

```
nums = [1,2,3,4]
```

`dfs(2)` may be reached from:

```
dfs(0)
 |
 +-- dfs(2)

dfs(1)
 |
 +-- dfs(2)
```

We can store the answer after calculating it once.

---

## Memo State

Create:

```
memo[i]
```

where:

```
memo[i] = LIS starting at index i
```

Before calculating:

```java
if (memo[i] != 0)
    return memo[i];
```

After calculating:

```java
memo[i] = longest;
```

---

## Complexity

Number of states:

```
n
```

Each state checks:

```
n
```

future elements.

Time:

```
O(n²)
```

Space:

```
O(n)
```

for memoization.

---

# Approach 3: Bottom-Up Dynamic Programming

## Idea

Convert the recursive relationship into an iterative solution.

Instead of:

```
dfs(i)
```

we store:

```
dp[i]
```

where:

```
dp[i] = LIS starting at index i
```

---

## Initialization

Every element alone is a valid increasing subsequence:

```
dp[i] = 1
```

Example:

```
nums = [5,10,3]

dp = [1,1,1]
```

---

## Transition

For every index:

Look at all future indices.

If:

```
nums[i] < nums[j]
```

then:

```
nums[i] can extend the LIS at j
```

Update:

```
dp[i] = max(dp[i], 1 + dp[j])
```

---

## Traversal Direction

We iterate backwards:

```
right -> left
```

because:

```
dp[i]
```

depends on:

```
dp[j]
```

where:

```
j > i
```

Future answers must already be calculated.

---

## Example

```
nums = [1,3,2,4]
```

Start:

```
dp = [1,1,1,1]
```

Index 2:

```
2 -> 4

dp[2] = 2
```

Index 1:

```
3 -> 4

dp[1] = 2
```

Index 0:

```
1 -> 3 -> 4

dp[0] = 3
```

Answer:

```
3
```

---

# Comparison of Approaches

| Approach | Time | Space | Notes |
|---|---|---|---|
| Recursion | O(2^n) | O(n) | Explores all possibilities |
| Memoization | O(n²) | O(n) | Avoids repeated states |
| Bottom-Up DP | O(n²) | O(n) | Same logic without recursion |

---

# Why Not Track Only Maximum Length?

A common optimization attempt:

```
highestDP
```

However:

The LIS length alone does not tell us which values produced it.

Example:

```
[10,9,2,5,3,7]
```

A sequence length of 3 could be:

```
2,5,7
```

but a different starting value might not be able to extend it.

The actual values matter.

---

# Advanced Optimization

There is an:

```
O(n log n)
```

solution using:

```
binary search + tails array
```

Idea:

Maintain:

```
tails[i]
```

where:

```
tails[i] = smallest possible ending value of an increasing subsequence of length i+1
```

This is based on the patience sorting algorithm.

---

# Key Interview Takeaway

When seeing:

- Longest
- Maximum length
- Optimal subsequence

Think:

```
Define a state representing the best answer from each position
```

For LIS:

```
dp[i] = best increasing subsequence starting at i
```

---

# Related Problems

- Longest Common Subsequence
- Number of LIS
- Russian Doll Envelopes
- Increasing Triplet Subsequence
- Longest String Chain