# 🔺 3Sum

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Sorting + Two Pointers

---

## ❓ Problem

Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:

nums[i] + nums[j] + nums[k] == 0

You must avoid duplicate triplets.

---

## 💡 Approach

We reduce the 3Sum problem into multiple 2Sum problems.

### Strategy:

1. Sort the array
2. Fix one element `nums[i]`
3. Use two pointers (`left`, `right`) to find pairs such that:

nums[left] + nums[right] = -nums[i]

---

## 🧠 Key Insight

Instead of searching for three numbers directly, we:

> Fix one number and solve a 2Sum problem on the remaining array.

Sorting enables efficient two-pointer traversal.

---

## ⚡ Deduplication Strategy

To avoid duplicate triplets:

### 1. Skip duplicate fixed elements:
If nums[i] == nums[i - 1], skip.

### 2. Skip duplicate left/right values after finding a valid triplet.

---

## ⏱️ Time Complexity

O(n²)

- Outer loop: O(n)
- Two-pointer scan: O(n)

---

## 💾 Space Complexity

O(1) extra space (excluding output)

---

## 🔑 Why This Works

Sorting provides structure:

- Smaller values on the left
- Larger values on the right

This allows directional movement instead of brute force searching.

---

## 📚 What I Learned

- 3Sum = repeated 2Sum problem
- Sorting enables two-pointer optimization
- Deduplication is required at multiple levels
- Always compute sum once per iteration for clarity
- Pointer movement encodes problem constraints

---

## 🧠 Pattern Recognition

If you see:

- Triplets / combinations
- Sum = target (especially 0)
- Need unique results

Think:

✔ Sort array  
✔ Fix one element  
✔ Two pointers for remaining pair  
✔ Skip duplicates  

---

## 🔄 Similar Problems

- 2Sum II
- 4Sum
- kSum generalization
- Combination Sum variants