# 📊 Median of Two Sorted Arrays

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Binary Search on Partition

---

## ❓ Problem

Given two sorted arrays `nums1` and `nums2` of sizes `m` and `n`, return the median of the two sorted arrays.

The overall runtime complexity must be:

```text
O(log(m + n))
```

---

## 💡 Approach

Instead of merging the arrays, we partition them into a left half and a right half.

The goal is to find a partition such that:

```text
All elements in left half <= All elements in right half
```

Once that partition is found, the median can be computed directly from the boundary values.

---

## 🧠 Key Insight

We do **not** binary search for the median.

We binary search for the correct partition.

For every partition in `nums1`:

```java
partition2 = half - partition1
```

This ensures the left side always contains exactly half of the combined elements.

---

## Example

```text
nums1 = [1,3]
nums2 = [2]
```

Combined:

```text
[1,2,3]
```

Partition:

```text
Left  = [1,2]
Right = [3]
```

Median:

```text
2
```

---

## 🚀 Algorithm

1. Always binary search the smaller array.
2. Compute:
   - total length
   - half length
3. Choose a partition in nums1.
4. Derive partition in nums2.
5. Determine:
   - ALeft
   - ARight
   - BLeft
   - BRight
6. Check:

```java
ALeft <= BRight
&&
BLeft <= ARight
```

7. If valid:
   - compute median
8. Otherwise:
   - move partition left or right

---

## ⏱️ Time Complexity

```text
O(log(min(m,n)))
```

Binary search only occurs on the smaller array.

---

## 💾 Space Complexity

```text
O(1)
```

No extra data structures are used.

---

## 🔑 Why This Works

A valid partition guarantees:

```text
max(left side)
<=
min(right side)
```

which is exactly the condition required for the median.

---

## 📚 What I Learned

- Binary search can be applied to partitions rather than values.
- The median depends only on boundary elements.
- Difficult problems often become easier when viewed as partitioning problems.
- Edge cases can be handled cleanly using sentinel values.

---

## 🧠 Pattern Recognition

If you see:

- Two sorted arrays
- Median
- O(log n) requirement

Think:

✔ Binary Search  
✔ Partitioning  
✔ Boundary comparison  

---

## 🔄 Similar Problems

- Kth Smallest Element in Two Sorted Arrays
- Search in Rotated Sorted Array
- Find Minimum in Rotated Sorted Array
- Binary Search