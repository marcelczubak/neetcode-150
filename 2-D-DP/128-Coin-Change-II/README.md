# Coin Change II

## Problem

You are given:

- An integer `amount`
- An array of coin denominations `coins`

Return the number of **different combinations** of coins that sum to `amount`.

You may use each coin **an unlimited number of times**.

The order of coins does **not** matter.

---

## Example

### Input

```text
amount = 5

coins = [1,2,5]
```

### Output

```text
4
```

### Explanation

```text
5

2 + 2 + 1

2 + 1 + 1 + 1

1 + 1 + 1 + 1 + 1
```

---

## Approach

### DFS + Memoization

At every recursive call, we decide **which coin denomination to use next**.

To avoid counting the same combination in different orders, we only allow choosing coins from the current index onward.

For example:

```text
1 + 2 + 2
```

is allowed, but

```text
2 + 1 + 2
```

is never explored because recursion never moves backwards to earlier coin denominations.

This guarantees every combination is counted exactly once.

Memoization stores the answer for each subproblem so repeated states are never recomputed.

---

## Recursive State

Define:

```java
tryCombinations(currentIndex, amount)
```

as:

```text
The number of ways to make the remaining amount using only coins from currentIndex onwards.
```

The state is completely determined by:

- Current coin index
- Remaining amount

---

## Algorithm

### Step 1

Start with:

```java
tryCombinations(0, amount)
```

meaning every coin denomination is available.

---

### Step 2

Handle the base cases.

If:

```text
amount == 0
```

a valid combination has been found.

Return:

```text
1
```

If:

```text
amount < 0
```

or all coin denominations have been considered:

```text
0
```

combinations exist.

---

### Step 3

Check the memoization cache.

If the current state has already been solved, return the stored answer immediately.

---

### Step 4

Try every possible coin beginning from the current index.

```java
for (int i = currentIndex; i < coins.length; i++)
```

Choosing coin `i` means:

- reduce the remaining amount
- keep the same index `i` because coins may be reused infinitely

```java
tryCombinations(i, amount - coins[i])
```

---

### Step 5

Sum every valid result.

Store the total in the cache before returning.

---

## Example Walkthrough

Input:

```text
amount = 5

coins = [1,2,5]
```

Start:

```text
amount = 5

currentIndex = 0
```

Possible choices:

```text
Take 1

↓

amount = 4
```

```text
Take 2

↓

amount = 3
```

```text
Take 5

↓

amount = 0

↓

Found one combination
```

Each recursive branch continues exploring combinations while maintaining non-decreasing coin order.

Memoization prevents identical states from being recomputed.

---

## Why This Works

Each recursive state represents:

```text
Remaining Amount

+

Current Coin Index
```

Because recursion never moves to earlier coin denominations, permutations such as:

```text
2 + 1 + 2
```

are never generated.

Only unique combinations are counted.

Memoization ensures every state is solved only once.

---

## Complexity

Let:

```text
n = number of coin denominations

A = target amount
```

### Time Complexity

There are at most:

```text
n × A
```

unique states.

Each state is computed once.

Overall complexity:

```text
O(n × A × n)
```

because each state loops over the remaining coin denominations.

---

### Space Complexity

Memoization table:

```text
O(n × A)
```

Recursive call stack:

```text
O(A)
```

---

## Pattern Recognition

When you see:

- count combinations
- unlimited reuse
- order does not matter

Think:

```text
DFS

+

Memoization

+

Choose-or-Reuse Pattern
```

---

## Related Problems

- Coin Change
- Combination Sum
- Target Sum
- Partition Equal Subset Sum