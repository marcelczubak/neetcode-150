# 📉 Min Stack

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Stack, Design Data Structure

---

## ❓ Problem

Design a stack that supports the following operations in O(1) time:

- push(x)
- pop()
- top()
- getMin()

---

## 💡 Approach

Each stack entry stores:

- the value
- the minimum value seen up to that point

So every element "remembers" the minimum at the time it was added.

---

## 🧠 Key Insight

Instead of tracking global state, we store **state per node**.

Each stack entry looks like:

[value, minSoFar]

---

## 🚀 Algorithm

### Push

When pushing a new value:

- If stack is empty → min = val
- Else → min = min(val, current min from top)

Push `[val, min]`.

---

### Pop

Remove top element.

---

### Top

Return value at top.

---

### GetMin

Return min stored at top.

---

## ⏱️ Time Complexity

All operations are O(1):

- push → O(1)
- pop → O(1)
- top → O(1)
- getMin → O(1)

---

## 💾 Space Complexity

O(n)

Each element stores extra metadata.

---

## 🔑 Why This Works

We avoid recomputing the minimum by storing it at each step.

This converts a global tracking problem into a local one.

---

## 📚 What I Learned

- Stack can store composite state (value + metadata)
- Maintaining history avoids recalculation
- Global variables are not needed for tracking min
- Each operation should preserve full state consistency

---

## 🧠 Pattern Recognition

If you see:

- Need to track min/max in a stack
- O(1) retrieval required
- State changes over time

Think:

✔ Store extra info per stack element  
✔ Pair (value, metadata)  
✔ Avoid global variables  

---

## 🔄 Similar Problems

- Max Stack
- Sliding Window Minimum
- Design Stack with Increment Operation
- Histogram problems (state tracking)