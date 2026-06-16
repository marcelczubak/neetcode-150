# 🪞 Valid Palindrome

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Two Pointers

---

## ❓ Problem

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

A palindrome reads the same forward and backward.

When checking:

- Ignore non-alphanumeric characters
- Ignore letter casing

---

## 💡 Approach

Use two pointers:

- `left` starts at the beginning
- `right` starts at the end

While the pointers have not crossed:

1. Skip non-alphanumeric characters
2. Convert both characters to lowercase
3. Compare them
4. If they differ, return `false`
5. Move both pointers inward

If the loop finishes, the string is a valid palindrome.

---

## 🧠 Key Insight

We do not need to create a cleaned copy of the string.

Instead, we can skip invalid characters on the fly while comparing from both ends.

---

## ⏱️ Time Complexity

O(n)

Each character is visited at most once.

---

## 💾 Space Complexity

O(1)

No extra data structures are required.

---

## 🔑 Why This Works

A palindrome is symmetric.

By comparing matching characters from the outside inward, we can determine validity in a single pass.

---

## 📚 What I Learned

- Two pointers are ideal for symmetric comparisons
- Input preprocessing can often be done during traversal
- Avoid creating unnecessary strings when possible
- Character utility methods (`isLetterOrDigit`, `toLowerCase`) simplify parsing

---

## 🧠 Pattern Recognition

If you see:

- Palindrome
- Mirror symmetry
- Compare front and back

Think:

✔ Two Pointers  
✔ Left and right indices  
✔ Move inward

---

## 🔄 Similar Problems

- Valid Palindrome II
- Palindromic Substrings
- Reverse String
- Merge Sorted Array