# Interleaving String

## Problem

Given three strings:

- `s1`
- `s2`
- `s3`

Determine whether `s3` can be formed by interleaving `s1` and `s2`.

An interleaving preserves the relative order of characters from each string.

---

## Example

### Input

```text
s1 = "aabcc"

s2 = "dbbca"

s3 = "aadbbcbcac"
```

### Output

```text
true
```

---

### Input

```text
s1 = "aabcc"

s2 = "dbbca"

s3 = "aadbbbaccc"
```

### Output

```text
false
```

---

# Approach

## DFS + Memoization (Top-Down DP)

At every step, the next character of `s3` must come from either:

- the next unused character of `s1`
- the next unused character of `s2`

This naturally forms a recursive decision tree.

Many recursive calls revisit the same state, so memoization is used to avoid recomputation.

---

# DP State

Define:

```java
interleave(i, j)
```

as:

```text
Can the suffixes

s1[i...]

and

s2[j...]

interleave to form

s3[i+j...] ?
```

The state is completely determined by:

```text
(i, j)
```

Notice that a third pointer into `s3` is unnecessary because:

```text
k = i + j
```

The number of characters already taken from `s1` and `s2` equals the number already taken from `s3`.

---

# Algorithm

### Step 1

Check the lengths.

If:

```java
s1.length() + s2.length() != s3.length()
```

return:

```text
false
```

An interleaving is impossible.

---

### Step 2

Start recursion:

```java
interleave(0, 0)
```

---

### Step 3

If this state has already been solved:

```java
cache[i][j]
```

return the cached answer.

---

### Step 4

If every character has been consumed:

```java
i + j == s3.length()
```

return:

```text
true
```

---

### Step 5

Determine whether the next character can be taken from either string.

```java
s1[i] == s3[i+j]
```

```java
s2[j] == s3[i+j]
```

---

### Step 6

Handle the possible cases.

Neither matches:

```text
false
```

Only `s1` matches:

```java
interleave(i+1, j)
```

Only `s2` matches:

```java
interleave(i, j+1)
```

Both match:

```java
interleave(i+1, j)

||

interleave(i, j+1)
```

---

### Step 7

Memoize the result before returning.

---

# Example Walkthrough

```text
s1 = "ab"

s2 = "cd"

s3 = "acbd"
```

Initially:

```text
i = 0

j = 0

k = 0
```

Current character:

```text
s3[0] = 'a'
```

Matches:

```text
s1[0]
```

Consume from `s1`.

Now:

```text
i = 1

j = 0
```

Current character:

```text
s3[1] = 'c'
```

Matches:

```text
s2[0]
```

Consume from `s2`.

Continue until every character has been matched.

---

# Why This Works

Every recursive state represents the remaining suffixes of the two source strings.

Whenever both strings can supply the next character, both possibilities must be explored.

Memoization guarantees that every `(i, j)` state is solved only once.

---

# Complexity

Let:

```text
m = s1.length()

n = s2.length()
```

## Time Complexity

There are:

```text
m × n
```

possible states.

Each is computed once.

```text
O(mn)
```

---

## Space Complexity

Memoization table:

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

- two strings forming a third
- preserve character order
- repeated recursive states

Think:

```text
Dynamic Programming

+

DFS

+

Memoization

+

Two-Pointer State
```

---

# Related Problems

- Longest Common Subsequence
- Distinct Subsequences
- Edit Distance
- Word Break