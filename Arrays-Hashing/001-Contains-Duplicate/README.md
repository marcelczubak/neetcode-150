# 🧩 Contains Duplicate

## 🎯 Difficulty

Easy

## 🏷️ Pattern

Arrays, HashSet

## ❓ Problem

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## 💡 Approach

Use a `HashSet` to keep track of numbers that have already been seen.

As we iterate through the array:

1. Check whether the current number already exists in the set.
2. If it does, a duplicate has been found → return `true`.
3. Otherwise, add the number to the set.

If the loop finishes, all elements are unique.

## ⏱️ Time Complexity

`O(n)`

We visit each element once.

## 💾 Space Complexity

`O(n)`

In the worst case, all elements are unique and stored in the set.

## 🔑 Key Insight

A `HashSet` provides average `O(1)` lookup time, allowing us to detect duplicates without comparing every pair of elements.

## 📚 What I Learned

* `HashSet` is useful for fast existence checks.
* Using extra memory can significantly improve runtime.
* This is one of the most common Array + Hashing patterns.
