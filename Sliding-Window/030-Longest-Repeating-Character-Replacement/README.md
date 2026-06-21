# 🔤 Longest Repeating Character Replacement

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Sliding Window + HashMap (Frequency Tracking)

---

## ❓ Problem

You are given a string `s` and an integer `k`.

You can replace at most `k` characters in the string.

Return the length of the longest substring that can be transformed into a string with all identical characters.

---

## 💡 Approach

Use a sliding window to maintain a substring.

Track:
- frequency of characters in the window
- the most frequent character count (`maxFreq`)

We want to keep the window valid such that:

```text
window size - maxFreq ≤ k
```

---

## 🧠 Key Insight

We do NOT need to know exactly which characters to replace.

We only care about:

> How many characters are NOT the most frequent one in the window.

Those are the ones we would replace.

---

## 🚀 Algorithm

1. Expand `right` pointer
2. Update frequency map
3. Track `maxFreq`
4. Check if window is valid:
   - If invalid → shrink left pointer
5. Update maximum length

---

## ⏱️ Time Complexity

```text
O(n)
```

Each character is processed at most twice (once added, once removed).

---

## 💾 Space Complexity

```text
O(1)
```

At most 26 uppercase letters (or constant charset size).

---

## 🔑 Why This Works

We always maintain the largest valid window where:

```text
we can convert all characters into the most frequent character using ≤ k replacements
```

---

## 📚 What I Learned

- Sliding window with frequency tracking
- The importance of `maxFreq`
- Window validity based on replacement cost
- Expand → validate → shrink pattern

---

## 🧠 Pattern Recognition

If you see:

- “replace k characters”
- “longest repeating substring”
- “maximize uniformity”
- “at most k changes”

Think:

✔ Sliding window  
✔ Frequency map  
✔ maxFreq optimization  

---

## 🔄 Similar Problems

- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Permutation in String
- Sliding Window Maximum Variants