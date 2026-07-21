# Longest Increasing Subsequence (LIS)

## Problem

Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

A subsequence:
- Maintains the original order of elements.
- Does not need to be contiguous.

---

## Example 1

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

## Example 2

### Input

```
nums = [0,1,0,3,2,3]
```

### Output

```
4
```

### Explanation

One possible LIS:

```
[0,1,2,3]
```

---

# Approach

## Dynamic Programming (Bottom-Up)

We define:

```
dp[i] = length of the longest increasing subsequence starting at index i
```

Every element can form an increasing subsequence by itself:

```
dp[i] = 1
```

---

## Transition

For every index `i`, check all elements after it.

If:

```
nums[i] < nums[j]
```

then `nums[j]` can extend the subsequence starting at `i`.

Therefore:

```
dp[i] = max(dp[i], 1 + dp[j])
```

---

## Example

```
nums = [1,3,4,2]
```

Start from the end:

```
dp[3] = 1
```

because:

```
[2]
```

At index 1:

```
nums[1] = 3
```

Can extend:

```
3 -> 4
```

so:

```
dp[1] = 2
```

At index 0:

```
nums[0] = 1
```

Can extend:

```
1 -> 3 -> 4
```

so:

```
dp[0] = 3
```

---

# Algorithm

1. Create a DP array.
2. Initialize every value to `1`.
3. Traverse from right to left.
4. For every index:
   - Check every future index.
   - If a larger number exists:
       - Update the LIS length.
5. Track the maximum value found.

---

# Complexity

Let:

```
n = length of nums
```

## Time Complexity

```
O(n²)
```

Explanation:

Each element checks every element after it.

Number of comparisons:

```
n + (n-1) + (n-2) + ...
```

which simplifies to:

```
O(n²)
```

---

## Space Complexity

```
O(n)
```

The DP array stores the LIS length for every index.

---

# Key DP Pattern

When a problem asks:

- "Longest..."
- "Maximum length..."
- "Best subsequence..."

Think:

```
dp[i] = best answer involving index i
```

---

# Important Details

## Subsequence vs Subarray

### Subsequence

Elements can be skipped:

```
[1,5,3,7]

LIS:
[1,3,7]
```

### Subarray

Must be continuous:

```
[1,5,3,7]

Subarray:
[5,3]
```

---

# Common Mistakes

## 1. Forgetting initialization

Wrong:

```java
int[] dp = new int[n];
```

because all values start at:

```
0
```

Correct:

```java
Arrays.fill(dp, 1);
```

because every element alone is a valid subsequence.

---

## 2. Comparing adjacent values only

Wrong idea:

```
if nums[i] < nums[i+1]
```

The next element does not necessarily create the best subsequence.

Need to check:

```
all future elements
```

---

## 3. Confusing LIS direction

Two valid definitions exist:

Starting from index:

```
dp[i] = LIS starting at i
```

or ending at index:

```
dp[i] = LIS ending at i
```

Both work, but transitions differ.

This solution uses:

```
starting at i
```

---

# Optimization

There is an advanced:

```
O(n log n)
```

solution using:

```
binary search + tails array
```

The idea:

Maintain the smallest possible ending value for every LIS length.

Example:

```
tails[0] = smallest tail of length 1
tails[1] = smallest tail of length 2
...
```

This reduces the time complexity but is less intuitive.

The O(n²) DP solution is the standard interview solution.