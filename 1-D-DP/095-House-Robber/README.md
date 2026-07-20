# House Robber

## Problem

You are a robber planning to rob houses along a street.

Each house contains a certain amount of money.

The only constraint is:

- You **cannot rob two adjacent houses**.

Return the maximum amount of money you can rob.

---

# Example

Input:

```
nums = [2,7,9,3,1]
```

Output:

```
12
```

Explanation:

Rob:

```
2 + 9 + 1 = 12
```

---

# Key Observation

For every house, there are only two choices:

### Rob it

If you rob the current house, you cannot rob the previous one.

```
current = nums[i] + profit two houses back
```

---

### Skip it

If you skip the current house:

```
current = previous maximum
```

---

Choose whichever is larger.

---

# Dynamic Programming

Let:

```
dp[i]
```

represent:

```
Maximum money that can be robbed up to house i.
```

Recurrence:

```
dp[i] = max(
    nums[i] + dp[i-2],
    dp[i-1]
)
```

---

# Space Optimisation

Notice:

```
dp[i]
```

only depends on:

```
dp[i-1]

dp[i-2]
```

Therefore we don't need the entire DP array.

Maintain two variables:

```
rob1 = dp[i-2]

rob2 = dp[i-1]
```

For every house:

```
current = max(nums[i] + rob1, rob2)

rob1 = rob2

rob2 = current
```

---

# Example

```
nums = [2,7,9,3,1]
```

| House | rob1 | rob2 | New Profit |
|------:|-----:|-----:|-----------:|
|2|0|0|2|
|7|0|2|7|
|9|2|7|11|
|3|7|11|11|
|1|11|11|12|

Answer:

```
12
```

---

# Complexity

Time:

```
O(n)
```

One pass through the array.

Space:

```
O(1)
```

Only two variables are stored.

---

# Pattern Recognition

Keywords:

- Maximum profit
- Cannot choose adjacent
- Choose or skip
- Previous states

↓

Think:

```
1D Dynamic Programming
```

---

# Related Problems

- House Robber II
- Climbing Stairs
- Min Cost Climbing Stairs
- Delete and Earn
- Maximum Alternating Subsequence Sum