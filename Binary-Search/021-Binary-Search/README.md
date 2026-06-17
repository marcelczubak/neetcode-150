# 🔎 Binary Search

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Binary Search, Divide & Conquer

---

## ❓ Problem

Given a sorted array `nums` and a target value, return the index of the target if it exists. Otherwise return `-1`.

You must achieve O(log n) time complexity.

---

## 💡 Approach

Binary search works by repeatedly dividing the search space in half.

At each step:
- Compare target with middle element
- Eliminate half of the array

---

## 🧠 Key Insight

Instead of searching linearly, we **discard half the search space each iteration**.

This is only possible because the array is sorted.

---

## 🚀 Algorithm

1. Initialize `left = 0`, `right = n - 1`
2. While `left <= right`:
   - Compute `mid`
   - If `nums[mid] == target`, return `mid`
   - If `nums[mid] < target`, search right half
   - Else search left half
3. If not found, return `-1`

---

## ⏱️ Time Complexity

O(log n)

Each iteration halves the search space.

---

## 💾 Space Complexity

O(1)

No extra data structures used.

---

## 🔑 Why This Works

Sorted order allows us to determine which half of the array cannot contain the target.

We eliminate that half each step.

---

## 📚 What I Learned

- Binary search is about elimination, not movement
- Always shrink the search space (`mid ± 1`)
- Mid calculation must avoid infinite loops
- Sorted order is required for correctness

---

## 🧠 Pattern Recognition

If you see:

- Sorted array
- Find element / condition
- O(log n) requirement

Think:

✔ Binary search  
✔ Halve search space  
✔ Compare middle element  

---

## 🔄 Similar Problems

- Search Insert Position
- First/Last Position of Element
- Koko Eating Bananas
- Find Peak Element