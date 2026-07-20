# Palindromic Substrings

## Problem

Given a string `s`, return the number of **palindromic substrings** contained in `s`.

A palindrome is a string that reads the same forwards and backwards.

---

# Example

Input:

```
s = "aaa"
```

Output:

```
6
```

Explanation:

The palindromic substrings are:

```
"a"
"a"
"a"

"aa"
"aa"

"aaa"
```

Total:

```
6
```

---

# Key Observation

Every palindrome has a **centre**.

There are two types of palindrome centres:

## Odd Length Palindromes

Example:

```
aba

 ^
```

The centre is a single character.

Expand from:

```
(i, i)
```

---

## Even Length Palindromes

Example:

```
abba

 ^^
```

The centre is between two characters.

Expand from:

```
(i, i + 1)
```

---

# Approach: Expand Around Center

For every character:

1. Expand around the character itself.
2. Expand around the gap after the character.

Every successful expansion represents:

```
one valid palindrome
```

So increment the count every time:

```java
s.charAt(left) == s.charAt(right)
```

---

# Why This Works

Every palindrome has exactly one centre.

By checking:

```
n odd centres

+

n-1 even centres
```

we examine every possible palindrome exactly once.

---

# Algorithm

For each index:

### Odd Expansion

```
left = i
right = i
```

Example:

```
abcba
  ^
```

---

### Even Expansion

```
left = i
right = i + 1
```

Example:

```
abccba
  ^^
```

---

During expansion:

```
while characters match:

    count palindrome

    move left outward

    move right outward
```

---

# Complexity

There are:

```
2n - 1
```

possible centres.

Each centre can expand up to:

```
O(n)
```

Therefore:

Time:

```
O(n²)
```

Space:

```
O(1)
```

---

# Why Not Brute Force?

A string with length `n` has:

```
n(n+1)/2
```

substrings.

Generating every substring:

```
O(n²)
```

Checking each substring:

```
O(n)
```

Total:

```
O(n³)
```

The expand-around-centre approach avoids unnecessary substring generation.

---

# Pattern Recognition

Keywords:

- Count palindromes
- Longest palindrome
- Symmetry
- Expand

Think:

```
Expand Around Center
```

---

# Related Problems

- Longest Palindromic Substring
- Valid Palindrome
- Palindromic Substrings
- Longest Palindromic Subsequence  