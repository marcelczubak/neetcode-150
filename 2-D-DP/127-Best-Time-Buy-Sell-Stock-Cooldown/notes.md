# Best Time to Buy and Sell Stock with Cooldown Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- State Machine

---

# Core Idea

The future only depends on two pieces of information:

```text
Current Day

+

Holding a Stock?
```

This defines the complete DP state.

---

# DP State

Define:

```java
findProfit(day, holding)
```

Meaning:

```text
Maximum future profit starting from this state.
```

Store:

```java
cache[day][holding]
```

where:

```text
holding = 0

↓

Not holding a stock
```

```text
holding = 1

↓

Holding a stock
```

---

# Holding State

If currently holding a stock:

Two choices exist.

## Sell

Receive today's price.

```java
prices[day]
```

Cooldown for one day.

Next state:

```java
(day + 2, false)
```

---

## Hold

Do nothing.

Next state:

```java
(day + 1, true)
```

Recurrence:

```java
max(
    prices[day] + DP(day + 2, false),
    DP(day + 1, true)
)
```

---

# Not Holding State

Again, two choices.

## Buy

Spend today's price.

```java
-prices[day]
```

Next state:

```java
(day + 1, true)
```

---

## Skip

Do nothing.

Next state:

```java
(day + 1, false)
```

Recurrence:

```java
max(
    -prices[day] + DP(day + 1, true),
    DP(day + 1, false)
)
```

---

# Base Case

If:

```java
day >= prices.length
```

Return:

```text
0
```

No more trading days remain.

---

# Memoization

Each state is uniquely identified by:

```text
(day, holding)
```

Before solving:

```java
if(cache[day][holding] != null)
```

return the stored answer.

Each state is computed exactly once.

---

# Example

```text
prices = [1,2,3,0,2]
```

Day 0:

```text
Not Holding
```

Choices:

```text
Buy

↓

Holding
```

or

```text
Skip

↓

Still Not Holding
```

If holding on day 2:

```text
Sell

↓

Cooldown

↓

Day 4
```

The cooldown is handled naturally by jumping to:

```java
day + 2
```

---

# Why Memoization Helps

Without caching, the same state:

```text
(day = 4, holding = true)
```

may be reached from multiple trading sequences.

Memoization ensures:

```text
Each (day, holding) state is solved only once.
```

---

# Common Mistakes

## Including Current Profit in the State

Wrong:

```java
(day, holding, profit)
```

Profit only describes the past.

Future decisions do not depend on it.

---

## Forgetting the Cooldown

After selling:

```text
Cannot buy tomorrow.
```

Move directly to:

```java
day + 2
```

---

## Changing Holding State Incorrectly

Holding:

```text
Sell

↓

Not Holding
```

Holding:

```text
Hold

↓

Still Holding
```

Not holding:

```text
Buy

↓

Holding
```

Not holding:

```text
Skip

↓

Still Not Holding
```

Only **buy** and **sell** change the holding state.

---

# Interview Explanation

"I define my DP state as `(day, holding)`, where the function returns the maximum future profit starting from that state. If I'm holding a stock, I either sell it today and move two days forward because of the cooldown, or continue holding. If I'm not holding a stock, I either buy today or skip the day. Since there are only two possible holding states for each day, memoization reduces the solution to `O(n)` time."

---

# Complexity

Time:

```text
O(n)
```

Space:

```text
O(n)
```

---

# Key Takeaway

The most important insight is that **current profit is not part of the DP state**.

Only these two values determine future decisions:

```text
(Current Day, Holding?)
```

Once this state is identified, each state has exactly two possible actions:

```text
Holding

↓

Sell

or

Hold
```

```text
Not Holding

↓

Buy

or

Skip
```

This transforms the stock trading problem into a simple two-state dynamic programming problem with memoization.