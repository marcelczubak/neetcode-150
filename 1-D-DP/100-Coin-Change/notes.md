# Coin Change Notes

## Pattern

Top-Down Dynamic Programming (Memoization)

---

# Core Idea

Instead of tracking:

```
coins used
```

track:

```
remaining amount
```

The remaining amount uniquely defines every subproblem.

---

# DP State

```
dfs(amount)
```

returns:

```
minimum coins required to make amount
```

---

# Transition

For every coin:

```
take coin

↓

solve remaining amount

↓

add one coin
```

Formula:

```
answer = min(
    1 + dfs(amount - coin)
)
```

---

# Memoization

Store:

```
memo[amount]
```

Example:

```
memo[11] = 3
memo[7] = 2
memo[4] = 2
```

Whenever the same amount appears again:

```
return memo[amount]
```

instead of recomputing.

---

# Base Cases

### Exact amount reached

```
amount == 0
```

Return:

```
0
```

---

### Invalid path

```
amount < 0
```

Return:

```
Integer.MAX_VALUE
```

representing impossible.

---

# Overflow Pitfall

Never write:

```java
1 + Integer.MAX_VALUE
```

This overflows into a negative number.

Instead:

```java
int res = dfs(...);

if (res != Integer.MAX_VALUE) {
    answer = Math.min(answer, res + 1);
}
```

---

# Returning the Answer

If the result is still:

```
Integer.MAX_VALUE
```

then no valid combination exists.

Return:

```java
-1
```

Otherwise:

```
return result
```

---

# Complexity

Time:

```
O(amount × number of coins)
```

Each amount is solved once.

Space:

```
O(amount)
```

for the memoization cache and recursion stack.

---

# Why Memoization Improves Performance

Without memoization:

```
dfs(11)

├── dfs(10)
├── dfs(9)
├── dfs(6)
```

Later:

```
dfs(10)

↓

dfs(9)
```

The subtree for:

```
dfs(9)
```

would be recomputed.

Memoization avoids this completely.

---

# Interview Explanation

"I model each subproblem as the minimum number of coins needed for a remaining amount. For every coin denomination, I recursively solve the smaller amount and take the minimum result. Since many recursive calls reach the same remaining amount, I cache each computed result in a memoization map. This reduces the exponential recursive solution to O(amount × number of coins)."

---

# Common Mistakes

❌ Including `numCoins` in the DP state.

The remaining amount alone defines the subproblem.

---

❌ Forgetting to memoize.

This causes exponential recursion.

---

❌ Overflowing with:

```java
1 + Integer.MAX_VALUE
```

Always check before adding one.

---

❌ Returning `Integer.MAX_VALUE`.

Convert it to:

```java
-1
```

before returning to match the problem requirements.

---

# Related Problems

- Coin Change II
- Decode Ways
- House Robber
- Climbing Stairs
- Perfect Squares