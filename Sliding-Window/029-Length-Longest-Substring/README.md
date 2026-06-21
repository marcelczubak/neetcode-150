# 🔤 Longest Substring Without Repeating Characters

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Sliding Window + HashSet

---

## ❓ Problem

Given a string `s`, find the length of the longest substring without repeating characters.

---

## 💡 Approach

Use a sliding window to maintain a substring with all unique characters.

We expand the right pointer step by step, and if a duplicate is found, we shrink the left pointer until the window becomes valid again.

---

## 🧠 Key Insight

At any point:

> The window `[left, right]` must contain all unique characters.

If a duplicate appears, we remove characters from the left until it is removed.

---

## 🚀 Algorithm

1. Initialize:
   - `left = 0`
   - `maxLength = 0`
   - HashSet to track characters in window

2. Move `right` from 0 → n:
   - If `s[right]` is not in set:
     - add it
     - update maxLength
   - Else:
     - shrink window from left until duplicate is removed
     - then add current character

3. Return `maxLength`

---

## ⏱️ Time Complexity

```text
O(n)
```

Each character is added and removed at most once.

---

## 💾 Space Complexity

```text
O(min(n, charset))
```

HashSet stores at most all unique characters in window.

---

## 🔑 Why This Works

We never restart the window from scratch.

Instead, we reuse previous work by maintaining a valid window at all times.

---

## 📚 What I Learned

- Sliding window pattern for substring problems
- HashSet is useful for tracking duplicates efficiently
- Right pointer expands, left pointer fixes invalid state
- Window size is always `right - left + 1`

---

## 🧠 Pattern Recognition

If you see:

- substring problems
- “longest without repeating”
- “at most k distinct”
- contiguous constraints

Think:

✔ Sliding window  
✔ HashSet / HashMap  
✔ Expand right, shrink left  

---

## 🔄 Similar Problems

- Longest Repeating Character Replacement
- Minimum Window Substring
- Permutation in String
- Find All Anagrams in a String