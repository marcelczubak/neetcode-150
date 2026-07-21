# Word Break Notes

## Pattern

Dynamic Programming

Specifically:

```
DFS + Memoization
```

---

# Main Insight

The brute force approach:

```
Try every possible word split
```

creates many repeated calculations.

Example:

```
catsanddog
```

Possible paths:

```
cat + sand + dog

cats + and + dog
```

Both can reach the same remaining suffix.

Therefore:

```
cache by index
```

---

# DP State

The state is:

```
dfs(index)
```

Meaning:

> Can the substring starting at index be segmented?

Example:

```
leetcode

index = 4

remaining:
code
```

Question:

```
Can "code" be broken?
```

---

# Base Case

When:

```
index == s.length()
```

we consumed the entire string.

Therefore:

```
return true
```

---

# Transition

At every index:

Try every word in the dictionary.

Example:

```
s = "leetcode"

index = 0
```

Try:

```
leet
```

matches.

Move:

```
index = 4
```

Now solve:

```
code
```

---

# Memoization

Cache:

```
memo[index]
```

Stores:

```
true  -> suffix can be segmented

false -> suffix cannot be segmented
```

Example:

```
memo[4] = true
```

means:

```
s.substring(4)
```

is valid.

---

# Implementation Flow

```
wordBreak()

        |
        v

dfs(index = 0)

        |
        |
        +-- try every word
                |
                |
                +-- matches?
                        |
                        |
                        +-- dfs(next index)
```

---

# Important Java Methods

## Check prefix match

Current:

```java
s.substring(index,index+word.length()).equals(word)
```

Better:

```java
s.startsWith(word,index)
```

---

# Common Mistakes

## 1. Wrong DP state

Bad:

```
dfs(word,index)
```

The previous word does not matter.

Good:

```
dfs(index)
```

Only the remaining suffix matters.

---

## 2. Forgetting memoization

Without caching:

```
exponential time
```

because the same indexes are recomputed.

---

## 3. Moving index incorrectly

Correct:

```
index + word.length()
```

because we consumed that word.

---

# Interview Explanation

"I use DFS where the state is the current index in the string. At each position I try every dictionary word and check if it matches the current substring. If it does, I recursively solve the remaining suffix. Since different choices can lead to the same index, I memoize the result for each index, reducing the exponential search into dynamic programming."

---

# Complexity

Time:

```
O(n * m * k)
```

Space:

```
O(n)
```

where:

```
n = string length
m = dictionary size
k = word length
```

---

# Recognition Tip

When you see:

"Can a string be split into valid pieces?"

Think:

```
DFS(index)
+
memo[index]
```