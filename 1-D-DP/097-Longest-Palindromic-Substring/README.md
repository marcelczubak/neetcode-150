# Longest Palindromic Substring

## Problem

Given a string `s`, return the **longest palindromic substring**.

A palindrome reads the same forwards and backwards.

---

# Example

Input:

```
s = "babad"
```

Output:

```
"bab"
```

or

```
"aba"
```

Both are valid.

---

# Key Observation

Every palindrome has a **center**.

There are only two possible types:

### Odd Length

```
racecar

   e
```

Expand outward from one character.

---

### Even Length

```
abba

  bb
```

Expand outward from the gap between two characters.

---

# Expand Around Center

For every index `i`:

Expand around:

```
(i, i)
```

Odd-length palindrome.

Then expand around:

```
(i, i + 1)
```

Even-length palindrome.

During expansion:

```
left--

right++
```

while:

```
characters match
```

Whenever a longer palindrome is found, update:

```
start
end
```

---

# Why This Works

Every palindrome has exactly one center.

Since there are:

```
n odd centers

+

n-1 even centers
```

checking every center guarantees we find the longest palindrome.

---

# Algorithm

For each character:

```
Expand odd center.

Expand even center.
```

Whenever:

```
currentLength > bestLength
```

update:

```
start

end
```

Return:

```java
s.substring(start, end + 1);
```

---

# Complexity

There are:

```
2n-1
```

possible centers.

Each expansion can take:

```
O(n)
```

Worst case:

```
"aaaaaaa"
```

Time:

```
O(n²)
```

Space:

```
O(1)
```

No extra data structures are used.

---

# Why Not Check Every Substring?

A string of length `n` contains:

```
n(n+1)/2
```

substrings.

Checking each one individually would require:

```
O(n³)
```

The center expansion approach improves this to:

```
O(n²)
```

---

# Pattern Recognition

Keywords:

- Palindrome
- Longest substring
- Expand
- Symmetry

↓

Think:

```
Expand Around Center
```

---

# Related Problems

- Palindrome Number
- Valid Palindrome
- Longest Palindromic Subsequence
- Palindromic Substrings