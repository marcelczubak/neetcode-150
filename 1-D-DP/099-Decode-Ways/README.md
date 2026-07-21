# Decode Ways

## Problem

A message containing digits can be decoded using the mapping:

```
1 -> A
2 -> B
...
26 -> Z
```

Given a string `s` containing only digits, return the total number of possible decodings.

If no valid decoding exists, return `0`.

---

## Example

### Input

```
s = "226"
```

### Output

```
3
```

### Explanation

```
2 2 6  -> B B F
22 6   -> V F
2 26   -> B Z
```

---

# Approach

This problem is a **Dynamic Programming** problem similar to **Climbing Stairs**.

At every character we have two choices:

1. Decode the current digit alone.
2. Decode the current digit together with the previous digit.

The total number of decodings is the sum of all valid choices.

---

# Dynamic Programming State

Define:

```
dp[i]
```

as:

```
Number of ways to decode the first i characters.
```

Transition:

```
dp[i]

=

(single digit ? dp[i-1] : 0)

+

(two digits ? dp[i-2] : 0)
```

---

# Space Optimization

Notice that each state only depends on:

```
dp[i-1]
dp[i-2]
```

Therefore, instead of storing an entire DP array, we only keep:

```
prev1 = dp[i-1]
prev2 = dp[i-2]
```

Each iteration computes:

```
current
```

then shifts:

```
prev2 = prev1
prev1 = current
```

This reduces the space complexity from **O(n)** to **O(1)**.

---

# Algorithm

For every position:

### Option 1

Check whether the current digit can stand alone.

Valid:

```
1 - 9
```

If valid:

```
current += prev1
```

---

### Option 2

Check whether the previous two digits form:

```
10 - 26
```

If valid:

```
current += prev2
```

---

Update:

```
prev2 = prev1
prev1 = current
```

Repeat until the end of the string.

---

# Complexity

### Time

```
O(n)
```

Each character is processed exactly once.

### Space

```
O(1)
```

Only three variables are maintained.

---

# Why This Works

Every valid decoding must end in exactly one of two ways:

- A single-digit letter.
- A two-digit letter.

These two cases are independent, so the total number of decodings is simply their sum.

---

# Related Problems

- Climbing Stairs
- Coin Change
- House Robber
- Fibonacci DP