# 📝 Notes

---

## 🏷️ Pattern

Monotonic Increasing Stack

---

## 🧠 Core Idea

We maintain a stack of indices where heights are in increasing order.

When we encounter a smaller height:

> we finalize rectangles for all taller bars in the stack.

---

## 🚀 Strategy

### Step 1: Use stack of indices

Stack stores indices of bars with increasing height.

We also push:

```text
-1 (sentinel boundary)
```

---

### Step 2: Iterate through histogram

For each index i:

- While current height ≤ height[stack.top]:
  - pop index
  - compute rectangle area

---

### Step 3: Compute area on pop

When we pop an index j:

- height = heights[j]
- right boundary = i
- left boundary = stack.peek()

So:

```text
width = i - stack.peek() - 1
area = height × width
```

---

### Step 4: Final cleanup

After traversal:

- Remaining stack elements extend to end of array
- Pop and compute areas using:
  - right boundary = n

---

## ⚠️ Common Mistakes

- Using values instead of indices in stack
- Forgetting sentinel (-1)
- Using `if` instead of `while`
- Not processing remaining stack after loop
- Miscalculating width boundaries
- Thinking greedily instead of boundary-based

---

## 🔄 Alternative Approaches

### ❌ Brute Force
Try all subarrays → O(n²) or O(n³)

---

### ✅ Monotonic Stack (Optimal)
Each element is pushed/popped once → O(n)

---

## 🎯 Pattern Recognition

If you see:

- histogram / bars
- “largest area” problems
- next smaller element required
- range expansion questions

Think:

✔ monotonic increasing stack  
✔ resolve on boundary violation  
✔ compute area on pop  

---

## 🧩 Key Insight

Each bar is:

> a potential limiting height of a rectangle

We compute its maximum possible width only when we discover its boundaries.