# 🔄 Permutation in String

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Fixed-Size Sliding Window + Frequency Counting

---

## ❓ Problem

Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, otherwise return `false`.

A permutation contains exactly the same characters with exactly the same frequencies.

---

## 💡 Approach

Instead of generating all permutations of `s1`, we compare character frequencies.

Create:

- A frequency array for `s1`
- A frequency array for the current window in `s2`

Maintain a window of size:

```text
s1.length()
```

If the frequency arrays match, then the current window is a permutation of `s1`.

---

## 🧠 Key Insight

Two strings are permutations of each other if:

```text
Their character frequencies are identical.
```

Therefore, the problem becomes:

> Does any substring of length `s1.length()` in `s2` have the same frequency count as `s1`?

---

## 🚀 Algorithm

1. Build frequency count for `s1`
2. Build frequency count for the first window in `s2`
3. Compare frequency arrays
4. Slide the window:
   - Remove left character
   - Add new right character
5. Compare frequency arrays after each shift
6. Return true if a match is found

---

## Example

```text
s1 = "ab"
s2 = "eidbaooo"
```

Window progression:

```text
ei
id
db
ba  ← match
ao
oo
oo
```

At:

```text
ba
```

frequency counts match:

```text
a = 1
b = 1
```

Return:

```text
true
```

---

## ⏱️ Time Complexity

```text
O(n)
```

Each window shift updates frequencies in constant time.

Frequency comparison costs:

```text
O(26)
```

which is constant.

Overall:

```text
O(n)
```

---

## 💾 Space Complexity

```text
O(1)
```

Two arrays of size 26.

---

## 🔑 Why This Works

A permutation must contain the same characters with the same counts.

By maintaining frequency counts for a fixed-size window, we can efficiently determine whether a permutation exists without generating any permutations.

---

## 📚 What I Learned

- Fixed-size sliding windows
- Frequency counting using arrays
- Character mapping with:

```java
c - 'a'
```

- Window updates in O(1)

---

## 🧠 Pattern Recognition

If you see:

- permutations
- anagrams
- same character frequencies
- substring existence

Think:

✔ Frequency arrays  
✔ Fixed-size sliding window  
✔ Compare counts  

---

## 🔄 Similar Problems

- Find All Anagrams in a String
- Longest Repeating Character Replacement
- Minimum Window Substring
- Longest Substring Without Repeating Characters