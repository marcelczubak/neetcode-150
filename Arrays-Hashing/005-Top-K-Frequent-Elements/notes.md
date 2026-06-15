# 📝 Notes

---

## 🏷️ Pattern

Frequency Map + Bucket Sort

---

## 🧠 Core Idea

This problem is NOT about counting frequencies — that's trivial.

The challenge is:

> Efficiently extracting the top k frequent elements.

---

## 🚀 Solution Breakdown

### Step 1: Frequency Map

Use HashMap:

- Key → number
- Value → frequency

This is mandatory in almost every variant.

---

### Step 2: Bucket Construction

Instead of sorting:

We use:

bucket[freq] → list of numbers with that frequency

Why this works:

- Frequency range is limited: 1 → n
- So we can index directly

---

### Step 3: Collect Answer

Traverse bucket from:

n → 1

and collect elements until k is reached.

---

## ⚠️ Common Mistakes

- Using `int[] bucket` instead of `List<Integer>[]`
- Forgetting multiple numbers can share same frequency
- Overwriting values in bucket
- Sorting original array (unnecessary and slower)
- Not stopping once k elements are collected

---

## 🔄 Similar Problems

- Sort Characters By Frequency
- K Closest Points to Origin
- Top K Largest Elements
- Task Scheduler
- Frequency Stack

---

## 🎯 Pattern Recognition

Use this approach when you see:

- “Top K”
- “Most frequent”
- “Highest occurrence”
- “Find K largest/smallest by some metric”

---

## 🧩 Key Insight

There are always 3 stages:

1. Count (HashMap)
2. Organize (Heap or Bucket)
3. Extract (Top K traversal)

If you remember this pipeline, most frequency problems become straightforward.