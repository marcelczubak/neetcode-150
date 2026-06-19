# 🔍 Search a 2D Matrix

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search

---

## ❓ Problem

You are given an `m x n` integer matrix with the following properties:

- Each row is sorted in ascending order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer `target`, return `true` if the target exists in the matrix, otherwise return `false`.

You must achieve O(log(m × n)) time complexity.

---

## 💡 Approach

Treat the entire matrix as a single sorted array.

Because:

- Rows are individually sorted.
- Each row starts with a value greater than the previous row's last value.

The matrix behaves like:

```text
[
  1, 3, 5, 7,
 10,11,16,20,
 23,30,34,60
]
```

We can therefore perform standard binary search.

---

## 🧠 Key Insight

Convert a 1D index into a 2D coordinate:

```java
row = index / n;
col = index % n;
```

This allows us to access any element as if the matrix were flattened.

---

## 🚀 Algorithm

1. Set:
   - left = 0
   - right = m × n - 1

2. While left <= right:
   - Compute mid
   - Convert mid into row and column
   - Compare matrix[row][col] with target

3. Return true if found

4. Otherwise return false

---

## ⏱️ Time Complexity

O(log(m × n))

Binary search over all elements.

---

## 💾 Space Complexity

O(1)

No additional data structures used.

---

## 🔑 Why This Works

The matrix is globally sorted.

Flattening is unnecessary because:

```java
matrix[mid / n][mid % n]
```

gives direct access to the equivalent flattened index.

This preserves O(1) lookup while achieving O(log(m × n)) search.

---

## 📚 What I Learned

- Binary search can be applied to virtual arrays
- Index arithmetic can replace flattening
- Row and column conversion is useful in matrix problems
- A sorted matrix can often be treated as a sorted list

---

## 🧠 Pattern Recognition

If you see:

- Sorted matrix
- O(log n) requirement
- Matrix behaves like a sorted array

Think:

✔ Binary Search  
✔ Index mapping  
✔ Virtual flattening  

---

## 🔄 Similar Problems

- Binary Search
- Search Insert Position
- Search in Rotated Sorted Array
- Koko Eating Bananas
- Find Peak Element