# 🔎 Minimum Window Substring

## 🎯 Difficulty

Hard

## 🏷️ Pattern

Sliding Window + Frequency Map + Two Pointers

---

## ❓ Problem

Given two strings `s` and `t`, return the **smallest substring of `s`** that contains all characters of `t` (including duplicates).

If no such substring exists, return `""`.

---

## 💡 Approach

We use a sliding window with two frequency maps:

- `freqTarget` → required characters from `t`
- `freqCurrent` → current window characters in `s`

We expand the right pointer until the window becomes valid, then shrink from the left to minimize it.

---

## 🧠 Key Insight

We do NOT need permutations or brute force.

We only track:

> When the window satisfies all frequency requirements of `t`.

Then we try to shrink it as much as possible.

---

## 🚀 Algorithm

1. Build frequency map for `t`
2. Expand `right` pointer:
   - Add character to window
   - Update `have` when a requirement is satisfied
3. When `have == need`:
   - Try shrinking window from left
   - Update minimum length
   - Remove characters while maintaining validity
4. Return smallest valid window

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

At most fixed alphabet size (or O(k) for unique characters in `t`).

---

## 🔑 Why This Works

Instead of checking all substrings, we dynamically maintain a valid window and shrink it greedily.

---

## 📚 What I Learned

- Hard sliding window pattern
- Frequency map matching
- `have / need` technique
- Expand → shrink strategy
- Maintaining minimum valid window

---

## 🧠 Pattern Recognition

If you see:

- smallest substring containing all chars
- "minimum window"
- substring with constraints

Think:

✔ Sliding window  
✔ Frequency maps  
✔ Track validity (have/need)  
✔ Shrink aggressively when valid

---

## 🔄 Similar Problems

- Permutation in String
- Longest Repeating Character Replacement
- Substring with Concatenation of All Words
- Find All Anagrams in a String
