# Interleaving String Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Two Pointers

---

# Core Idea

At every step, the next character of `s3` must come from exactly one source:

```text
s1

or

s2
```

The recursive state is determined by how many characters have already been consumed from each string.

---

# DP State

Define:

```java
interleave(i, j)
```

Meaning:

```text
Can

s1[i...]

and

s2[j...]

form

s3[i+j...] ?
```

State:

```text
(i, j)
```

Store:

```java
cache[i][j]
```

---

# Why No Pointer for s3?

Suppose:

```text
i = 3

j = 5
```

Then:

```text
3 characters

+

5 characters
```

have already been consumed.

Therefore:

```text
Current position in s3

=

i + j
```

No third index is required.

---

# Character Matching

The next character can be taken from `s1` only if:

```java
i < s1.length()

&&

s1.charAt(i) == s3.charAt(i+j)
```

Similarly for `s2`.

Using:

```java
&&
```

prevents out-of-bounds access because Java short-circuits the expression.

---

# DP Recurrence

## Neither Matches

Return:

```text
false
```

---

## Only s1 Matches

Consume one character from `s1`.

```java
interleave(i+1, j)
```

---

## Only s2 Matches

Consume one character from `s2`.

```java
interleave(i, j+1)
```

---

## Both Match

Both choices are possible.

Explore both.

```java
interleave(i+1, j)

||

interleave(i, j+1)
```

If either succeeds, the answer is true.

---

# Base Case

When:

```java
i + j == s3.length()
```

Every character has been successfully matched.

Return:

```text
true
```

---

# Memoization

Store:

```java
cache[i][j]
```

Before solving a state:

```java
if(cache[i][j] != null)
```

return the cached answer.

Each `(i, j)` pair is solved only once.

---

# Example

```text
s1 = ab

s2 = cd

s3 = acbd
```

State:

```text
(0,0)
```

Character:

```text
a
```

Matches `s1`.

Move to:

```text
(1,0)
```

Next character:

```text
c
```

Matches `s2`.

Move to:

```text
(1,1)
```

Continue until both strings are exhausted.

---

# Why Memoization Helps

Without caching, the same state:

```text
(i,j)
```

may be reached through multiple recursive paths whenever both strings have matching characters.

Memoization guarantees:

```text
Each state is computed exactly once.
```

---

# Common Mistakes

## Using Three Pointers

Many solutions keep:

```text
(i, j, k)
```

This is unnecessary because:

```text
k = i + j
```

---

## Forgetting the Length Check

Always verify:

```java
s1.length() + s2.length() == s3.length()
```

before recursion begins.

---

## Advancing Both Strings

When both strings match the current character:

Wrong:

```java
interleave(i+1, j+1)
```

Only **one** character of `s3` is consumed per recursive call.

The correct solution explores:

```java
interleave(i+1, j)

||

interleave(i, j+1)
```

---

## Accessing Past the End

Always check:

```java
i < s1.length()
```

and

```java
j < s2.length()
```

before calling `charAt()`.

---

# Interview Explanation

"I define the DP state as `(i, j)`, representing whether the suffixes `s1[i...]` and `s2[j...]` can interleave to form `s3[i+j...]`. At each step, I check whether the next character of `s3` can come from `s1`, `s2`, or both. If both match, I recursively explore both possibilities. Since many `(i, j)` states are revisited, I memoize each result, giving an `O(mn)` dynamic programming solution."

---

# Complexity

Time:

```text
O(mn)
```

Space:

```text
O(mn)
```

for the memoization table, plus up to:

```text
O(m+n)
```

recursive stack depth.

---

# Key Takeaway

The crucial insight is defining the state as:

```text
(i, j)
```

The position in `s3` is always:

```text
i + j
```

This removes the need for a third pointer and reduces the problem to a clean two-dimensional dynamic programming solution where each state explores at most two possible transitions.