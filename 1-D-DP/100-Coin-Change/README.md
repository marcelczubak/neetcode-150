# Coin Change

## Problem

Given an array of coin denominations `coins` and an integer `amount`, return the **minimum number of coins** needed to make up the amount.

If it is impossible, return `-1`.

You may use each coin an unlimited number of times.

---

# Example

### Input

```
coins = [1,2,5]
amount = 11
```

### Output

```
3
```

Explanation:

```
11 = 5 + 5 + 1
```

---

# Approach

This problem is naturally solved using **Top-Down Dynamic Programming (Memoization)**.

Instead of asking:

> "Which coin should I pick first?"

we ask:

> "What is the minimum number of coins needed to make the remaining amount?"

Each recursive call solves a smaller subproblem.

---

# State

The remaining amount completely defines a subproblem.

```
dfs(amount)
```

returns:

```
minimum coins required to make this amount
```

Notice that we do **not** include the current number of coins used in the state.

---

# Recurrence

For every coin:

```
answer =
1 + dfs(amount - coin)
```

Take the minimum over every possible coin.

```
dfs(amount)

=

1 + min(
    dfs(amount-coin1),
    dfs(amount-coin2),
    ...
)
```

---

# Memoization

Many recursive branches reach the same remaining amount.

Example:

```
11

↓

10

↓

9
```

and

```
11

↓

6

↓

5

↓

4

↓

9
```

Both eventually ask:

```
dfs(9)
```

Instead of solving it repeatedly, store:

```
memo[9]
```

and reuse it whenever needed.

This reduces the exponential recursion to polynomial time.

---

# Base Cases

### Amount becomes zero

```
amount == 0
```

Return:

```
0
```

No more coins are needed.

---

### Amount becomes negative

```
amount < 0
```

Return:

```
Integer.MAX_VALUE
```

This represents an impossible path.

---

# Complexity

Let:

```
A = amount
N = number of coin denominations
```

Time:

```
O(A × N)
```

Each amount is computed once.

For every amount, every coin is tried.

Space:

```
O(A)
```

for the memoization cache and recursion stack.

---

# Why Memoization Works

Without memoization:

```
dfs(7)

↓

dfs(6)

↓

dfs(5)

↓

...
```

The same amounts are recomputed many times.

Memoization ensures every remaining amount is solved only once.

---

# Pattern Recognition

Keywords:

- Minimum
- Unlimited choices
- Remaining amount
- Optimal solution

↓

Think:

```
Dynamic Programming
```

Specifically:

```
Top-Down DP (Memoization)
```

---

# Related Problems

- Coin Change II
- Perfect Squares
- Decode Ways
- Climbing Stairs
- House Robber