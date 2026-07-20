# Longest Palindromic Substring Notes

## Pattern

```
Expand Around Center
```

---

# Core Idea

Every palindrome grows outward from a center.

Two possible centers:

Odd:

```
aba

 ^
```

Even:

```
abba

 ^^
```

Check both.

---

# Algorithm

For every index:

```
Expand(i, i)

Expand(i, i+1)
```

While:

```
left >= 0

right < n

s[left] == s[right]
```

Continue expanding.

---

# Update Answer

Instead of repeatedly creating substrings:

Store:

```java
start

end
```

When a longer palindrome is found:

```java
start = left;

end = right;
```

At the very end:

```java
return s.substring(start, end + 1);
```

Only one substring is created.

---

# Why Store Indices?

Creating:

```java
substring(...)
```

inside every expansion allocates many temporary strings.

Storing:

```
start

end
```

is cleaner and avoids unnecessary object creation.

---

# Complexity

Centres:

```
2n-1
```

Maximum expansion:

```
O(n)
```

Overall:

```
O(n²)
```

Space:

```
O(1)
```

---

# Comparison

### Brute Force

Generate every substring.

```
O(n²)
```

For each:

Check palindrome.

```
O(n)
```

Total:

```
O(n³)
```

---

### Expand Around Center

Expand only from valid centers.

```
O(n²)
```

Huge improvement.

---

# Interview Explanation

"I observed that every palindrome has a unique center. Instead of checking every substring, I expanded outward from every possible odd and even center. Whenever I found a longer palindrome, I stored its start and end indices. This reduces the brute-force O(n³) solution to O(n²) while using only constant extra space."

---

# Recognition Pattern

If you see:

- Longest palindrome
- Palindromic substring
- Mirror symmetry

↓

Think:

```
Expand Around Center
```

---

# Follow-Up

There is an optimal algorithm:

```
Manacher's Algorithm
```

Time:

```
O(n)
```

It is considerably more complex and is rarely expected in interviews unless specifically asked.

---

# Similar Problems

- Palindromic Substrings
- Valid Palindrome
- Longest Palindromic Subsequence
- Shortest Palindrome