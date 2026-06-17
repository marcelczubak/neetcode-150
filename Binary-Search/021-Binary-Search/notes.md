# 📝 Notes

---

## 🏷️ Pattern

Binary Search (Divide & Conquer)

---

## 🧠 Core Idea

We repeatedly divide the search space in half.

At each step:

- Compare target with middle element
- Decide which half to discard

---

## 🚀 Algorithm

### Step 1: Initialize pointers

```text
left = 0
right = n - 1
```

---

### Step 2: Loop while search space exists

```text
while left <= right
```

---

### Step 3: Compute mid safely

```java
mid = left + (right - left) / 2
```

---

### Step 4: Compare mid

- If equal → return mid
- If target > mid → move right half
- If target < mid → move left half

---

## ⚠️ Common Mistakes

- Using `while (left <= mid)` instead of `left <= right`
- Setting `left = mid` instead of `mid + 1`
- Setting `right = mid` instead of `mid - 1`
- Infinite loops due to non-shrinking range
- Forgetting sorted array requirement
- Using linear scan (O(n)) instead of O(log n)

---

## 🔄 Alternative Approaches

### 1️⃣ Linear Search
O(n) time — simple but slow

---

### 2️⃣ Binary Search (Optimal)
O(log n) time — uses divide & conquer

---

## 🎯 Pattern Recognition

If you see:

- Sorted data
- Search problem
- Optimization from O(n) → O(log n)

Think:

✔ Binary search  
✔ Eliminate half each step  
✔ Maintain left/right bounds  

---

## 🧩 Key Insight

Binary search is not about finding quickly.

It is about:

> eliminating impossible search space efficiently