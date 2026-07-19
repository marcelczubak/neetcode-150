# Climbing Stairs Notes

## Pattern

```
1D Dynamic Programming
```

Optimised into:

```
Fibonacci
```

---

# Main Insight

The last step can only come from:

```
n - 1

or

n - 2
```

Therefore:

```
dp[n] = dp[n-1] + dp[n-2]
```

---

# Example

```
n = 5
```

Build the sequence:

```
dp[1] = 1

dp[2] = 2

dp[3] = 3

dp[4] = 5

dp[5] = 8
```

---

# Normal DP

Would use:

```java
int[] dp = new int[n+1];
```

Example:

```java
dp[i] = dp[i-1] + dp[i-2];
```

Problem:

```
O(n) space
```

---

# Optimised DP

Only need the last two values:

```java
int a = previous;
int b = beforePrevious;
```

Update:

```java
int temp = a;

a = a + b;

b = temp;
```

---

# Important Concept

Many DP problems can be reduced from:

```
Store every state
```

to:

```
Store only required previous states
```

if the transition only depends on a fixed number of previous values.

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

"I noticed the recurrence relation is Fibonacci because the number of ways to reach step n is the sum of the ways to reach the previous two steps. Since each state only depends on the last two states, I can optimise the DP array into two variables."

---

# Recognition Pattern

If you see:

```
How many ways?

At each position there are choices

Previous choices affect current result
```

Consider:

```
Dynamic Programming
```

---

# Similar Problems

- Min Cost Climbing Stairs
- House Robber
- Decode Ways
- Unique Paths
```