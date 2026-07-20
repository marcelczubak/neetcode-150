# House Robber II

## Problem

You are a robber planning to rob houses arranged **in a circle**.

Each house contains some amount of money.

The only constraint is:

- You **cannot rob two adjacent houses**.
- Since the houses form a circle, the **first and last houses are also adjacent**.

Return the maximum amount of money you can rob.

---

# Example

Input:

```
nums = [2,3,2]
```

Output:

```
3
```

Explanation:

You cannot rob both houses containing `2` because they are adjacent in the circle.

---

# Key Observation

The circular arrangement introduces exactly one new restriction:

```
You cannot rob both the first and last house.
```

Therefore, every valid solution falls into one of two cases:

### Case 1

Do **not** rob the last house.

Solve House Robber I on:

```
[0 ... n-2]
```

---

### Case 2

Do **not** rob the first house.

Solve House Robber I on:

```
[1 ... n-1]
```

The answer is simply:

```
max(case1, case2)
```

---

# Why This Works

Every valid robbery plan must exclude either:

- the first house
- or the last house

There is no third possibility.

Therefore solving both linear cases guarantees the optimal solution.

---

# House Robber I Recurrence

For a linear street:

```
dp[i] = max(
    nums[i] + dp[i-2],
    dp[i-1]
)
```

Space can be reduced to two variables:

```
rob1 = dp[i-2]

rob2 = dp[i-1]
```

---

# Edge Case

If there is only one house:

```
return nums[0];
```

Otherwise both subproblems would be empty.

---

# Complexity

Each House Robber I call is:

```
O(n)
```

Running it twice is still:

```
O(n)
```

Space:

```
O(1)
```

(using index ranges instead of copying arrays)

---

# Pattern Recognition

Whenever a linear DP problem becomes circular, ask:

```
Can I split it into a few linear cases?
```

This idea appears frequently in interview questions.

---

# Related Problems

- House Robber
- Delete and Earn
- Climbing Stairs
- Min Cost Climbing Stairs