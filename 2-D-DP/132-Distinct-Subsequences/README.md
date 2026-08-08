# Distinct Subsequences

## Problem

Given two strings `s` and `t`, return the number of distinct subsequences of `s` which equal `t`.

A subsequence is formed by deleting zero or more characters from `s` while maintaining the relative order of the remaining characters.

---

## Example

### Input

```text
s = "rabbbit"
t = "rabbit"
```

### Output

```text
3
```

There are 3 different ways to choose characters from `s` to form `t`.

---

# Approach

## DFS + Memoization

Define:

```java
distinctPaths(i, j)
```

as:

```text
The number of ways to form t[j...]
using characters from s[i...].
```

The DP state is:

```text
(i, j)
```

where:

- `i` = current position in `s`
- `j` = current position in `t`

Memoization stores the answer for each state.

---

# Base Cases

## Target String Fully Matched

If:

```java
j >= t.length()
```

then we have successfully formed all of `t`.

Return:

```text
1
```

This represents one valid subsequence.

---

## Source String Exhausted

If:

```java
i >= s.length()
```

while `t` still has characters remaining, it is impossible to form `t`.

Return:

```text
0
```

---

# Recursive Choices

At every position, we consider whether to use `s[i]`.

---

## Characters Match

If:

```java
s.charAt(i) == t.charAt(j)
```

there are two choices.

### Use the Character

Use `s[i]` to match `t[j]`.

Move both pointers:

```text
(i+1, j+1)
```

---

### Skip the Character

Don't use `s[i]`.

`t[j]` is still waiting to be matched.

Move only `i`:

```text
(i+1, j)
```

Therefore:

```text
ways(i,j) =
    ways(i+1,j)
    +
    ways(i+1,j+1)
```

---

## Characters Don't Match

If:

```java
s.charAt(i) != t.charAt(j)
```

then `s[i]` cannot be used to match `t[j]`.

The only option is to skip `s[i]`:

```text
ways(i+1,j)
```

---

# Example

```text
s = "aaa"
t = "aa"
```

At the first `a`, there are two choices:

```text
USE
```

or:

```text
SKIP
```

This branching continues through the remaining characters.

Different choices of which occurrences to use produce different subsequences.

The total number of valid paths is:

```text
3
```

---

# Why Memoization Works

The same `(i, j)` state can be reached through many different choices.

For example:

```text
(i, j)
```

always represents the same problem:

```text
How many ways can t[j...] be formed from s[i...]?
```

Therefore its answer never changes.

Cache:

```java
cache[i][j]
```

and reuse the result.

---

# Algorithm

1. Create a `2D` memoization array.
2. Start DFS from `(0, 0)`.
3. If `t` is exhausted, return `1`.
4. If `s` is exhausted first, return `0`.
5. If the current characters match:
   - skip `s[i]`
   - or use `s[i]`
6. If they don't match:
   - skip `s[i]`
7. Store the result in the cache.
8. Return the number of valid subsequences.

---

# Complexity

Let:

```text
m = s.length()
n = t.length()
```

There are at most:

```text
m × n
```

unique states.

Each state performs constant work.

### Time

```text
O(mn)
```

### Space

Memoization:

```text
O(mn)
```

Recursive stack:

```text
O(m+n)
```

Overall:

```text
O(mn)
```

---

# Pattern Recognition

When you see:

- Count subsequences
- Match one string against another
- Preserve character order
- Choices of using/skipping characters

Think:

```text
DFS

+

Two String Indices

+

Memoization
```

---

# Related Problems

- Longest Common Subsequence
- Interleaving String
- Edit Distance
- Word Break
- Longest Increasing Subsequence