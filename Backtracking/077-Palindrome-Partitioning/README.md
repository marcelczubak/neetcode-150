# Palindrome Partitioning

## Problem

Given a string `s`, partition it into substrings such that every substring is a palindrome.

Return all possible palindrome partitioning combinations.

Example:

Input:

s = "aab"

Output:

[
["a","a","b"],
["aa","b"]
]

Explanation:

"aa" and "a" are both valid palindrome partitions.

---

# Approach

## Backtracking

This problem is solved by exploring every possible way to split the string.

At each step:

1. Choose a substring starting from the current index.
2. Check if the substring is a palindrome.
3. If valid, add it to the current partition.
4. Recursively partition the remaining string.
5. Remove the substring and try another option.

This follows the backtracking pattern:

Choose

↓

Explore

↓

Undo

---

# Recursive State

The helper function tracks:

## start

The index where the next partition should begin.

Example:

For:

"abcdef"

start = 3

means we are currently partitioning:

"def"

---

## currentPartition

Stores the palindrome substrings chosen so far.

Example:

[
"aa",
"b"
]

---

# Decision Making

From the current start index:

Try every possible ending index.

Example:

s = "aab"

start = 0

Possible substrings:

"a"

"aa"

"aab"

Only continue with palindromes.

---

# Palindrome Check

Before choosing a substring:

```java
isPalindrome(substring)
```

A substring is valid if:

Characters from both ends match while moving inward.

Example:

"racecar"

r == r

a == a

c == c

Palindrome.

---

# Backtracking Process

Example:

s = "aab"


Start:

[]

Choose:

"a"

Current:

["a"]


Continue:

Choose:

"a"

Current:

["a","a"]


Choose:

"b"

Current:

["a","a","b"]


Reached end:

Save result.


Backtrack:

Remove "b"

Try another partition:

"aa"

Result:

["aa","b"]

---

# Base Case

When:

start == s.length()

The entire string has been partitioned.

Add:

```java
result.add(new ArrayList<>(currentPartition));
```

A copy is required because the same list is modified during recursion.

---

# Complexity Analysis

Let:

n = length of string

## Time Complexity

There are up to:

2^(n-1)

possible partitions.

For each partition, palindrome checking may take:

O(n)

Total:

O(n * 2^n)

(Without palindrome optimisation.)

---

## Space Complexity

Recursion depth:

O(n)

Current partition storage:

O(n)

Total:

O(n)

(Output space not included.)

---

# Optimisation

The palindrome check can be improved.

Current approach:

1. Create substring.
2. Check palindrome.

This repeats work.

A faster approach:

Precompute a DP table:

```java
boolean[][] palindrome
```

where:

palindrome[i][j] = true

means:

s[i...j] is a palindrome.

Then palindrome checks become O(1).

---

# Common Mistakes

## Forgetting to remove after recursion

Wrong:

```java
add()
backtrack()
```

Correct:

```java
add()
backtrack()
remove()
```

---

## Moving to the wrong index

After choosing:

s[start...end]

the next search begins at:

end + 1

Not:

start + 1

---

## Adding the same list reference

Wrong:

```java
result.add(currentPartition);
```

Correct:

```java
result.add(new ArrayList<>(currentPartition));
```

---

# Pattern Recognition

When you see:

- Generate all valid partitions.
- Each part must satisfy a condition.
- Need every possible combination.

Think:

Backtracking + Validation


Template:

Choose a substring

↓

Validate

↓

Add

↓

Recurse

↓

Undo