# Counting Bits Notes

## Pattern

- Dynamic Programming
- Bit Manipulation

---

# Core Insight

Binary numbers repeat a simple pattern around powers of two.

Example:

```
0

↓

0
```

```
1

↓

1
```

```
10

↓

1
```

```
11

↓

2
```

```
100

↓

1
```

```
101

↓

2
```

```
110

↓

2
```

```
111

↓

3
```

Every new power of two starts a block that is identical to the previous block, except every number has one extra leading `1`.

---

# Offset

Maintain:

```java
offset
```

This stores the largest power of two less than or equal to the current number.

Example:

```
i = 13

↓

1101
```

Largest power of two:

```
8

↓

1000
```

Therefore:

```
offset = 8
```

---

# DP Relation

Any number can be written as:

```
offset + remainder
```

Example:

```
13

=

8 + 5
```

Binary:

```
1101

=

1000

+

0101
```

The leading `1` contributes:

```
1 bit
```

The remaining bits are exactly:

```
5

↓

0101
```

whose answer is already known.

Therefore:

```java
dp[i] = 1 + dp[i - offset];
```

---

# Updating Offset

Initially:

```java
offset = 1;
```

Whenever:

```java
i == offset * 2
```

the next power of two has been reached.

Update:

```java
offset *= 2;
```

---

# Example

Compute:

```
dp[6]
```

Binary:

```
110
```

Largest power of two:

```
100
```

Offset:

```
4
```

Remaining:

```
6 - 4 = 2

↓

10
```

Already known:

```
dp[2] = 1
```

Therefore:

```
dp[6]

=

1 + dp[2]

=

2
```

---

# Why Dynamic Programming Works

Every value depends only on a smaller value that has already been computed.

Processing numbers in increasing order guarantees:

```
dp[i - offset]
```

already exists.

---

# Common Mistakes

## Recomputing Bit Counts

Using the Hamming Weight solution for every number gives:

```
O(32n)
```

Although still linear, it repeats unnecessary work.

DP reuses previous answers.

---

## Forgetting to Update Offset

When reaching:

```
2

4

8

16
```

the largest power of two changes.

Always update:

```java
offset *= 2;
```

---

## Confusing Offset with Highest Set Bit

They are the same.

Example:

```
13

↓

1101
```

Highest set bit:

```
1000

=

8
```

This is exactly the offset.

---

# Interview Explanation

"I observe that numbers between consecutive powers of two repeat the previous block of answers with one additional leading 1 bit. I maintain the current power of two as an offset. For every number, removing this highest power of two leaves a smaller number whose bit count has already been computed. Therefore, the recurrence is `dp[i] = 1 + dp[i - offset]`, allowing every value to be computed in constant time."

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(n)
```

---

# Key Takeaway

The important recurrence is:

```java
dp[i] = 1 + dp[i - offset];
```

where:

```
offset
```

is the largest power of two less than or equal to `i`.

Every new power-of-two block is simply the previous block with one extra leading `1`, making this one of the cleanest dynamic programming patterns involving binary numbers.