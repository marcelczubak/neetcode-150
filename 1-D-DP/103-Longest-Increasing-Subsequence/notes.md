# Longest Increasing Subsequence Notes

## Pattern

Dynamic Programming

Category:

```
1D DP
```

---

# Main Insight

The current element can be part of many different increasing subsequences.

For each index:

Ask:

> "What is the longest increasing subsequence I can build starting from here?"

---

# DP State

```
dp[i]
```

means:

```
The length of the LIS starting at index i
```

Example:

```
nums = [1,3,4,2]

index 0:

1 -> 3 -> 4

dp[0] = 3
```

---

# Base Case

Every individual element is already a valid subsequence.

Therefore:

```
dp[i] = 1
```

for every index.

---

# Transition

For each index:

Look at all numbers after it.

If:

```
nums[i] < nums[j]
```

then:

```
nums[j]
```

can extend the sequence.

Update:

```
dp[i] = max(dp[i], 1 + dp[j])
```

---

# Traversal Direction

We traverse backwards:

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

So future values must already be calculated.

---

# Example Walkthrough

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
1 -> 2 -> 4

dp[0] = 3
```

Answer:

```
3
```

---

# Why Not Track Only Maximum?

A tempting optimization:

```
highestDP
```

However:

The LIS length alone is not enough.

You also need to know:

```
which values created that length
```

Example:

```
[10,9,2,5,3,7]
```

A length of 3 could come from:

```
2,5,7
```

but a different starting value may not be able to extend it.

The actual values matter.

---

# Java Implementation

Initialization:

```java
Arrays.fill(dp, 1);
```

Transition:

```java
if (nums[i] < nums[j]) {
    dp[i] = Math.max(dp[i], 1 + dp[j]);
}
```

---

# Complexity

Time:

```
O(n²)
```

Space:

```
O(n)
```

---

# Interview Explanation

"I use dynamic programming where dp[i] represents the longest increasing subsequence starting at index i. Since each state depends on future indices, I iterate from right to left. For every index, I check all later values and extend the subsequence whenever a larger number is found."

---

# Related Problems

- Longest Common Subsequence
- Longest Increasing Subsequence II
- Russian Doll Envelopes
- Number of Longest Increasing Subsequence
- Patience Sorting