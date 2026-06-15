# 🏆 Top K Frequent Elements

## 🎯 Difficulty
Medium

## 🏷️ Pattern
HashMap + Bucket Sort / Heap

---

## ❓ Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in any order.

---

## 💡 Approach

The solution is built in two main steps:

### 1️⃣ Count Frequencies

First, use a HashMap to count how many times each number appears.

Example:

nums = [1,1,1,2,2,3]

→
1 → 3  
2 → 2  
3 → 1  

---

### 2️⃣ Group by Frequency (Bucket Idea)

Instead of sorting, group numbers by their frequency.

We create an array where:

- index = frequency
- value = list of numbers with that frequency

Then:

- Traverse from highest frequency → lowest
- Collect elements until we have k results

---

## ⏱️ Time Complexity

O(n)

- One pass to build frequency map
- One pass to fill buckets
- One pass to collect results

---

## 💾 Space Complexity

O(n)

- HashMap for frequencies
- Bucket storage for grouping elements

---

## 🔑 Key Insight

Instead of sorting elements by frequency (O(n log n)), we exploit the fact that:

> Frequency is bounded between 1 and n

This allows us to use **bucket indexing** for linear-time grouping.

---

## 📚 What I Learned

- Frequency counting is always step 1 in these problems
- Bucket sort avoids sorting entirely
- Multiple values can share the same frequency
- Always think: "Can I trade sorting for indexing?"

---

## 🧠 Pattern Recognition

If you see:

- "Top K"
- "Most frequent"
- "Highest occurring"

Then think:

1. HashMap for frequency
2. Heap OR Bucket Sort for retrieval

---

## 🔄 Alternative Approaches

### 🟡 Heap (Priority Queue)
- Maintain a min-heap of size k
- O(n log k)

### 🟢 Bucket Sort
- O(n)
- Best when frequency range is bounded (like here)