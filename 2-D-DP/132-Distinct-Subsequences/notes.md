# Distinct Subsequences Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Two Strings
- Counting DP

---

# Core Idea

Define:

```java
distinctPaths(i, j)
```

as:

```text
Number of ways to form t[j...]
using characters from s[i...].
```

State:

```text
(i, j)
```

---

# Base Cases

## t Exhausted

```java
if (j >= t.length())
    return 1;
```

We successfully formed the entire target.

There is exactly **one successful way from this point**:

```text
Do nothing.
```

---

## s Exhausted

```java
if (i >= s.length())
    return 0;
```

There are still characters of `t` remaining, so forming the target is impossible.

---

# Matching Characters

If:

```java
s.charAt(i) == t.charAt(j)
```

there are two choices.

### Use

Use `s[i]` to match `t[j]`:

```text
(i+1, j+1)
```

### Skip

Ignore `s[i]`:

```text
(i+1, j)
```

Therefore:

```text
ways(i,j)
=
ways(i+1,j)
+
ways(i+1,j+1)
```

---

# Non-Matching Characters

If:

```java
s.charAt(i) != t.charAt(j)
```

`s[i]` cannot match `t[j]`.

Therefore:

```text
ways(i,j)
=
ways(i+1,j)
```

Only the source pointer advances.

---

# Important Pointer Rule

When **skipping `s[i]`**:

```text
i → i+1
j stays the same
```

When **using `s[i]` to match `t[j]`**:

```text
i → i+1
j → j+1
```

You never advance `j` when skipping a character from `s`.

---

# Example

```text
s = "aaa"
t = "aa"
```

The first `a` can either be:

```text
USED
```

or:

```text
SKIPPED
```

This creates the branching needed to count all possible choices.

```text
             (0,0)
             /   \
           USE   SKIP
           /       \
       (1,1)      (1,0)
```

Eventually the different branches count the different ways of selecting characters.

---

# Memoization

Use:

```java
Integer[][] cache
```

where:

```text
cache[i][j]
```

stores:

```text
Number of ways to form t[j...]
from s[i...]
```

Before computing:

```java
if (cache[i][j] != null)
    return cache[i][j];
```

After computing:

```java
cache[i][j] = paths;
```

---

# Why Memoization Is Necessary

Without memoization, matching characters create two recursive branches:

```text
USE

or

SKIP
```

This creates an exponential recursion tree.

However, many branches eventually reach the same:

```text
(i, j)
```

state.

Memoization collapses those repeated subproblems.

---

# Common Mistakes

## Advancing j When Skipping

Wrong:

```java
distinctPaths(i, j+1)
```

when skipping `s[i]`.

Correct:

```java
distinctPaths(i+1, j)
```

---

## Forgetting the Skip Branch When Characters Match

Even when:

```text
s[i] == t[j]
```

you cannot always use that occurrence.

You must consider:

```text
USE

OR

SKIP
```

This is essential for counting distinct subsequences.

---

## Returning 1 When s Is Exhausted

Wrong:

```text
s = ""

t = "abc"
```

There are zero ways to form `"abc"`.

Return:

```text
0
```

---

## Returning 0 When t Is Exhausted

Wrong.

If:

```text
t = ""
```

the target has already been successfully formed.

Return:

```text
1
```

---

# Interview Explanation

"I define a DP state `(i, j)` representing the number of ways to form the remaining target `t[j...]` from the remaining source `s[i...]`. If the current characters match, I can either use the source character or skip it. If they don't match, I must skip it. When the target is exhausted, I've found one valid subsequence; when the source is exhausted first, there are zero. I memoize each `(i, j)` state to avoid recomputing the same subproblem."

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

for the memoization table, plus:

```text
O(m+n)
```

for the recursive call stack.

---

# Key Takeaway

The central recurrence is:

```text
MATCH:

USE
(i+1, j+1)

+

SKIP
(i+1, j)
```

while:

```text
NO MATCH:

SKIP
(i+1, j)
```

The key insight is that **you are counting choices of characters from `s`**, not moving through `t` independently.

That is why the "skip" operation always advances `i` while leaving `j` unchanged.