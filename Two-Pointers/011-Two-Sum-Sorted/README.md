# ➕ Two Sum II - Input Array Is Sorted

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Two Pointers

---

## ❓ Problem

Given a 1-indexed array of integers `numbers` that is sorted in non-decreasing order, find two numbers such that they add up to a specific target.

Return the indices of the two numbers.

You may assume there is exactly one solution.

---

## 💡 Approach

Since the array is sorted, we can use a two-pointer strategy instead of a HashMap.

### Strategy:

- One pointer starts at the beginning (`left`)
- One pointer starts at the end (`right`)
- Move pointers inward based on the sum

---

## 🧠 Key Insight

Because the array is sorted:

- If sum is too large → move `right` left
- If sum is too small → move `left` right

This guarantees we find the correct pair in one pass.

---

## ⏱️ Time Complexity

O(n)

Each pointer moves at most once across the array.

---

## 💾 Space Complexity

O(1)

No extra data structures are used.

---

## 🔑 Why This Works

Sorting gives us directional information:

- Increasing left pointer increases sum
- Decreasing right pointer decreases sum

This removes the need for brute force or HashMap lookup.

---

## 📚 What I Learned

- Sorted arrays unlock two-pointer solutions
- Directional movement replaces hashing
- We can reduce space complexity from O(n) to O(1)
- Two-pointer technique is ideal for pair-finding problems

---

## 🧠 Pattern Recognition

If you see:

- Sorted array
- Find pair with target sum
- Min/max pair constraints

Think:

✔ Two Pointers  
✔ Opposite ends  
✔ Move inward based on comparison  

---

## 🔄 Similar Problems

- Two Sum (unsorted version)
- 3Sum
- 4Sum
- Container With Most Water
- Trapping Rain Water (variation)