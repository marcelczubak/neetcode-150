# ➗ Product of Array Except Self

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Prefix Product + Suffix Product

---

## ❓ Problem

Given an integer array `nums`, return an array `result` such that:

result[i] is equal to the product of all elements of `nums` except `nums[i]`.

You must solve it without using division and in O(n) time.

---

## 💡 Approach

Instead of computing a total product, we break the problem into two parts:

### 1️⃣ Prefix Product
For each index, compute the product of all elements to the left.

### 2️⃣ Suffix Product
Traverse from the right and multiply by product of all elements to the right.

---

## 🧠 Key Insight

Each index is the result of:

left product × right product

So we decompose the problem instead of aggregating everything globally.

---

## ⏱️ Time Complexity

O(n)

We do two linear passes through the array.

---

## 💾 Space Complexity

O(1) extra space (excluding output array)

We reuse the output array for prefix storage.

---

## 🔑 Why This Works

We avoid division and avoid recomputing products by reusing intermediate results from both directions.

---

## 📚 What I Learned

- Global aggregation (total product) is not always the right approach
- Breaking problems into prefix/suffix often simplifies array problems
- Reusing output array can reduce space complexity
- Two-pass solutions are very common in interview problems

---

## 🧠 Pattern Recognition

If you see:

- “product except self”
- “exclude current index”
- “compute without using current element”

Think:

✔ Prefix accumulation  
✔ Suffix accumulation  
✔ Combine both passes

---

## 🔄 Similar Problems

- Trapping Rain Water
- Maximum Subarray variants
- Range sum queries
- Subarray product problems