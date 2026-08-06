# Best Time to Buy and Sell Stock with Cooldown

## Problem

You are given an array `prices` where:

```text
prices[i]
```

is the price of a stock on day `i`.

You may complete as many transactions as you like, but:

- You may only hold **one** stock at a time.
- After selling a stock, you must wait **one day** before buying again (cooldown).

Return the maximum profit that can be achieved.

---

## Example

### Input

```text
prices = [1,2,3,0,2]
```

### Output

```text
3
```

### Explanation

```text
Buy  at 1

↓

Sell at 2

↓

Cooldown

↓

Buy  at 0

↓

Sell at 2
```

Profit:

```text
1 + 2 = 3
```

---

# Approach

## DFS + Memoization (Top-Down DP)

For every day, the available actions depend on whether we are currently holding a stock.

There are only two possible states:

- Holding a stock
- Not holding a stock

This naturally forms a recursive dynamic programming problem.

Memoization ensures each state is computed only once.

---

# DP State

Define:

```java
findProfit(day, holding)
```

as:

```text
The maximum profit that can still be earned starting from this day.
```

The state consists of:

- Current day
- Whether a stock is currently held

These two values completely determine all future decisions.

---

# Recurrence

## Holding a Stock

Two choices:

### Sell Today

Earn today's price.

Because of the cooldown, move two days forward.

```text
prices[day] + DP(day + 2, false)
```

---

### Keep Holding

Do nothing today.

```text
DP(day + 1, true)
```

Take the better option.

---

## Not Holding a Stock

Two choices.

### Buy Today

Spend today's price.

```text
-price[day] + DP(day + 1, true)
```

---

### Skip Today

Do nothing.

```text
DP(day + 1, false)
```

Take the better option.

---

# Algorithm

### Step 1

Start recursion:

```java
findProfit(0, false)
```

Initially no stock is owned.

---

### Step 2

If this state has already been computed:

```java
cache[day][holding]
```

return the cached value.

---

### Step 3

If holding a stock:

```java
max(
    prices[day] + DP(day+2, false),
    DP(day+1, true)
)
```

---

### Step 4

If not holding a stock:

```java
max(
    -prices[day] + DP(day+1, true),
    DP(day+1, false)
)
```

---

### Step 5

Store the answer in the memoization table.

---

# Example Walkthrough

Input:

```text
prices = [1,2,3,0,2]
```

Day 0:

```text
Buy

or

Skip
```

Suppose we buy:

```text
Profit = -1
```

Day 1:

```text
Sell

or

Hold
```

If sold:

```text
+2

↓

Cooldown

↓

Day 3
```

Continue exploring every possibility.

Memoization guarantees each `(day, holding)` state is solved only once.

---

# Why This Works

Every day presents a small number of valid decisions.

The future depends only on:

- Current day
- Whether a stock is currently held

Since these states repeat frequently during recursion, memoization eliminates redundant work and produces an optimal linear-time solution.

---

# Complexity

Let:

```text
n = prices.length
```

## Time Complexity

There are only:

```text
2 × n
```

unique states.

Each state is computed once.

```text
O(n)
```

---

## Space Complexity

Memoization table:

```text
O(n)
```

Recursive call stack:

```text
O(n)
```

Total:

```text
O(n)
```

---

# Pattern Recognition

When you see:

- buy or sell decisions
- cooldown or transaction constraints
- maximize profit

Think:

```text
Dynamic Programming

+

State Machine

+

Memoization
```

---

# Related Problems

- Best Time to Buy and Sell Stock
- Best Time to Buy and Sell Stock II
- Best Time to Buy and Sell Stock III
- Best Time to Buy and Sell Stock with Transaction Fee