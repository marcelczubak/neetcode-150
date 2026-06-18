# 🌡️ Daily Temperatures

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Monotonic Stack (Decreasing Stack)

---

## ❓ Problem

Given an array of integers `temperatures`, return an array `answer` such that:

answer[i] = number of days you have to wait after day i to get a warmer temperature.

If there is no future day with a warmer temperature, set answer[i] = 0.

---

## 💡 Approach

Use a **monotonic decreasing stack** that stores indices of days.

The stack keeps track of days that are still waiting for a warmer temperature.

---

## 🧠 Key Insight

Instead of looking forward for every day (O(n²)), we store unresolved days in a stack.

When a warmer temperature arrives:
> we resolve all previous days that are smaller than it.

---

## 🚀 Algorithm

1. Create result array filled with 0
2. Initialize empty stack
3. Iterate through temperatures:
   - While stack is not empty AND current temp > stack top temp:
     - pop index
     - set result[prevIndex] = currentIndex - prevIndex
   - push current index

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

Each index waits until the next greater element appears.

The stack ensures we only revisit each index when necessary.

---

## 📚 What I Learned

- Monotonic stack avoids nested loops
- We store indices, not values
- One element can resolve many previous elements
- Stack represents "waiting states"
- Always use while loop for resolving multiple matches

---

## 🧠 Pattern Recognition

If you see:

- Next greater element
- Next warmer day
- First larger value to the right
- “How long until condition is met?”

Think:

✔ Monotonic stack  
✔ Store indices  
✔ Resolve when condition breaks monotonic order  

---

## 🔄 Similar Problems

- Next Greater Element I & II
- Stock Span Problem
- Car Fleet
- Largest Rectangle in Histogram
- Trapping Rain Water (stack version)