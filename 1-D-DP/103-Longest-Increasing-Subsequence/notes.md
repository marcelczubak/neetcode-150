# Longest Increasing Subsequence Notes

## Pattern

Dynamic Programming

Category:

```
1D DP
```

---

# Core Question

For every index:

> "What is the longest increasing subsequence I can build from here?"

---

# Recursive Thinking

Function:

```
dfs(i)
```

returns:

```
LIS starting at index i
```

Base:

```
current element alone = 1
```

Choice:

For every future element:

```
if nums[i] < nums[j]
```

take:

```
1 + dfs(j)
```

---

# Recursion Template

```java
private int dfs(int[] nums, int i) {

    int longest = 1;

    for (int j = i + 1; j < nums.length; j++) {

        if (nums[i] < nums[j]) {
            longest = Math.max(
                longest,
                1 + dfs(nums, j)
            );
        }
    }

    return longest;
}
```

---

# Why Recursion Is Slow

Repeated work.

Example:

```
dfs(0)
 |
 +-- dfs(2)

dfs(1)
 |
 +-- dfs(2)
```

Same state calculated multiple times.

---

# Memoization

Store:

```
memo[i]
```

Meaning:

```
LIS starting from i
```

Before recursion:

```java
if(memo[i] != 0)
    return memo[i];
```

After calculating:

```java
memo[i] = result;
```

---

# Bottom-Up DP

Same state:

```
dp[i] = LIS starting at i
```

but calculated iteratively.

Initialization:

```java
Arrays.fill(dp,1);
```

because:

```
Every number alone is increasing
```

---

# Transition

For every pair:

```
i < j
```

If:

```
nums[i] < nums[j]
```

then:

```
dp[i] = max(dp[i],1+dp[j])
```

---

# Traversal

Backward:

```
n-1 -> 0
```

because:

```
dp[i] depends on future states
```

---

# Common Mistakes

## 1. Forgetting initialization

Wrong:

```java
int[] dp = new int[n];
```

because values become:

```
0
```

Correct:

```java
Arrays.fill(dp,1);
```

---

## 2. Checking only adjacent values

Wrong:

```
nums[i] < nums[i+1]
```

The LIS may skip many elements.

Need:

```
all j > i
```

---

## 3. Confusing subsequence and subarray

Subsequence:

```
[1,5,3,7]

[1,3,7]
```

Subarray:

```
[5,3]
```

must be continuous.

---

# Complexity Summary

## Recursion

```
Time: O(2^n)
Space: O(n)
```

---

## Memoization

```
Time: O(n²)
Space: O(n)
```

---

## Bottom-Up DP

```
Time: O(n²)
Space: O(n)
```

---

# Interview Explanation

"I first model the problem recursively where each index represents the longest increasing subsequence starting there. This creates overlapping subproblems, so I memoize the result for each index. The bottom-up DP solution is the iterative equivalent where I compute the same states from right to left."

---

# Mental Model

Recursion:

```
Try every possibility
```

Memoization:

```
Try every possibility once
```

Dynamic Programming:

```
Build the answers systematically
```