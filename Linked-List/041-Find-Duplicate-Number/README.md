# 🔍 Find the Duplicate Number

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Array + Index Marking (In-Place)

---

## ❓ Problem

Given an integer array `nums` containing `n + 1` integers where each integer is in the range `[1, n]`, return the duplicated number.

There is exactly one duplicate number, but it may appear more than once.

---

## 💡 Approach

Since every value is between `1` and `n`, each value can be treated as an index in the array.

For each number:

1. Compute its corresponding index.
2. If the value at that index is already negative, we've visited it before, so the current number is the duplicate.
3. Otherwise, negate the value at that index to mark it as visited.

The array itself is used as the visited set, eliminating the need for extra space.

---

## 🧠 Key Insight

Instead of using a `HashSet`, we use the sign of each element to indicate whether a value has been seen before.

- Positive → not visited
- Negative → already visited

---

## 🚀 Algorithm

1. Iterate through the array.
2. Take the absolute value of the current element.
3. Convert it to an index:
   ```
   index = num - 1
   ```
4. If `nums[index]` is negative:
   - Return `num`
5. Otherwise:
   - Negate `nums[index]`
6. If no duplicate is found (shouldn't happen under the problem constraints), return `-1`.

---

## ⏱️ Time Complexity

```text
O(n)
```

Each element is processed exactly once.

---

## 💾 Space Complexity

```text
O(1)
```

No extra data structures are used.

---

## 🔑 Why This Works

Every value maps to a unique index.

The first visit marks the index.

The second visit finds the index already marked, revealing the duplicate.

---

## ⚠️ Note

This solution **modifies the input array** by changing the sign of its elements.

On LeetCode, the expected optimal solution uses **Floyd's Cycle Detection** because the problem asks you not to modify the array and to use only constant extra space.

However, this solution is still an excellent demonstration of the **index marking** technique and is accepted in many interview settings where modifying the input is allowed.

---

## 📚 What I Learned

- Using an array as a visited structure
- Mapping values to indices
- In-place marking using negative values
- Eliminating the need for a `HashSet`

---

## 🧠 Pattern Recognition

If you see:

- values in the range `1...n`
- find duplicates
- constant extra space (if array modification is allowed)

Think:

✔ Index Marking

✔ In-place Visited Array

---

## 🔄 Similar Problems

- Find All Duplicates in an Array
- Find All Numbers Disappeared in an Array
- First Missing Positive