# Regular Expression Matching

## Problem

Given two strings:

- `s` — the input string
- `p` — the pattern

determine whether the entire string `s` matches the pattern `p`.

The pattern supports two special characters:

- `.` — matches any single character
- `*` — matches zero or more occurrences of the character immediately before it

The match must cover the **entire** string.

---

## Example

```text
s = "aa"
p = "a"
```

Output:

```text
false
```

Because `a` only matches one character.

---

```text
s = "aa"
p = "a*"
```

Output:

```text
true
```

Because `a*` can match both `a`s.

---

```text
s = "ab"
p = ".*"
```

Output:

```text
true
```

Because `.*` can match any sequence of characters.

---

# Approach

## DFS + Memoization

Define:

```java
match(i, j)
```

as:

> Whether `s[i...]` matches `p[j...]`.

The state is:

```text
(i, j)
```

where:

- `i` = current position in `s`
- `j` = current position in `p`

Memoization stores whether each state is `true` or `false`.

---

# Base Case

If the pattern is exhausted:

```java
if (j >= p.length())
```

then the match is successful only if the string is also exhausted:

```java
return i >= s.length();
```

This ensures the **entire** string must be matched.

---

# Checking a Character Match

Before handling `*`, determine whether the current characters match:

```java
boolean firstMatch =
    i < s.length() &&
    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
```

There are two possibilities:

```text
Exact character match

OR

Pattern contains '.'
```

The `i < s.length()` check prevents an out-of-bounds access.

---

# Handling `*`

The important observation is that `*` belongs to the character immediately before it.

For:

```text
a*
```

the `*` can represent:

```text
zero a's
one a
two a's
three a's
...
```

Therefore, there are two fundamental choices.

---

## Choice 1: Use `*` Zero Times

Skip both:

```text
character
*
```

Move:

```text
j → j + 2
```

```java
match(i, j + 2)
```

This means:

```text
"Don't use this character* at all."
```

---

## Choice 2: Use `*` One or More Times

If the current character matches:

```java
firstMatch
```

consume one character from `s` but stay at the same pattern position:

```java
match(i + 1, j)
```

Why don't we advance `j`?

Because the same `*` can consume another character.

---

# `*` Recurrence

If:

```text
p[j+1] == '*'
```

then:

```text
match(i,j)
=
match(i,j+2)
OR
(
    firstMatch
    AND
    match(i+1,j)
)
```

In code:

```java
result =
    match(i, j+2)
    ||
    (firstMatch && match(i+1, j));
```

---

# Normal Character

If the next pattern character is not `*`, there is only one possible move.

The current characters must match:

```text
firstMatch
```

and then both pointers advance:

```text
(i+1, j+1)
```

Therefore:

```java
result = firstMatch && match(i+1, j+1);
```

---

# Example: `aa` vs `a*`

```text
s = "aa"
p = "a*"
```

At the first `a`:

```text
a matches a
```

The `*` gives two choices:

```text
ZERO a's
```

or:

```text
ONE OR MORE a's
```

The recursion explores both possibilities.

The successful branch repeatedly consumes characters from `s` while keeping `j` on the `a` in `a*`.

Eventually:

```text
s = ""
p = "a*"
```

The `*` can match zero remaining characters, so the pattern advances by two and becomes exhausted.

---

# Why Memoization Is Necessary

The `*` operation creates branching.

For example:

```text
match(i,j)
```

can call:

```text
match(i,j+2)
```

and:

```text
match(i+1,j)
```

Different recursive paths can reach the same `(i,j)` state.

The answer for a state never changes, so cache it:

```java
cache[i][j]
```

This prevents repeatedly solving the same suffix-matching problem.

---

# Algorithm

1. Create a `Boolean[][]` cache.
2. Start at `(0,0)`.
3. If the pattern is exhausted, check whether the string is also exhausted.
4. Determine whether the current characters match.
5. If the next pattern character is `*`:
   - try zero occurrences
   - or consume one matching character and keep `*` available
6. Otherwise:
   - require a match
   - advance both pointers
7. Memoize the result.
8. Return the result.

---

# Complexity

Let:

```text
m = s.length()
n = p.length()
```

There are at most:

```text
(m + 1) × (n + 1)
```

unique states.

Each state performs constant work apart from recursive calls that are memoized.

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

- String matching
- A pattern with special rules
- Choices that can consume different numbers of characters
- Repeated recursive states

Think:

```text
DFS + Memoization
```

The key is to identify what each special pattern character allows you to do.

---

# Key Insight

The most important part of this problem is understanding `*`.

For:

```text
x*
```

there are two choices:

```text
Skip x*
```

```text
j + 2
```

or:

```text
Use x*
```

```text
i + 1
```

while keeping `j` unchanged.

That second transition is what allows `*` to consume multiple characters.