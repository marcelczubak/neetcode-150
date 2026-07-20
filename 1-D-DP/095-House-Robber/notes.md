# House Robber Notes

## Pattern

```
1D Dynamic Programming
```

Optimised to:

```
Constant Space DP
```

---

# Main Insight

At every house there are only two choices.

### Rob

```
Take current money

+

Best profit two houses back
```

```
nums[i] + dp[i-2]
```

---

### Skip

```
Keep previous best
```

```
dp[i-1]
```

Choose:

```
max(rob, skip)
```

---

# DP Relation

```
dp[i] = max(
    nums[i] + dp[i-2],
    dp[i-1]
)
```

---

# Space Optimisation

Only two previous states are needed.

Store:

```java
rob1 = dp[i-2];

rob2 = dp[i-1];
```

Update:

```java
current = Math.max(nums[i] + rob1, rob2);

rob1 = rob2;

rob2 = current;
```

---

# Variable Meaning

```
rob1
```

Maximum profit up to:

```
i-2
```

---

```
rob2
```

Maximum profit up to:

```
i-1
```

---

```
current
```

Maximum profit including current decision.

---

# Example

```
nums = [2,7,9,3,1]
```

Iteration:

```
House 2

max(2 + 0, 0)

=

2
```

```
House 7

max(7 + 0, 2)

=

7
```

```
House 9

max(9 + 2, 7)

=

11
```

Continue until the end.

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```

---

# Interview Explanation

"I recognised this as a 1D Dynamic Programming problem because each decision depends only on the previous two optimal states. At each house I either rob it, adding its value to the best solution two houses back, or skip it and keep the previous best solution. Since only the previous two DP states are needed, I optimised the solution from O(n) space to O(1) using two variables."

---

# Recognition Pattern

If you see:

- Maximum value
- Cannot pick adjacent elements
- Choose or skip
- Previous decisions matter

↓

Think:

```
1D Dynamic Programming
```

---

# Similar Problems

- House Robber II
- Climbing Stairs
- Min Cost Climbing Stairs
- Delete and Earn
- Maximum Alternating Subsequence Sum