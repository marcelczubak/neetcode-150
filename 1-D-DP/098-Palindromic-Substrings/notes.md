# Palindromic Substrings Notes

## Pattern

```
Expand Around Center
```

---

# Core Idea

Instead of checking every substring:

```
Generate substring

↓

Check palindrome
```

start from the middle and expand outward.

---

# Types of Centers

## Odd Palindrome

Example:

```
racecar

   e
```

Center:

```java
(i, i)
```

---

## Even Palindrome

Example:

```
abba

  bb
```

Center:

```java
(i, i+1)
```

---

# Algorithm

For every index:

Count odd palindromes:

```java
expand(i, i)
```

Count even palindromes:

```java
expand(i, i + 1)
```

---

# Expansion Logic

Continue while:

```java
left >= 0

right < s.length()

s.charAt(left) == s.charAt(right)
```

Every successful expansion means:

```
found palindrome
```

Increment count.

---

# Example

String:

```
"aaa"
```

Centers:

```
a   a   a
```

Odd expansions:

```
a
a
a
aaa
```

Even expansions:

```
aa
aa
```

Total:

```
6
```

---

# Complexity

Number of centres:

```
2n - 1
```

Each can expand:

```
O(n)
```

Total:

```
O(n²)
```

Space:

```
O(1)
```

---

# Connection to Longest Palindromic Substring

Same technique.

Difference:

Longest Palindrome:

```
Store longest length
```

Palindromic Substrings:

```
Count every successful expansion
```

---

# Interview Explanation

"Every palindrome has a centre, and there are only two types of centres: a single character for odd-length palindromes and a gap between characters for even-length palindromes. I expand around every possible centre and increment the count whenever the characters match. This counts every palindrome exactly once in O(n²) time and O(1) space."

---

# Common Mistake

Only checking:

```java
expand(i, i)
```

misses even length palindromes:

```
aa

abba
```

Always check:

```java
expand(i, i)

expand(i, i+1)
```

---

# Related Problems

- Longest Palindromic Substring
- Valid Palindrome
- Longest Palindromic Subsequence
- Shortest Palindrome
```