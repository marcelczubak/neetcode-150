# Counting Bits

## Problem

Given an integer `n`, return an array `dp` where:

```
dp[i]
```

contains the number of `1` bits in the binary representation of every integer:

```
0 ≤ i ≤ n
```

---

## Example

### Input

```text
n = 5
```

### Output

```text
[0,1,1,2,1,2]
```

### Explanation

```text
0  -> 000 -> 0

1  -> 001 -> 1

2  -> 010 -> 1

3  -> 011 -> 2

4  -> 100 -> 1

5  -> 101 -> 2
```

---

# Approach

## Dynamic Programming

Observe what happens whenever we reach a new power of two.

Example:

```text
0      0

1      1
```

```
10     1

11     2
```

```
100    1

101    2

110    2

111    3
```

Notice:

```
100

=

1 + bits(000)
```

```
101

=

1 + bits(001)
```

```
110

=

1 + bits(010)
```

```
111

=

1 + bits(011)
```

Each block repeats the previous block with one additional leading `1`.

---

# Key Observation

Suppose the current power of two is:

```
offset
```

Every number between:

```
offset

and

2 × offset - 1
```

can be written as:

```
offset + x
```

where:

```
0 ≤ x < offset
```

Therefore:

```
bits(offset + x)

=

1 + bits(x)
```

This leads to the DP recurrence:

```java
dp[i] = 1 + dp[i - offset];
```

---

# Algorithm

### Step 1

Initialize:

```java
dp[0] = 0;
```

---

### Step 2

Maintain:

```java
offset
```

representing the largest power of two seen so far.

Initially:

```java
offset = 1;
```

---

### Step 3

Whenever:

```java
i == offset * 2
```

update:

```java
offset *= 2;
```

The next power-of-two block begins.

---

### Step 4

Compute:

```java
dp[i] = 1 + dp[i - offset];
```

The current number shares the same lower bits as:

```
i - offset
```

but has one extra leading `1`.

---

# Example Walkthrough

Suppose:

```
n = 7
```

Current block:

```
offset = 4
```

Numbers:

```
4

↓

100
```

```
5

↓

101
```

```
6

↓

110
```

```
7

↓

111
```

Compute:

```
dp[4] = 1 + dp[0] = 1
```

```
dp[5] = 1 + dp[1] = 2
```

```
dp[6] = 1 + dp[2] = 2
```

```
dp[7] = 1 + dp[3] = 3
```

Result:

```text
[0,1,1,2,1,2,2,3]
```

---

# Why This Works

Every positive integer belongs to a block beginning at a power of two.

Removing that highest power of two leaves:

```
i - offset
```

whose bit count has already been computed.

Adding back the leading `1` increases the answer by exactly one.

---

# Complexity

Let:

```
n = input
```

## Time Complexity

Each value is computed once.

```
O(n)
```

---

## Space Complexity

DP array:

```
O(n)
```

---

# Pattern Recognition

When you see:

- count bits
- binary patterns
- repeated power-of-two structure

Think:

```
Dynamic Programming

+

Power of Two
```

---

# Related Problems

- Number of 1 Bits
- Reverse Bits
- Single Number
- Power of Two