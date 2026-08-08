# Edit Distance

## Problem

Given two strings `word1` and `word2`, return the minimum number of operations required to convert `word1` into `word2`.

The allowed operations are:

1. Insert a character
2. Delete a character
3. Replace a character

---

## Example

### Input

```text
word1 = "horse"

word2 = "ros"
```

### Output

```text
3
```

One possible sequence:

```text
horse
  ↓
rorse       replace h → r
  ↓
rose        delete r
  ↓
ros         delete e
```

---

# Approach

## DFS + Memoization (Top-Down Dynamic Programming)

At every pair of positions `(i, j)`, compare:

```text
word1[i]

and

word2[j]
```

The recursive function returns:

```text
Minimum number of operations required to transform:

word1[i...]

into

word2[j...]
```

The state is:

```text
(i, j)
```

Memoization stores the answer for each state so it is only computed once.

---

# DP State

Define:

```java
getMinDist(i, j)
```

as:

```text
Minimum edit distance between:

word1[i...]

and

word2[j...]
```

The state is completely determined by:

```text
i = current position in word1

j = current position in word2
```

---

# Base Cases

## word1 is Exhausted

If:

```java
i == word1.length()
```

there are no characters left in `word1`.

The only option is to insert all remaining characters of `word2`.

Therefore:

```java
word2.length() - j
```

operations are required.

---

## word2 is Exhausted

If:

```java
j == word2.length()
```

there are no characters left in `word2`.

The only option is to delete all remaining characters of `word1`.

Therefore:

```java
word1.length() - i
```

operations are required.

---

# Matching Characters

If:

```java
word1.charAt(i) == word2.charAt(j)
```

no operation is required.

Simply advance both pointers:

```java
getMinDist(i+1, j+1)
```

---

# Mismatching Characters

If the characters are different, there are exactly three possible operations.

---

## 1. Insert

Insert `word2[j]` into `word1`.

The current character of `word2` has now been handled, but `word1[i]` has not.

Therefore:

```text
(i, j+1)
```

Cost:

```text
1
```

---

## 2. Delete

Delete `word1[i]`.

The current character of `word1` has been handled, but `word2[j]` has not.

Therefore:

```text
(i+1, j)
```

Cost:

```text
1
```

---

## 3. Replace

Replace `word1[i]` with `word2[j]`.

Both current characters have now been handled.

Therefore:

```text
(i+1, j+1)
```

Cost:

```text
1
```

---

# Recurrence

When characters differ:

```text
1 + minimum(
    insert,
    delete,
    replace
)
```

In code:

```java
1 + Math.min(
    insert,
    Math.min(delete, replace)
)
```

Your implementation calculates the same minimum using an `if` statement.

---

# Example

```text
word1 = "ab"

word2 = "ac"
```

Compare:

```text
a vs a
```

They match:

```text
(i+1, j+1)
```

Now:

```text
b vs c
```

They differ.

Try:

```text
Insert c

Delete b

Replace b → c
```

The cheapest operation is:

```text
Replace
```

So the answer is:

```text
1
```

---

# Why Memoization Works

Without memoization, many different sequences of edits can reach the same state:

```text
(i, j)
```

The answer from that state is always the same.

Therefore:

```text
cache[i][j]
```

stores the minimum edit distance for that pair of positions.

Each state is solved only once.

---

# Complexity

Let:

```text
m = word1.length()

n = word2.length()
```

## Time Complexity

There are at most:

```text
m × n
```

unique states.

Each state performs constant work.

```text
O(mn)
```

---

## Space Complexity

Memoization table:

```text
O(mn)
```

Recursive call stack:

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

- Two strings
- Transform one into another
- Insert / Delete / Replace
- Minimize operations

Think:

```text
Dynamic Programming

+

Two String Indices

+

Three Choices
```

---

# Related Problems

- Longest Common Subsequence
- Interleaving String
- Distinct Subsequences
- Delete Operation for Two Strings