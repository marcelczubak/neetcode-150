# Regular Expression Matching Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- String Matching

---

# Core Idea

Define:

```java
match(i, j)
```

as:

```text
Whether s[i...] matches p[j...].
```

State:

```text
(i, j)
```

Cache:

```java
cache[i][j]
```

---

# Base Case

Pattern exhausted:

```java
if (j >= p.length())
    return i >= s.length();
```

If the pattern is finished, the string must also be finished.

---

# Current Character Match

```java
boolean firstMatch =
    i < s.length() &&
    (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
```

A character matches if:

```text
s[i] == p[j]
```

or:

```text
p[j] == '.'
```

The bounds check prevents:

```java
s.charAt(i)
```

from going out of bounds.

---

# `*` Is the Important Part

If:

```java
p.charAt(j+1) == '*'
```

then the character before `*` can occur:

```text
0, 1, 2, 3, ...
```

times.

There are two choices.

---

# Choice 1: Skip `x*`

For:

```text
x*
```

use zero occurrences.

Skip both `x` and `*`:

```java
match(i, j+2)
```

The string pointer does not move.

---

# Choice 2: Consume One Character

If:

```java
firstMatch == true
```

consume one character from `s`:

```java
match(i+1, j)
```

Notice:

```text
i → i+1
j stays the same
```

This keeps the `*` available to consume more characters.

---

# `*` Decision Tree

```text
                 (i, j)
                /      \
             ZERO     USE ONE
              /          \
       (i, j+2)        (i+1, j)
```

The second branch is only valid when:

```text
firstMatch == true
```

Therefore:

```java
match(i, j+2)
||
(firstMatch && match(i+1, j))
```

---

# Normal Character

If there is no `*` immediately after the current pattern character:

```java
result =
    firstMatch &&
    match(i+1, j+1);
```

Both characters are consumed.

---

# Pointer Rules

## Normal Match

```text
s[i] matches p[j]

→ (i+1, j+1)
```

---

## `*` — Zero Occurrences

```text
skip x*

→ (i, j+2)
```

---

## `*` — One or More Occurrences

```text
consume s[i]

→ (i+1, j)
```

The pattern pointer stays on the `x` because `*` can consume another character.

---

# Example

```text
s = "aaa"

p = "a*"
```

The `a*` can consume:

```text
0 a's
1 a
2 a's
3 a's
```

The recursion represents this by repeatedly choosing:

```text
(i+1, j)
```

until it eventually chooses:

```text
(i, j+2)
```

to consume zero more occurrences of `a`.

---

# Example: `.*`

```text
s = "abc"

p = ".*"
```

`.` matches any character.

`*` allows the `.` to repeat.

So:

```text
.*
```

can consume:

```text
a
ab
abc
```

or even zero characters.

---

# Memoization

Many recursive paths can reach the same:

```text
(i, j)
```

state.

Store:

```java
cache[i][j]
```

Before calculating:

```java
if (cache[i][j] != null)
    return cache[i][j];
```

After calculating:

```java
cache[i][j] = result;
```

---

# Common Mistakes

## Advancing `j` When Consuming `*`

Wrong:

```java
match(i+1, j+1)
```

when using one occurrence of `x*`.

Correct:

```java
match(i+1, j)
```

because `*` can continue consuming characters.

---

## Only Considering One `*` Option

You need both:

```text
zero occurrences
```

and:

```text
one or more occurrences
```

when `firstMatch` is true.

---

## Forgetting `firstMatch`

You cannot consume a character using `*` unless the character matches the preceding pattern character.

So:

```java
firstMatch && match(i+1, j)
```

is necessary.

---

## Treating `*` as "Any Characters"

`*` does **not** independently match anything.

For:

```text
a*
```

the `*` means:

```text
zero or more a's
```

For:

```text
.*
```

`.` matches any character, and `*` allows it to repeat.

---

## Not Requiring the Entire String to Match

This is not substring matching.

For example:

```text
s = "abc"

p = "a"
```

must return:

```text
false
```

because the pattern ends before the string does.

---

# Interview Explanation

"I define the state `(i, j)` as whether the suffix of `s` starting at `i` matches the suffix of `p` starting at `j`. I first determine whether the current characters match. If the next pattern character is `*`, I have two choices: skip the `x*` entirely, or, if the current character matches, consume one character from `s` while keeping the pattern pointer on `x` so the star can consume more. If there is no `*`, both pointers advance only when the characters match. I memoize each `(i, j)` state."

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

for the cache, plus:

```text
O(m+n)
```

for the recursion stack.

---

# Key Takeaway

The entire problem revolves around one transition:

```text
x*

ZERO occurrences:
(i, j+2)

ONE OR MORE:
(i+1, j)
```

Once you understand why `j` stays fixed when `*` consumes a character, the rest of the solution follows naturally.
```