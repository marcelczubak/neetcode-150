# Edit Distance Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization
- Two Strings

---

# Core Idea

Define:

```java
getMinDist(i, j)
```

as:

```text
Minimum number of operations required to transform:

word1[i...]

into

word2[j...]
```

State:

```text
(i, j)
```

---

# Base Cases

## word1 Exhausted

```java
if (i >= word1.length())
```

Need to insert every remaining character from `word2`.

```java
return word2.length() - j;
```

Example:

```text
word1 = ""

word2 = "abc"
```

Answer:

```text
3
```

---

## word2 Exhausted

```java
if (j >= word2.length())
```

Need to delete every remaining character from `word1`.

```java
return word1.length() - i;
```

Example:

```text
word1 = "abc"

word2 = ""
```

Answer:

```text
3
```

---

# Matching Characters

If:

```java
word1.charAt(i) == word2.charAt(j)
```

No operation is needed.

Move both pointers:

```java
getMinDist(i+1, j+1)
```

Cost:

```text
0
```

---

# Mismatch

If the characters differ, choose the cheapest of three operations:

```text
Insert

Delete

Replace
```

---

# Insert

Insert `word2[j]`.

The character from `word2` is now handled.

```text
(i, j+1)
```

Cost:

```text
1
```

Think:

```text
word1[i] is still waiting
word2[j] has been matched
```

---

# Delete

Delete `word1[i]`.

The character from `word1` is now handled.

```text
(i+1, j)
```

Cost:

```text
1
```

---

# Replace

Replace:

```text
word1[i]
```

with:

```text
word2[j]
```

Both characters are now handled.

```text
(i+1, j+1)
```

Cost:

```text
1
```

---

# Recurrence

Mismatch:

```text
1 + min(
    insert,
    delete,
    replace
)
```

Conceptually:

```text
                 (i,j)
              /    |    \
         Insert  Delete  Replace
           /       |        \
      (i,j+1)   (i+1,j)   (i+1,j+1)
```

---

# Memoization

Cache:

```java
cache[i][j]
```

Meaning:

```text
Minimum edit distance from this state.
```

Before solving:

```java
if (cache[i][j] != null)
    return cache[i][j];
```

After solving:

```java
cache[i][j] = result;
```

---

# Example

```text
word1 = "horse"

word2 = "ros"
```

At each mismatch, the recursion considers:

```text
Insert

Delete

Replace
```

while matching characters are skipped with zero cost.

Memoization prevents the same `(i,j)` suffix pair from being solved repeatedly.

---

# Common Mistakes

## Wrong Insert Transition

Insert should be:

```java
(i, j+1)
```

not:

```java
(i+1, j+1)
```

Because inserting a character handles `word2[j]`, but does not consume `word1[i]`.

---

## Wrong Delete Transition

Delete should be:

```java
(i+1, j)
```

because only `word1[i]` is removed.

---

## Wrong Replace Transition

Replace should be:

```java
(i+1, j+1)
```

because both characters have been handled.

---

## Charging for Matching Characters

If:

```java
word1.charAt(i) == word2.charAt(j)
```

do not add `1`.

Simply:

```java
getMinDist(i+1, j+1)
```

---

## Incorrect Base Cases

If `word1` is exhausted:

```text
remaining word2 characters
=
number of insertions
```

If `word2` is exhausted:

```text
remaining word1 characters
=
number of deletions
```

---

# Interview Explanation

"I define the state as `(i, j)`, representing the minimum edit distance between the remaining suffixes of the two strings. If the current characters match, I move both pointers without adding a cost. Otherwise, I consider the three allowed operations: insert, delete, and replace, each with a cost of one, and take the minimum. Since many `(i, j)` states repeat, I memoize them, giving an `O(mn)` solution."

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

The most important thing is remembering what each operation does to the pointers:

```text
INSERT
(i, j+1)

DELETE
(i+1, j)

REPLACE
(i+1, j+1)
```

Each operation costs `1`.

If the characters already match:

```text
(i+1, j+1)
```

with cost `0`.

Once these transitions are understood, the entire edit-distance recurrence follows naturally.