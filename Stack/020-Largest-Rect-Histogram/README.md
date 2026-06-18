# 📊 Largest Rectangle in Histogram

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Monotonic Stack (Increasing Stack)

---

## ❓ Problem

Given an array of bar heights representing a histogram, find the area of the largest rectangle that can be formed.

Each bar has width 1.

---

## 💡 Approach

Use a **monotonic increasing stack of indices**.

The stack maintains bars in increasing height order.

When a smaller bar appears, it acts as a **boundary**, allowing us to compute areas for taller bars.

---

## 🧠 Key Insight

Each bar can be treated as the **minimum height of a rectangle**.

We compute:

- Left boundary: previous smaller element
- Right boundary: next smaller element

The stack helps find both efficiently.

---

## 🚀 Algorithm

1. Initialize stack with `-1` as sentinel
2. Iterate through histogram:
   - While current height ≤ height at stack top:
     - pop index
     - compute area using popped height
   - push current index
3. After loop:
   - pop remaining elements and compute areas

---

## ⏱️ Time Complexity

O(n)

Each index is pushed and popped at most once.

---

## 💾 Space Complexity

O(n)

Stack stores indices.

---

## 🔑 Why This Works

We delay computing area until we know the **next smaller element**.

This ensures we correctly determine the right boundary for each bar.

---

## 📚 What I Learned

- Stack stores indices of increasing heights
- Popping means we found the right boundary
- Left boundary comes from stack.peek()
- Each bar is processed exactly once
- Sentinel (-1) simplifies boundary cases

---

## 🧠 Pattern Recognition

If you see:

- “largest rectangle / area”
- range-based maximum
- next smaller element needed
- histogram or bar-like structure

Think:

✔ monotonic increasing stack  
✔ compute boundaries on pop  
✔ treat each element as limiting height  

---

## 🔄 Similar Problems

- Trapping Rain Water
- Daily Temperatures
- Car Fleet (conceptual stack version)
- Next Greater / Smaller Element problems