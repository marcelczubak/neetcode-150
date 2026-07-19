# Min Cost Climbing Stairs

## Problem

You are given an integer array `cost` where:

- `cost[i]` is the cost of stepping on stair `i`.

You may start from either:

- Stair `0`
- Stair `1`

Each move, you may climb:

- 1 stair
- 2 stairs

Return the minimum cost required to reach the **top** (one step beyond the final stair).

---

# Example

Input:

```
cost = [10,15,20]
```

Output:

```
15
```

Explanation:

```
Start at stair 1

Pay 15

Jump directly to the top
```

---

# Key Observation

To reach stair `i`, you must arrive from either:

- `i - 1`
- `i - 2`

Choose whichever route is cheaper.

This gives the recurrence:

```
minCost(i) = cost[i] + min(minCost(i-1), minCost(i-2))
```

---

# Dynamic Programming

Instead of storing a separate DP array, reuse the input array.

After processing:

```
cost[i]
```

no longer represents the original stair cost.

Instead it represents:

```
Minimum total cost required to reach stair i.
```

---

# Algorithm

Starting from stair `2`:

```
cost[i] += min(cost[i-1], cost[i-2])
```

This accumulates the cheapest path to every stair.

Finally, the top is one step beyond the array.

You can reach it from either:

- Last stair
- Second-last stair

Therefore:

```
answer = min(last, secondLast)
```

---

# Why This Works

Each stair only depends on the cheapest way to reach the previous two stairs.

By updating the array in-place, every value becomes the optimal cost to reach that stair.

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

No additional data structures are required.

---

# Pattern Recognition

Keywords:

- Minimum cost
- Previous two states
- One or two steps
- Optimal path

↓

Think:

```
1D Dynamic Programming
```

---

# Related Problems

- Climbing Stairs
- House Robber
- Decode Ways
- Fibonacci Number
- Coin Change