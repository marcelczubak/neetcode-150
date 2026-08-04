# Word Break

## Problem

Given a string `s` and a dictionary of words `wordDict`, determine if `s` can be segmented into a sequence of one or more dictionary words.

A word can be used multiple times.

---

## Example 1

### Input

```
s = "leetcode"

wordDict = ["leet", "code"]
```

### Output

```
true
```

### Explanation

The string can be split as:

```
leet + code
```

Both words exist in the dictionary.

---

## Example 2

### Input

```
s = "catsandog"

wordDict = ["cats","dog","sand","and","cat"]
```

### Output

```
false
```

No valid segmentation exists.

---

# Approach

## Recursive DFS + Memoization

At every index, we ask:

> "Can the substring starting from this index be broken into valid words?"

The recursive state is:

```
index
```

meaning:

```
Can s[index...end] be segmented?
```

---

# Recursive Decision

For every dictionary word:

1. Check if the word matches the string at the current index.
2. If it matches:
    - Move forward by the word length.
    - Recursively solve the remaining suffix.

If any choice succeeds:

```
return true
```

Otherwise:

```
return false
```

---

# Why Memoization?

Without memoization, the same index can be evaluated multiple times.

Example:

```
catsanddog
```

Different choices:

```
cat + sand...
cats + and...
```

may both reach the same index.

Instead of recalculating:

```
dfs(index)
```

we store the result:

```
memo[index]
```

---

# Algorithm

1. Create a cache:

```
index -> can break?
```

2. Start DFS from index `0`.

3. At each index:
    - Return cached result if already calculated.
    - Try every dictionary word.
    - Recurse on valid matches.
    - Store the result.

4. Return the result for index `0`.

---

# Complexity

Let:

- `n` = length of string
- `m` = number of words in dictionary
- `k` = average word length

## Time Complexity

```
O(n * m * k)
```

Explanation:

- There are `n` possible starting indexes.
- For each index, we try `m` words.
- Matching a word costs up to `k`.

---

## Space Complexity

```
O(n)
```

Used for:

- Memoization cache.
- Recursion stack.

---

# Key Pattern

This problem is a classic:

```
Decision DP
```

Look for:

- "Can this be split?"
- "Does a solution exist?"
- "Number of ways"

Common approach:

```
DFS + Memoization
```

or

```
Bottom-Up DP
```

---

# Optimization Ideas

Possible improvements:

### 1. Use startsWith()

Instead of:

```java
s.substring(index, index + word.length()).equals(word)
```

use:

```java
s.startsWith(word, index)
```

Avoids creating temporary strings.

---

### 2. Use Boolean[]

Since indexes are continuous:

```java
Boolean[] memo
```

can replace:

```java
HashMap<Integer, Boolean>
```

---

### 3. Bottom-Up DP

Can convert the recursive solution into iterative DP:

```
dp[i] = whether suffix starting at i is valid
```

---

# Related Problems

- Decode Ways
- Coin Change
- Combination Sum IV
- Partition Equal Subset Sum
- Longest Increasing Subsequence