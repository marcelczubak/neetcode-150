# 📝 Notes

---

## 🏷️ Pattern

Stack + State Tracking (Design Problem)

---

## 🧠 Core Idea

Instead of storing only values, each stack element stores:

[value, minimumSoFar]

This allows constant-time retrieval of the minimum at any point.

---

## 🚀 Strategy

### Step 1: Push

Compute:

- if stack empty → min = val
- else → min = min(val, stack.peek()[1])

Push:

[val, min]

---

### Step 2: Pop

Remove top element.

No extra updates needed.

---

### Step 3: Top

Return:

stack.peek()[0]

---

### Step 4: Get Min

Return:

stack.peek()[1]

---

## ⚠️ Common Mistakes

- Using a single global minimum variable (breaks on pop)
- Not handling empty stack case on first push
- Forgetting that each element must store its own min
- Trying to recompute min during getMin() (O(n) mistake)
- Mixing value-only stack with min logic incorrectly

---

## 🔄 Alternative Approaches

### 1️⃣ Two Stack Method

- stack for values
- minStack for running minimums

Still O(1), slightly more space.

---

### 2️⃣ Pair Storage (this solution)

- One stack
- Each element stores [value, minSoFar]

More compact and clean.

---

## 🎯 Pattern Recognition

If you see:

- Need min/max in stack
- Constant time queries
- State changes over sequence of operations

Think:

✔ Stack with metadata  
✔ Store historical min/max  
✔ Avoid recomputation  

---

## 🧩 Key Insight

The key idea is:

> Don’t track the minimum globally — track it locally at every step