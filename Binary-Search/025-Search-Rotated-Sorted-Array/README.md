# 🔍 Search in Rotated Sorted Array

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search

---

## ❓ Problem

You are given a rotated sorted array of unique integers and a target value.

Return the index of the target if it exists, otherwise return `-1`.

You must achieve O(log n) time complexity.

---

## 💡 Approach

Even though the array is rotated, one half of the current search space is always sorted.

At each step:

1. Find the midpoint.
2. Determine which half is sorted.
3. Check whether the target lies within the sorted half.
4. Discard the impossible half.

This preserves the binary search property.

---

## 🧠 Key Insight

For any midpoint:

```java
nums[left] <= nums[mid]
```

means:

```text
Left half is sorted
```

Otherwise:

```text
Right half is sorted
```

Once we know which half is sorted, we can determine whether the target belongs in that half.

---

## 🚀 Algorithm

1. Initialize:
   - left = 0
   - right = n - 1

2. While left <= right:
   - Compute mid
   - If nums[mid] == target → return mid

3. Determine which half is sorted

4. If target lies inside the sorted half:
   - search that half

5. Otherwise:
   - search the other half

6. Return -1 if target is not found

---

## ⏱️ Time Complexity

O(log n)

Binary search eliminates half of the remaining search space each iteration.

---

## 💾 Space Complexity

O(1)

Only pointers are used.

---

## 🔑 Why This Works

A rotated sorted array still contains ordered structure.

At least one side of every midpoint remains sorted.

By identifying the sorted side and checking whether the target belongs there, we can safely discard half the search space every iteration.

---

## 📚 What I Learned

- Rotated arrays still support binary search
- One side of the array is always sorted
- We search based on ranges rather than direct comparisons
- Binary search can be adapted to non-standard ordering

---

## 🧠 Pattern Recognition

If you see:

- Rotated sorted array
- O(log n) requirement
- Unique values

Think:

✔ Binary Search  
✔ Identify sorted half  
✔ Range checking  

---

## 🔄 Similar Problems

- Find Minimum in Rotated Sorted Array
- Binary Search
- Search a 2D Matrix
- Koko Eating Bananas