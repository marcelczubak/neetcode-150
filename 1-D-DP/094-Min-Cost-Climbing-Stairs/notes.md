# Min Cost Climbing Stairs Notes

## Pattern

```
1D Dynamic Programming
```

Optimised to:

```
In-place DP
```

---

# Main Insight

To reach stair `i`:

You must come from:

```
i-1

or

i-2
```

Choose the cheaper path.

Recurrence:

```
dp[i] = cost[i] + min(dp[i-1], dp[i-2])
```

---

# In-Place DP

Instead of:

```java
int[] dp = new int[n];
```

reuse the input array.

Initially:

```
cost[i]
```

means:

```
Cost of stepping on stair i
```

After processing:

```
cost[i]
```

means:

```
Minimum cost to reach stair i
```

---

# Transition

For every stair:

```java
cost[i] += Math.min(cost[i-1], cost[i-2]);
```

Each stair stores the cheapest cumulative cost.

---

# Final Answer

The destination is **not** the last stair.

It is:

```
One step beyond the last stair.
```

Therefore you may finish from either:

```
Last stair

Second-last stair
```

Return:

```java
Math.min(cost[n-1], cost[n-2]);
```

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

Using the input array as DP storage.

---

# Interview Explanation

"I recognised this as a 1D DP problem because each state depends only on the previous two states. Instead of creating a separate DP array, I updated the input array in-place so that each element stores the minimum cumulative cost to reach that stair. Since the top lies beyond the final index, the answer is the minimum of the last two computed values."

---

# Difference from Climbing Stairs

| Climbing Stairs | Min Cost Climbing Stairs |
|-----------------|--------------------------|
| Count number of ways | Minimise total cost |
| `dp[i] = dp[i-1] + dp[i-2]` | `dp[i] = cost[i] + min(dp[i-1], dp[i-2])` |
| Fibonacci sequence | Dynamic Programming with minimum |

---

# Similar Problems

- Climbing Stairs
- House Robber
- Decode Ways
- Coin Change
- Minimum Path Sum