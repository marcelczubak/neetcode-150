# 🔄 Find Minimum in Rotated Sorted Array

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search

---

## ❓ Problem

Suppose an array sorted in ascending order is rotated between 1 and n times.

Find the minimum element in O(log n) time.

All values are unique.

---

## 💡 Approach

The array consists of two sorted portions.

At any point:

- One side contains the minimum.
- The other side is fully sorted.

Use binary search to determine which half contains the minimum.

---

## 🧠 Key Insight

Compare:

```java
nums[mid]
```

with:

```java
nums[right]
```

If:

```java
nums[mid] > nums[right]
```

the minimum must be in the right half.

Otherwise:

```java
nums[mid] <= nums[right]
```

the minimum is in the left half (including mid).

---

## 🚀 Algorithm

1. Initialize:
   - left = 0
   - right = n - 1

2. While left < right:
   - Compute mid
   - Compare nums[mid] with nums[right]

3. If nums[mid] > nums[right]:
   - search right half

4. Otherwise:
   - search left half including mid

5. Return nums[left]

---

## ⏱️ Time Complexity

O(log n)

---

## 💾 Space Complexity

O(1)

---

## 🔑 Why This Works

One side of the rotated array is always sorted.

Comparing against the right boundary reveals which side contains the rotation point (minimum).

---

## 📚 What I Learned

- Binary search is not only for finding values
- Comparing boundaries can reveal structure
- Rotated arrays still contain sorted information
- Sometimes we search for a position, not a target

---

## 🧠 Pattern Recognition

If you see:

- Rotated sorted array
- O(log n) requirement
- Unique elements

Think:

✔ Binary Search  
✔ Compare with boundary values  
✔ Find pivot / minimum  

---

## 🔄 Similar Problems

- Search in Rotated Sorted Array
- Koko Eating Bananas
- Search a 2D Matrix
- Find Peak Element