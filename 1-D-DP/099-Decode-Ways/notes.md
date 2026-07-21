# Decode Ways Notes

## Pattern

Dynamic Programming

Very similar to:

- Climbing Stairs
- Fibonacci
- House Robber

---

# DP State

```
dp[i]
```

=

```
Number of ways to decode the first i characters.
```

Only the previous two states are required.

---

# Recurrence

At each position:

### Case 1

Decode one digit.

Valid:

```
1-9
```

Contribution:

```
dp[i-1]
```

---

### Case 2

Decode two digits.

Valid:

```
10-26
```

Contribution:

```
dp[i-2]
```

---

Formula

```
dp[i]

=

(single digit ? dp[i-1] : 0)

+

(two digits ? dp[i-2] : 0)
```

---

# Space Optimization

Instead of:

```
dp[]
```

keep:

```
prev2 = dp[i-2]
prev1 = dp[i-1]
```

Each iteration:

```java
int current = 0;

if (single digit valid)
    current += prev1;

if (two digits valid)
    current += prev2;

prev2 = prev1;
prev1 = current;
```

This is a standard rolling DP optimization.

---

# Base Cases

Empty string:

```
dp[0] = 1
```

There is exactly one way to decode nothing.

---

First character:

```
dp[1]
```

If:

```
s[0] != '0'
```

then:

```
1
```

Otherwise:

```
0
```

---

# Example

```
s = "226"
```

Start

```
prev2 = 1
prev1 = 1
```

Character 2

```
22

Single:
2

+

Double:
22

current = 2
```

Update

```
prev2 = 1
prev1 = 2
```

Character 6

```
226

Single:
6

+

Double:
26

current = 3
```

Answer

```
3
```

---

# Common Mistakes

## Forgetting leading zeros

```
"06"
```

is invalid.

---

## Allowing

```
27
```

as a pair.

Only:

```
10-26
```

are valid.

---

## Using the whole DP array unnecessarily

Only two previous states are needed.

Space can be reduced from:

```
O(n)
```

to:

```
O(1)
```

---

# Interview Explanation

"I treat this as a Dynamic Programming problem where each state represents the number of ways to decode the prefix of the string. At every position I consider two possibilities: decoding the current digit alone or decoding it together with the previous digit. Since each state depends only on the previous two states, I optimize the DP array into two rolling variables, reducing the space complexity to O(1)."

---

# Complexity

Time

```
O(n)
```

Space

```
O(1)
```