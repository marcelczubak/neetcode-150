# Coin Change II Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Combinations

---

# Core Idea

Define:

```java
tryCombinations(index, amount)
```

as:

```text
Number of ways to form the remaining amount using coins from index onwards.
```

Every state depends on:

```text
Current Coin Index

+

Remaining Amount
```

---

# Why Keep the Same Index?

Suppose:

```text
coins = [1,2,5]
```

Choosing:

```text
2
```

does **not** remove it.

You may use:

```text
2 + 2 + 2
```

Therefore recurse with:

```java
tryCombinations(i, amount - coins[i])
```

not:

```java
i + 1
```

---

# Why Start the Loop at currentIndex?

Looping from:

```java
currentIndex
```

prevents duplicate permutations.

Allowed:

```text
1 + 2 + 2
```

Not explored:

```text
2 + 1 + 2
```

The recursion only moves forward through the coin list.

---

# DP State

The memoization key consists of:

```text
(currentIndex, amount)
```

Store:

```java
cache[currentIndex][amount]
```

Before solving:

```java
if(cache[currentIndex][amount] != null)
```

return the stored answer.

---

# Base Cases

## Valid Combination

```java
amount == 0
```

Return:

```text
1
```

One complete combination has been formed.

---

## Impossible State

If:

```java
amount < 0
```

or:

```java
currentIndex == coins.length
```

Return:

```text
0
```

No valid combination exists.

---

# Example

```text
amount = 4

coins = [1,2]
```

State:

```text
(index=0, amount=4)
```

Choices:

```text
Take 1

↓

(index=0, amount=3)
```

or

```text
Take 2

↓

(index=1, amount=2)
```

Each branch independently counts valid combinations.

---

# Why Memoization Helps

Without caching:

```text
(index=1, amount=2)
```

can be reached from multiple recursive paths.

Memoization guarantees:

```text
Each state is solved exactly once.
```

---

# Common Mistakes

## Using i + 1

This prevents reusing the same coin.

Incorrect for this problem because each denomination has unlimited supply.

---

## Restarting from Index 0

Doing:

```java
for(int i = 0; ...)
```

at every recursion counts permutations.

Example:

```text
1 + 2

2 + 1
```

Both would be counted separately.

---

## Memoizing Only Amount

The remaining amount alone is not enough.

Example:

```text
amount = 4
```

using:

```text
coins = [1,2]
```

is different from:

```text
coins = [2]
```

The current coin index must also be part of the state.

---

# Interview Explanation

"I define each recursive state as the number of ways to form the remaining amount using only the current coin denomination and those after it. At every step, I try each available coin while allowing unlimited reuse by keeping the same index. Starting each loop at the current index prevents duplicate permutations. Since many `(index, amount)` states repeat, I memoize them in a 2D cache so each state is computed only once."

---

# Complexity

Time:

```text
O(n × A × n)
```

where:

- `n` = number of coin denominations
- `A` = target amount

Space:

```text
O(n × A)
```

for the memoization table.

---

# Key Takeaway

The important insight is defining the DP state:

```text
(index, remainingAmount)
```

The `index` prevents duplicate permutations by ensuring coin denominations are only considered in non-decreasing order, while the `remainingAmount` tracks progress toward the target. Memoization transforms the exponential recursive search into a polynomial-time dynamic programming solution.