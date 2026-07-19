# Climbing Stairs

## Problem

You are climbing a staircase with `n` steps.

Each move you can climb:

- `1` step
- `2` steps

Return the number of distinct ways to reach the top.

---

# Example

Input:

```
n = 5
```

Output:

```
8
```

Explanation:

Possible combinations:

```
1 + 1 + 1 + 1 + 1

1 + 1 + 1 + 2

1 + 1 + 2 + 1

1 + 2 + 1 + 1

2 + 1 + 1 + 1

1 + 2 + 2

2 + 1 + 2

2 + 2 + 1
```

---

# Key Observation

This problem follows a Fibonacci pattern.

To reach step `n`:

The final move must be either:

```
1 step from n-1

or

2 steps from n-2
```

Therefore:

```
ways(n) = ways(n-1) + ways(n-2)
```

---

# Dynamic Programming Relation

Base cases:

```
ways(1) = 1

ways(2) = 2
```

Sequence:

```
n = 1 -> 1
n = 2 -> 2
n = 3 -> 3
n = 4 -> 5
n = 5 -> 8
n = 6 -> 13
```

This is Fibonacci shifted by one position.

---

# Space Optimised DP

A normal DP solution would store:

```java
int[] dp = new int[n+1];
```

However, each state only depends on the previous two values:

```
dp[n-1]

dp[n-2]
```

Therefore we only keep:

```java
a = previous value

b = value before previous
```

---

# Algorithm

Initial:

```
a = ways(1)
b = ways(0)
```

For each step:

Calculate:

```
current = a + b
```

Shift values:

```
b = a
a = current
```

Return:

```
a
```

---

# Complexity

Time:

```
O(n)
```

One loop through the staircase.

Space:

```
O(1)
```

Only two variables are stored.

---

# Pattern Recognition

Keywords:

```
Number of ways

Choices at each step

Previous states determine current state
```

Think:

```
Dynamic Programming
```

---

# Related Problems

- House Robber
- Decode Ways
- Fibonacci Number
- Min Cost Climbing Stairs