# 🔗 Longest Consecutive Sequence

## 🎯 Difficulty
Medium

## 🏷️ Pattern
HashSet, Sequence Expansion, Start-Point Optimization

---

## ❓ Problem

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must solve it in O(n) time.

---

## 💡 Approach

The key idea is to avoid sorting and instead use a HashSet for O(1) lookups.

We only start counting a sequence when we find a valid starting point.

---

## 🧠 Key Insight

A number is the start of a sequence if:

👉 `num - 1` is NOT in the set

This ensures we do not recompute sequences multiple times.

---

## 🚀 Algorithm

### Step 1: Build a HashSet
Store all numbers for O(1) lookup.

### Step 2: Identify sequence starts
Only begin counting when:
- `num - 1` does not exist in the set

### Step 3: Expand forward
Count how far the consecutive sequence goes using:
- `num + 1`, `num + 2`, ...

---

## ⏱️ Time Complexity

O(n)

Each element is visited at most twice:
- once in the set iteration
- once in sequence expansion

---

## 💾 Space Complexity

O(n)

Used by the HashSet.

---

## 🔑 Key Insight

Instead of building sequences from every number, we only start from true “starting points.”

This avoids redundant work and guarantees linear time.

---

## 📚 What I Learned

- HashSet enables O(1) sequence expansion
- Avoid sorting when order is not required
- The “start condition” (`num - 1` missing) is critical for efficiency
- Repeated work elimination is key in O(n) solutions

---

## 🧠 Pattern Recognition

If you see:

- Longest sequence
- Consecutive numbers
- Chain / streak problems

Think:

✔ HashSet  
✔ Start-point detection  
✔ Expand outward  

---

## 🔄 Similar Problems

- Number of Islands (graph version of expansion)
- Connected components
- Sliding window streak problems